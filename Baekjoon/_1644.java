import java.util.Scanner;

public class _1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        boolean[] isPrime = new boolean[num+1];
        for(int i = 2; i <= num; i++) isPrime[i] = true;

        int[] primeNum = new int[num];
        int size = 0;
        for(int i = 2; i <= num; i++){
            if(isPrime[i]){
                primeNum[size++] = i;
                for(int j = 2; j <= num; j++){
                    if(i*j <= num) isPrime[i*j] = false;
                    else break;
                }
            }

        }

        int ans = 0;
        for(int i = 0; i < size; i++){
            int sum = 0;
            for(int j = i; j < size; j++){
                sum += primeNum[j];
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
