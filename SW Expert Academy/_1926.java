import java.util.Scanner;
import java.io.FileInputStream;

class _1926
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder print = new StringBuilder();

        for(int i = 1; i <= N; i++){
            String now = Integer.toString(i);
            if(now.contains("3") || now.contains("6") || now.contains("9")){
                for(int j = 0; j < now.length(); j++){
                    if(now.charAt(j) == '3' || now.charAt(j) == '6' || now.charAt(j) == '9') print.append("-");
                }
                print.append(" ");
            }
            else {
                print.append(i).append(" ");
            }
        }
        System.out.println(print);
    }
}