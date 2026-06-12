import java.util.*;

public class Main{

    private static String solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        for(int i=0; i<n; i++){
            if(i+k < n && s.charAt(i) == s.charAt(i+k) && s.charAt(i) == '1'){
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '0');
                sb.setCharAt(i+k, '0');
                if(Integer.parseInt(String.valueOf(sb)) == 0){
                    return "YES";
                };
                sb.setCharAt(i+k, '1');
                sb.setCharAt(i+k, '1');
            }
        }
        
        return "NO";
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
