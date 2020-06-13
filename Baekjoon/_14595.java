import java.util.Scanner;

public class _14595 {
    public static int[] tree = new int[1000001];

    public static int findParent(int x){
        if(tree[x] == 0) return x;
        return tree[x] = findParent(tree[x]);
    }
    public static int union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a == b) return a;

        tree[a] = b;
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        while(M-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();

            x = findParent(x);
            y = findParent(y);

            int now = x;
            while(now < y){
                int next = findParent(now+1);
                union(now, next);
                now = next;
            }
        }

        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(tree[i] == 0) ans++;
        }
        System.out.println(ans);
    }
}
