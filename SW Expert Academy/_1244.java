import java.util.Scanner;
import java.io.FileInputStream;

class _1244
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] inputs = sc.nextLine().split(" ");

            int len = inputs[0].length();
            int[] each = new int[len];
            for(int i = 0; i < len; i++){
                each[i] = inputs[0].charAt(i) - '0';
            }
            int change = Integer.parseInt(inputs[1]);

            int check = 0;
            while(change > 0){
                // 최대값으로 바꿨는데 교환 횟수가 남아있는 경우
                if(check == len) {
                    // 남은 교환횟수가 짝수번이라면 원래대로 돌아올 수 있으니까 끝낸다.
                    if(change % 2 == 0) break;
                    else {
                        // 남은 교환횟수가 홀수번이라면 제일 끝의 2개를 바꾼다.
                        int tmp = each[len-1];
                        each[len-1] = each[len-2];
                        each[len-2] = tmp;
                        break;
                    }

                }

                int maxIndex = len-1;
                boolean findmin = false;
                // 맨 뒤 ~ (바꾸지 않은 자리)전까지 보면서 max를 찾음.
                for(int i = len-2; i > check; i--){
                    if(each[maxIndex] < each[i]) { // 가장 뒤에 있는 숫자를 바꿔야하니까 max와 같을 때는 index를 바꿔주지 않음.
                        maxIndex = i;
                        findmin = false;
                    }
                    else if(each[maxIndex] == each[i] && maxIndex-1 == i){ // max인 숫자가 바로 앞에 또 있다면 제일 작은 값과 바꿔줘야 함.
                        findmin = true;
                    }
                }

                if(findmin) {
                    int minIndex = maxIndex;
                    for(int i = 0; i < maxIndex; i++) {
                        if(each[minIndex] > each[i]) minIndex = i;
                    }

                    int tmp = each[minIndex];
                    each[minIndex] = each[maxIndex];
                    each[maxIndex] = tmp;
                    change--;
                }
                else {
                    // 바꿀 차례의 자리의 숫자보다 뒤의 숫자들 중 최대값이 더 큰 경우, 두 숫자의 자리 바꿈
                    if(each[check] < each[maxIndex]){
                        int tmp = each[check];
                        each[check] = each[maxIndex];
                        each[maxIndex] = tmp;
                        change--;
                    }
                }

                check++;
            }
            System.out.print("#" + test_case + " ");
            for(int i = 0; i < len; i++) System.out.print(each[i]);
            System.out.println();
        }
    }
}