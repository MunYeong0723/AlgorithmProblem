import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[][] arr = new int[100][100];
    static int SIZE = 100;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            arr = new int[SIZE][SIZE];
            int ans = 0;
            int sum_dia_right = 0;
            for(int i = 0; i < SIZE; i++){
                int sum_row = 0;
                for(int j = 0; j < SIZE; j++){
                    arr[i][j] = sc.nextInt();
                    sum_row += arr[i][j];
                    if(i+j == SIZE-1) sum_dia_right += arr[i][j];
                }
                if(sum_row > ans) ans = sum_row;
            }
            if(sum_dia_right > ans) ans = sum_dia_right;
//            System.out.println("sum_dia_right : " + sum_dia_right);

            int sum_dia_left = 0;
            for(int i = 0; i < SIZE; i++){
                int sum_col = 0;
                for(int j = 0; j < SIZE; j++){
                    sum_col += arr[j][i];
                    if(i == j) sum_dia_left += arr[i][j];
                }
                if(sum_col > ans) ans = sum_col;
            }
            if(sum_dia_left > ans) ans = sum_dia_left;
//            System.out.println("sum_dia_left : " + sum_dia_left);
            System.out.println("#"+n+" "+ans);
        }
    }
}