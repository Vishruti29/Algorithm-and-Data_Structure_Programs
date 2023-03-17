package Algorithm;
import java.util.Arrays;
public class PrimeAnagramPalindrome {
    public static void printPrimes(int n) {
            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for (int i = 2; i * i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            System.out.println("Prime numbers in range 0 to " + n + ":");
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    if (isAnagram(Integer.toString(i), Integer.toString(reverse(i)))) {
                        System.out.print(i + " is anagram ");
                    }
                    if (isPalindrome(Integer.toString(i))) {
                        System.out.print(i + " is palindrome ");
                    }
                    System.out.println();
                }
            }
        }

        public static int reverse(int n) {
            int rev = 0;
            while (n > 0) {
                rev = rev * 10 + n % 10;
                n /= 10;
            }
            return rev;
        }

        public static boolean isAnagram(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            return Arrays.equals(arr1, arr2);
        }

        public static boolean isPalindrome(String s) {
            int n = s.length();
            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - i - 1)) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            int n = 1000;
            printPrimes(n);
        }
}
