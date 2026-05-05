import java.util.*;

public class Main {
    public static int minOperations(int[] arr, int k) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if ((arr[i] - arr[0]) % k != 0) {
                return -1;
            }
        }

        int[] temp = arr.clone();
        Arrays.sort(temp);
        int target = temp[n / 2];

        int operations = 0;

        for (int num : arr) {
            operations += Math.abs(num - target) / k;
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minOperations(arr, k));
        sc.close();
    }
}
