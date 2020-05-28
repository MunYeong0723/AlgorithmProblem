import java.util.Scanner;

class Pair {
    int x;
    int y;
//    Pair(){}
    Pair(int a, int b) { y = a; x = b; }
}
class Stack {
    Pair[] arr = new Pair[100000];
    int top = -1;
    Stack(){}

    public void push(Pair p){ arr[++top] = p; }
    public Pair pop(){ return arr[top--]; }
    public boolean isEmpty() { return top == -1; }
}

public class _2636 {
    static int[][] graph = new int[101][101];
    static int[][] visited = new int[101][101];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void dfs_isAir(Pair start, int row, int col){
        Stack st = new Stack();
        st.push(start);
        visited[start.y][start.x] = -1;

        while(!st.isEmpty()){
            Pair tmp = st.pop();

            for(int i = 0; i < 4; i++){
                int newY = tmp.y + dy[i];
                int newX = tmp.x + dx[i];

                if(newX < 0 || newX >= col || newY < 0 || newY >= row) continue;
                if(visited[newY][newX] == -1) continue;
                if(graph[newY][newX] == 1) continue;

                st.push(new Pair(newY,newX));
                visited[newY][newX] = -1;
            }
        }
    }

    public static int dfs_cheese(Pair start, int row, int col) {
        int count = 0;
        Stack st = new Stack();

        st.push(start);
        visited[start.y][start.x] = 1;
        while(!st.isEmpty()){
            Pair tmp = st.pop();

            for(int i = 0; i < 4; i++){
                int newY = tmp.y+dy[i];
                int newX = tmp.x+dx[i];

                if(newX < 0 || newX >= col || newY < 0 || newY >= row) continue;

                if(visited[newY][newX] == -1 && graph[tmp.y][tmp.x] == 1){
                    count++;
                    graph[tmp.y][tmp.x] = 0;
                }
                else if(graph[newY][newX] == 1 && visited[newY][newX] == 0) {
                    st.push(new Pair(newY,newX));
                    visited[newY][newX] = 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cheese = 0;
        int row = sc.nextInt();
        int col = sc.nextInt();
        for(int i = 0; i < row; i++) for(int j = 0; j < col; j++) {
            int num = sc.nextInt();
            graph[i][j] = num;
            if(num == 1) cheese++;
        }

        int hour = 0;
        int count = 0;
        // 치즈가 없어질 때까지 반복
        while(true){
            visited = new int[101][101];
            // 바깥 공기 확인
            dfs_isAir(new Pair(0,0), row, col);

            count = 0;
            for(int i = 0; i < row; i++) for(int j = 0; j < col; j++){
                if(graph[i][j] == 1 && visited[i][j] == 0) {
                    count += dfs_cheese(new Pair(i,j), row, col);
                }
            }

            hour++;
            if(cheese == count) break;
            cheese -= count;
        }

        System.out.println(hour);
        System.out.println(count);

    }
}
