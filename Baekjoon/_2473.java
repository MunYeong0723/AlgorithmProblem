import java.util.Scanner;

public class _2473 {
    public static long[] arr = new long[5001];
    public static long[] newArr = new long[5001];

    public static void mergeSort(int left, int right){
        if(left<right){
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
            if(j > right) newArr[index++] = arr[i++];
            else if(i > mid) newArr[index++] = arr[j++];
            else if(arr[i] < arr[j]) newArr[index++] = arr[i++];
            else if(arr[i] >= arr[j]) newArr[index++] = arr[j++];
        }
        // copy
        for(int k = left; k <= right; k++) arr[k] = newArr[k];
    }

    public static long binarySearch(int left, int right, long find){
        while(left+1 < right){
            int mid = (left+right)/2;

            if(arr[mid] == find) return arr[mid];
            else if(arr[mid] < find) left = mid;
            else right = mid;

//            close = arr[mid];
        }
//        long close = 0;
        if(Math.abs(arr[left]-find) > Math.abs(arr[right]-find)) return arr[right];
        else return arr[left];
//        return close;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int i = 0; i < N; i++) arr[i] = sc.nextLong();

        mergeSort(0,N-1);
        long[] ans = new long[3];
        long min = 4000000000L;
        for(int i = 0; i < N-2; i++) for(int j = i+1; j < N-1; j++){
            long now = arr[i]+arr[j];

            // binary search로 now에 제일 가까운 수를 찾음
            long close = binarySearch(j+1,N-1,now*(-1));
            if(min > Math.abs(now+close)) {
                ans[0] = arr[i]; ans[1] = arr[j]; ans[2] = close;
                min = Math.abs(now+close);
            }
        }
        for(int i = 0; i < 3; i++) System.out.print("" + ans[i] + " ");
    }
}
