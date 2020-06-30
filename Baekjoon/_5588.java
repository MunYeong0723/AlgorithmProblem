import java.util.Scanner;

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class _5588 {
    static Pair[] cons_dis = new Pair[201];
    static Pair[] stars = new Pair[1001];

    public static boolean find_dis(Pair dis, int m){
        for(int i = 0; i < m-1; i++){
            if(cons_dis[i].x == dis.x && cons_dis[i].y == dis.y)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        Pair cons_start = new Pair(sc.nextInt(), sc.nextInt());
        for(int i = 1; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            cons_dis[i-1] = new Pair(cons_start.x - x, cons_start.y - y);
        }

        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            stars[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        for(int i = 0; i < n; i++){
            Pair start = stars[i];
            int check = 0;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(find_dis(new Pair(start.x-stars[j].x, start.y-stars[j].y), m)){
                    check++;
                }
            }
            if(check == m-1) {
                System.out.println((start.x - cons_start.x) + " " + (start.y - cons_start.y));
                break;
            }
        }

    }
}
