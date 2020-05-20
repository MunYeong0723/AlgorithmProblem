import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class _1208
{
    static final int SIZE = 100;
    static int[] boxes = new int[SIZE];
    static int minIndex = -1;
    static int maxIndex = -1;

    static void findMaxnMin(){
        minIndex = -1;
        maxIndex = -1;
        int min = 101; // 상자 높이의 최소는 1
        int max = 0; // 상자 높이의 최대는 100
        // find min & max
        for(int i = 0; i < SIZE; i++){
            int tmp = boxes[i];
            if(min > tmp) {min = tmp; minIndex = i;}
            if(max < tmp) {max = tmp; maxIndex = i;}
        }
    }
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int dump = sc.nextInt();
            for(int i = 0; i < SIZE; i++) boxes[i] = sc.nextInt();

            int ans = 0;
            // start dump
            while(dump-- > 0){
                findMaxnMin();
                // do dump
                boxes[minIndex] += 1;
                boxes[maxIndex] -= 1;
            }

            findMaxnMin();
            ans = boxes[maxIndex] - boxes[minIndex];
            System.out.println("#" + test_case + " " + ans);
        }
    }
}