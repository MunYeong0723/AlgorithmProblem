import java.util.Scanner;

public class _14939 {
    static int[][] now_board = new int[10][10];
    static int[] dx = {0,1,0,-1,0};
    static int[] dy = {1,0,-1,0,0};

    public static void flip(int y, int x){
        for(int i = 0; i < 5; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;

            if(now_board[ny][nx] == 0) now_board[ny][nx] = 1;
            else now_board[ny][nx] = 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] light = new char[10][10];
        for(int i = 0; i < 10; i++){
            light[i] = sc.nextLine().toCharArray();
        }

        int ans = 1000;
        for(int try_num = 0; try_num < (1<<10); try_num++){
            for(int i = 0; i < 10; i++) for(int j = 0; j < 10; j++){
                if(light[i][j] == 'O') now_board[i][j] = 1;
                else now_board[i][j] = 0;
            }

            int click = 0;
            // 첫번째 row에서 바꿀 스위치
            for(int i = 0; i < 10; i++){
                int tmp = try_num & (1<<i);
                if(tmp != 0){
                    flip(0,i);
                    click++;
                }
            }

            // 첫번째 줄이 정해지면 다음 줄부터는 눌러야하는 스위치가 정해져있음.
            for(int i = 1; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    if(now_board[i-1][j] == 1){
                        flip(i,j);
                        click++;
                    }
                }
            }

            // 마지막 row의 전구가 모두 꺼져있으면 모든 전구들이 꺼져있는 것임.
            boolean check = true;
            for(int i = 0; i < 10; i++){
                if(now_board[9][i] == 1) {check = false; break;}
            }

            if(check) {
                if(ans > click) ans = click;
            }
        }
        if(ans == 1000) ans = -1;

        System.out.println(ans);
    }
}
