import java.util.Scanner;

public class _1644 {
    public static boolean isPrime(int num){
        if(num == 1) return false;

        int end = (int) Math.sqrt(num);
        for(int i = 2; i <= end; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] prime = new int[num];
        int size = 0;
        for(int i = 2; i <= num; i++){
            if(isPrime(i)) prime[size++] = i;
        }

        int ans = 0;
        for(int i = 0; i < size; i++){
            int sum = 0;
            for(int j = i; j < size; j++){
                sum += prime[j];
                if(sum == num){
                    ans++;
                    break;
                }
                else if(sum > num) break;
            }
        }
        System.out.println(ans);
    }
}
