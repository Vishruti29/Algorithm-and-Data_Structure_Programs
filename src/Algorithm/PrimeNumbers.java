package Algorithm;
import java.util.Arrays;
/*
In the above code, we first initialize an array isPrime of size n+1,
where isPrime[i] indicates whether the number i is prime or not.
We initially assume that all numbers are prime, except for 0 and 1.
We then loop through the numbers from 2 to the square root of n,
and for each prime number i, we mark all multiples of i as composite numbers by setting isPrime[j] to false.
Finally, we print all prime numbers in the range 2 to n.
 */
public class PrimeNumbers {
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
                    System.out.print(i + " ");
                }
            }
        }

        public static void main(String[] args) {
            int n = 1000;
            printPrimes(n);
        }
}
