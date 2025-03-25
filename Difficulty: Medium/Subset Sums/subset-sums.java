//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().subsetSums(arr);
            Collections.sort(result);
            // Printing the result in space-separated format
            for (int i = 0; i < result.size(); i++) {
                if (i != 0) System.out.print(" ");
                System.out.print(result.get(i));
            }
            System.out.println();    // Print new line after each test case
            System.out.println("~"); // Print new line after each test case
        }
    }
}

// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    void func(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumsubset) {
        if (ind == N) {
            sumsubset.add(sum);
            return;
        }
        // Include the current element
        func(ind + 1, sum + arr.get(ind), arr, N, sumsubset);
        // Exclude the current element
        func(ind + 1, sum, arr, N, sumsubset);  // Fixed `ind=1` issue
    }

    public ArrayList<Integer> subsetSums(int[] arr) {
        int N = arr.length;  // Corrected `.size()` issue
        ArrayList<Integer> sumsubset = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Convert int[] to ArrayList<Integer>
        for (int num : arr) {
            arrayList.add(num);
        }

        func(0, 0, arrayList, N, sumsubset);
        Collections.sort(sumsubset);
        return sumsubset;
    }
}