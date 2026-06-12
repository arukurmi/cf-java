import java.util.*;

public class Main {
    private static String solve(Scanner sc) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long x = sc.nextLong();

        // 1. Generate all purely divided states for 'a'
        List<Long> pathA = new ArrayList<>();
        long currA = a;
        pathA.add(currA);
        while (currA > 0) {
            currA /= x;
            pathA.add(currA);
        }

        // 2. Generate all purely divided states for 'b'
        List<Long> pathB = new ArrayList<>();
        long currB = b;
        pathB.add(currB);
        while (currB > 0) {
            currB /= x;
            pathB.add(currB);
        }

        long minOps = Long.MAX_VALUE;

        // 3. Find the minimum cost to meet at a common ancestor value
        for (int i = 0; i < pathA.size(); i++) {
            for (int j = 0; j < pathB.size(); j++) {
                long currentOps = i + j + Math.abs(pathA.get(i) - pathB.get(j));
                minOps = Math.min(minOps, currentOps);
            }
        }

        return String.valueOf(minOps);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                System.out.println(solve(sc));
            }
        }
    }
}