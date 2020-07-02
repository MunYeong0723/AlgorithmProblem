import java.util.Scanner;

public class _17090 {
    static char[][] maze = new char[501][501];
    static int[] arr = new int[250001];

    public static int find_parent(int x){
        if(arr[x] == x) return x;

        int p = find_parent(arr[x]);
        return arr[x] = p;
    }
    public static void union(int a, int b) {
        int par_a = find_parent(a);
        int par_b = find_parent(b);

        arr[par_a] = par_b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            maze[i] = sc.nextLine().toCharArray();
        }
        for(int i = 0; i <= n*m; i++) arr[i] = i;

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = j; int y = i;

                if(maze[i][j] == 'U') y--;
                else if(maze[i][j] == 'R') x++;
                else if(maze[i][j] == 'D') y++;
                else if(maze[i][j] == 'L') x--;

                if(x < 0 || x >= m || y < 0 || y >= n) union(i*m+j, n*m);
                else union(i*m+j, y*m+x);
            }
        }

        int ans = 0;
        for(int i = 0; i < n*m; i++){
            if(find_parent(arr[i]) == n*m) ans++;
        }
        System.out.println(ans);
    }
}
