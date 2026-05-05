import java.util.*;

public class Main {
    public static int maxCyclicSubstringSum(String s) {
        int n = s.length();
        String doubled = s + s;

        Set<Character> set = new HashSet<>();
        int left = 0, currentSum = 0, maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {
            char ch = doubled.charAt(right);
            int value = ch - 'a' + 1;

            while (set.contains(ch) || (right - left + 1) > n) {
                char leftChar = doubled.charAt(left);
                currentSum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

            set.add(ch);
            currentSum += value;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(maxCyclicSubstringSum(s));
        sc.close();
    }
}
