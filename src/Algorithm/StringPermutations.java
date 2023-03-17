package Algorithm;
import java.util.ArrayList;
import java.util.Arrays;
public class StringPermutations {
    // Iterative method to generate all permutations of a String
    public static ArrayList<String> generatePermutationsIterative(String str) {
        ArrayList<String> permutations = new ArrayList<>();
        permutations.add(String.valueOf(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            int size = permutations.size();
            for (int j = size - 1; j >= 0; j--) {
                String perm = permutations.remove(j);
                for (int k = 0; k <= perm.length(); k++) {
                    permutations.add(perm.substring(0, k) + ch + perm.substring(k));
                }
            }
        }
        return permutations;
    }

    // Recursive method to generate all permutations of a String
    public static ArrayList<String> generatePermutationsRecursive(String str) {
        ArrayList<String> permutations = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return permutations;
        }
        if (str.length() == 1) {
            permutations.add(str);
            return permutations;
        }
        char first = str.charAt(0);
        String rest = str.substring(1);
        ArrayList<String> subPerms = generatePermutationsRecursive(rest);
        for (String subPerm : subPerms) {
            for (int i = 0; i <= subPerm.length(); i++) {
                permutations.add(subPerm.substring(0, i) + first + subPerm.substring(i));
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        // Test the two permutation functions and compare the results
        String str = "ab";
        ArrayList<String> iterativePerms = generatePermutationsIterative(str);
        ArrayList<String> recursivePerms = generatePermutationsRecursive(str);
        System.out.println("Iterative permutations: " + iterativePerms);
        System.out.println("Recursive permutations: " + recursivePerms);
        System.out.println("Arrays equal: " + Arrays.equals(iterativePerms.toArray(), recursivePerms.toArray()));
    }
}
