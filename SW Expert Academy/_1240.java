import java.util.Scanner;
import java.io.FileInputStream;

class _1240
{
    public static String[] nums = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();
            String code = "";
            for(int i = 0; i < N; i++) {
                String st = sc.nextLine();
                if(st.contains("1")){
                    code = st.substring(st.lastIndexOf("1")-55, st.lastIndexOf("1")+1);
                }
            }

            int[] decode = new int[9];
            int index = 1;
            int ans = 0;
            for(int i = 0; i < code.length(); i+=7){
                String now = code.substring(i, i+7);
                for(int j = 0; j < 10; j++){
                    if(now.equals(nums[j])) {
                        decode[index++] = j;
                        ans += j;
                        break;
                    }
                }
            }

            int check = (decode[1]+decode[3]+decode[5]+decode[7])*3 + decode[2]+decode[4]+decode[6]+decode[8];
            if(check % 10 == 0) System.out.println("#" + test_case + " " + ans);
            else System.out.println("#" + test_case + " 0");
        }
    }
}