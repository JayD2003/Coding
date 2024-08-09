import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/maximize-arrii-of-an-array0026/1
public class MaximizeArrayValueAfterRearrangement {
    int Maximize(int arr[]) {
        Arrays.sort(arr);
        long sum = 0L;
        for (int i=0;i<arr.length;i++){
            sum = (sum + (long) arr[i]*i) % 1000000007;
        }
        return (int) sum%1000000007;
    }
}
