import java.util.*;

public class Main{

    private static int solve(Scanner sc){
        int n;
        n = sc.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int ans = 0;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            mini = Math.min(mini, a[i]);
            maxi = Math.max(maxi, a[i]);
        }

        return maxi-mini+1;
    }


    public static void main(String[] args){
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t-- > 0){
            System.out.println(solve(sc));
        }
    }
}
