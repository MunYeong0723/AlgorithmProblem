import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class _1206
{
    static int[] dx = {-2, -1, 1, 2};
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int maxIndex = 0;

            int n = sc.nextInt();
            int[] building = new int[n];
            for(int i = 0; i < n; i++){
                int height = sc.nextInt();

                building[i] = height;
                if(i < 5 && building[maxIndex] < height) maxIndex = i;
            }

            int ans = 0;
            for(int i = 2; i <= n-3; i++){
                int nowHeight = building[i];

                // 새로 들어온 height와 현재 max 비교
                if(building[maxIndex] < building[i+2]) maxIndex = i+2;
                // 지금까지 가지고 있던 max가 범위에서 벗어난 경우
                if(maxIndex+3 == i) {
                    maxIndex = i-2;
                    for(int j = i-1; j <= i+2; j++){
                        if(building[maxIndex] < building[j]) maxIndex = j;
                    }
                }
                // view 비교
                if(building[maxIndex] == nowHeight) {
                    int min = nowHeight;
                    for(int j = 0; j < 4; j++){
                        int tmp = nowHeight - building[ i+dx[j] ];
                        if(tmp < min) min = tmp;
                    }
                    ans += min;
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}