import java.util.Scanner;

class Pair {
    int x;
    int y;

    Pair(int y, int x){
        this.x = x;
        this.y = y;
    }
}
//class Node {
//    int num = -1;
//    Pair point;
//
//    Node(int x, Pair p){
//        num = x;
//        point = p;
//    }
//}
public class _16957 {
    static int[][] arr = new int[500][500];
    static int[][] boll = new int[500][500];
    static Pair[] dp = new Pair[300001];
    static int[] dx = {-1,-1,-1,0,1,1,1,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1};

    public static Pair move(int r, int c, Pair point) {
        boolean flag = false;
        Pair min = point;
//        int min_num = arr[point.y][point.x];

        if (dp[arr[point.y][point.x]] != null) {
            // find Root
            Pair root = dp[arr[point.y][point.x]];
            boll[root.y][root.x]++;
            return root;

//            Pair root = findRoot(arr[point.y][point.x]);
//            boll[root.y][root.x]++;
        }
        else { // 주변에서 제일 작은 숫자를 찾아서 그 칸으로 이동.
            for (int i = 0; i < 8; i++) {
                int newY = point.y + dy[i];
                int newX = point.x + dx[i];

                if (newY < 0 || newY >= r || newX < 0 || newX >= c) continue;
                if (arr[newY][newX] < arr[point.y][point.x]) {
                    flag = true;
                    if (arr[newY][newX] < arr[min.y][min.x]) {
                        min = new Pair(newY, newX);
//                        min_num = arr[newY][newX];
                    }
                }
            }

            if (flag) { // 공이 이동할 위치가 있는 경우, 다음으로 이동할 칸을 dp에 저장해놓음.
                Pair root = move(r, c, min);
                dp[arr[point.y][point.x]] = root;
                return root;
            } else { // 공이 이동할 곳이 없으면 root이므로 -1과 현재 위치를 저장함.
                boll[point.y][point.x]++;
                dp[arr[point.y][point.x]] = point;
                return point;
            }
        }
    }

//    public static Pair findRoot(int index) {
//        while (true) {
//            Node tmp = dp[index];
//            if(tmp.num == -1) return tmp.point;
//            index = tmp.num;
//        }
//    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int r = sc.nextInt();
            int c = sc.nextInt();
            for(int i = 0; i < r; i++) for(int j = 0; j < c; j++){
                arr[i][j] = sc.nextInt();
            }

            for(int i = 0; i < r; i++) for(int j = 0; j < c; j++){
                move(r,c,new Pair(i,j));
            }

            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++){
                    System.out.print(""+ boll[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
