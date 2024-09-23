//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;  
        long S = ((long) n * (n + 1)) / 2;
        long Sq = ((long) n * (n + 1) * (2 * n + 1)) / 6;
        long Si = 0, Sqi = 0;
        
        for (int i = 0; i < n; i++) {
            Si += arr[i];
            Sqi += ((long) arr[i] * arr[i]);
        }
        
        long X_minus_Y = S - Si;
        long X_plus_Y = (Sq - Sqi) / X_minus_Y;
        long miss = (X_minus_Y + X_plus_Y) / 2;
        long rep = X_plus_Y - miss;
        
        return new int[]{(int) rep, (int) miss};  
    }
}
