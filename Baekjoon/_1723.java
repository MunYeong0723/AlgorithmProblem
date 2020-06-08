import java.util.Scanner;

public class _1723 {
    static double[] angle = new double[20001];
    static double[] newAngle = new double[20001];
//    static int[] points = new int[1001];

    public static void mergeSort(int left, int right){
        if(left < right){
            int mid = (left+right)/2;
            // divide
            mergeSort(left,mid);
            mergeSort(mid+1,right);
            // conquer
            merge(left,mid,right);
        }
    }
    public static void merge(int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int index = left;
        // merge
        while(index <= right){
            if(j > right) newAngle[index++] = angle[i++];
            else if(i > mid) newAngle[index++] = angle[j++];
            else if(angle[i] < angle[j]) newAngle[index++] = angle[i++];
            else if(angle[i] >= angle[j]) newAngle[index++] = angle[j++];
        }

        // copy
        for(int k = left; k <= right; k++) angle[k] = newAngle[k];
    }

    public static int binarySearch(int left, int right, double find){
        while(left <= right){
            int mid = (left+right)/2;

            if(angle[mid] < find) left = mid+1;
            else right = mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        double center = 360.0/K;

        for(int i = 0; i < N; i++) angle[i] = sc.nextDouble();
        // sort angles
        mergeSort(0,N-1);
        // 각도에 360을 더해서 하나 더 만들어줌.
        for(int i = 0; i < N; i++) angle[i+N] = angle[i] + 360.0;

        int ans = N;
        // 다른 각도로 부채꼴을 만든 경우
        for(int i = 0; i < N; i++){
            double line = angle[i];

            int min = N;
            int max = 0;
            int end = i;
            for(int j = 0; j < K; j++){
                line += center;
                int start = end;
                // 이분탐색으로 line보다 큰 각도 중 제일 작은 각도를 찾아서 부채꼴 안에 점이 몇 개 들어있는지 찾음
                end = binarySearch(start, 2*N-1, line-0.001);

                if(min > end-start) min = end-start;
                if(max < end-start) max = end-start;
            }
            if(ans > max-min) ans = max-min;
        }
        System.out.println(ans);
    }
}
