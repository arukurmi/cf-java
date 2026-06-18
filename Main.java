import java.util.*;

public class Main {

    private static String solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 1. Sort the array
        Arrays.sort(a);

        // 2. Group into distinct values and their counts
        List<Integer> values = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (values.isEmpty() || !values.get(values.size() - 1).equals(a[i])) {
                values.add(a[i]);
                counts.add(1);
            } else {
                int lastIdx = counts.size() - 1;
                counts.set(lastIdx, counts.get(lastIdx) + 1);
            }
        }

        int m = values.size();
        
        // suff[i] stores the count of true W states from index i to the end
        int[] suff = new int[m + 2];
        boolean[] W = new boolean[m + 1];

        int ptr = m;
        boolean possible = false;

        // 3. Process from right to left
        for (int i = m; i >= 1; i--) {
            int v_i = values.get(i - 1);
            int c_i = counts.get(i - 1);

            // Shift our two-pointer window so that values[ptr - 1] is within v_i + k
            while (ptr > i && values.get(ptr - 1) > v_i + k) {
                ptr--;
            }

            // Check if there are any winning states in our valid jump range
            int winningJumps = suff[i + 1] - suff[ptr + 1];
            boolean J_i = (winningJumps > 0);

            // Apply parity logic
            if (c_i % 2 == 0) {
                W[i] = false;
            } else {
                W[i] = !J_i;
            }

            // Update suffix sum
            suff[i] = suff[i + 1] + (W[i] ? 1 : 0);

            // If we found a starting state that hands Egor a loss, Arseniy will pick it!
            if (!W[i]) {
                possible = true;
            }
        }

        return possible ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                System.out.println(solve(sc));
            }
        }
        sc.close();
    }
}