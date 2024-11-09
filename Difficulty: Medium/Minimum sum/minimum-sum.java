//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        StringBuilder num1=new StringBuilder();
        StringBuilder num2=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(i%2==0)num1.append(""+arr[i]);
            else num2.append(""+arr[i]);
        }
        StringBuilder ans=new StringBuilder();
        int m = num2.length();
        n = num1.length();
        String str1 = num1.toString();
        String str2 = num2.toString();
        int i=n-1,j=m-1,carry =0;
        while(i>-1 || j>-1 || carry!=0){
            int temp1 = i>-1?str1.charAt(i)-'0':0;
            int temp2 = j>-1?str2.charAt(j)-'0':0;
            int num = temp1+temp2+carry;
            ans.append(""+num%10);
            carry = num/10;
            i--;
            j--;
        }
        ans.reverse();
        str1 = ans.toString();
        for(i=0;i<str1.length();i++){
            if(str1.charAt(i)!='0')break;
        }
        return str1.substring(i);
    }
}
