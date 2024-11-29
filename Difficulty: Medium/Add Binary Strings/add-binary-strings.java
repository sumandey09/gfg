//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder ans = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int count1s = 0;
            if (i >= 0 && s1.charAt(i) == '1') count1s++;
            if (j >= 0 && s2.charAt(j) == '1') count1s++;

            if (count1s + carry == 0) {
                ans.append('0');
                carry = 0;
            } else if (count1s + carry == 1) {
                ans.append('1');
                carry = 0;
            } else if (count1s + carry == 2) {
                ans.append('0');
                carry = 1;
            } else if (count1s + carry == 3) {
                ans.append('1');
                carry = 1;
            }
            i--;
            j--;
        }

        if (carry == 1) {
            ans.append('1');
        }

        // Reverse the string
        ans.reverse();

        // Remove leading zeros if any
        int start = 0;
        while (start < ans.length() && ans.charAt(start) == '0') {
            start++;
        }

        return start == ans.length() ? "0" : ans.substring(start);
    }
}
