import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class _1204
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = sc.nextInt();
            int[] score = new int[101];

            for(int i = 0; i < 1000; i++){
                score[sc.nextInt()]++;
            }

            int studentMAX = 0;
            int ans = 0;
            for(int i = 0; i < 101; i++){
                if(studentMAX <= score[i]){
                    studentMAX = score[i];
                    ans = i;
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}