import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Pair {
    int y;
    int x;

    Pair() {}
    Pair(int a, int b) {
        y = a;
        x = b;
    }
}
class Node {
//    int[] red;
//    int[] blue;
//
//    Node(int[] r, int[] b){
//        red = r;
//        blue = b;
//    }
    Pair red;
    Pair blue;

    Node(Pair r, Pair b){
        red = r;
        blue = b;
    }
}
class Queue {
    Node[] arr = new Node[10000]; // 빨간 구슬과 파란 구슬이 있을 수 있는 위치의 경우의 수는 100*100 이다.
    int first = 0;
    int end = 0;

    Queue() {}
    public boolean isEmpty(){
        return end == first;
    }
    public void push(Node one) {
        arr[end++] = one;
    }
    public Node pop() {
        return arr[first++];
    }
}
public class _15653 {
    static char[][] board = new char[11][11];
    static int[][][][] visited = new int[11][11][11][11];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static Node roll(Node now, Pair direction){
        int rx = now.red.x; int ry = now.red.y;
        int bx = now.blue.x; int by = now.blue.y;

        // roll red
        while(true) {
            if(board[ry][rx] == 'O') break; // 굴러가다가 구멍을 찾음

            // 더이상 못가는 경우
            if(board[ry+direction.y][rx+direction.x] != 'O'){ // 구멍인 곳에 파란색이 들어가있을 수도 있기 때문에 O가 아닌 경우를 확인해야 함.
                if(board[ry+direction.y][rx+direction.x] == '#') break;
                if(ry+direction.y == by && rx+direction.x == bx) break;
            }

            ry += direction.y;
            rx += direction.x;
        }

        // roll blue
        while(true){
            if(board[by][bx] == 'O') break; // 굴러가다가 구멍을 찾음

            // 더이상 못가는 경우
            if(board[by+direction.y][bx+direction.x] != 'O'){ // 구멍인 곳에 빨간색이 들어가있을 수도 있기 때문에 O가 아닌 경우를 확인해야 함.
                if(board[by+direction.y][bx+direction.x] == '#') break;
                if(by+direction.y == ry && bx+direction.x == rx) break;
            }

            by += direction.y;
            bx += direction.x;
        }

        // roll red
        while(true){
            if(board[ry][rx] == 'O') break; // 굴러가다가 구멍을 찾음

            // 더이상 못가는 경우
            if(board[ry+direction.y][rx+direction.x] != 'O'){ // 구멍인 곳에 파란색이 들어가있을 수도 있기 때문에 O가 아닌 경우를 확인해야 함.
                if(board[ry+direction.y][rx+direction.x] == '#') break;
                if(ry+direction.y == by && rx+direction.x == bx) break;
            }

            ry += direction.y;
            rx += direction.x;
        }

        return new Node(new Pair(ry,rx), new Pair(by,bx));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // initialize array visited
        for(int a = 0; a < 10; a++) for(int b = 0; b < 10; b++){
            for(int c = 0; c < 10; c++) for(int d = 0; d < 10; d++) visited[a][b][c][d] = -1;
        }

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        Pair red = new Pair();
        Pair blue = new Pair();
        for(int i = 0; i < N; i++) {
            String st = sc.nextLine();
            for(int j = 0; j < M; j++){
                char tmp = st.charAt(j);
                board[i][j] = tmp;

                // find where is red and blue
                if(tmp == 'R') {
                    red = new Pair(i, j);
                    board[i][j] = '.';
                }
                if(tmp == 'B') {
                    blue = new Pair(i, j);
                    board[i][j] = '.';
                }
            }
        }

        int ans = -1;
        Queue q = new Queue();
        q.push(new Node(red, blue));
        visited[red.y][red.x][blue.y][blue.x] = 0;
        outer : while(!q.isEmpty()){
            Node now = q.pop();
            int count = visited[now.red.y][now.red.x][now.blue.y][now.blue.x];

            for(int i = 0; i < 4; i++){
                Node afterRoll = roll(now, new Pair(dy[i], dx[i]));

                if(board[afterRoll.blue.y][afterRoll.blue.x] == 'O') continue; // 이 방향으로 오는 것은 잘못된 것이므로 다음으로 넘어감.

                if(board[afterRoll.red.y][afterRoll.red.x] == 'O'){
                    ans = count+1;
                    break outer;
                }

                if(visited[afterRoll.red.y][afterRoll.red.x][afterRoll.blue.y][afterRoll.blue.x] == -1){
                    visited[afterRoll.red.y][afterRoll.red.x][afterRoll.blue.y][afterRoll.blue.x] = count+1;
                    q.push(afterRoll);
                }
            }
        }
        bw.write("" + ans);
        bw.flush();
    }
}
