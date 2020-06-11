package easy;

import main.model.ListNode;
import main.model.TreeNode;
import utility.Array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public ListNode solutionRec(ListNode l1, ListNode l2, int carry){
        ListNode newNode = new ListNode(((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry) % 10);
        if((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || (((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry) / 10) > 0) {
            newNode.next = solutionRec(l1 == null ? null : l1.next, l2 == null ? null : l2.next, (((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry) / 10));
        }

        return newNode;
    }

    public int numberOfSteps(int num){
        int count = 0;
        while(num > 0) {
            if(num%2 == 0)
                num = num / 2;
            else
                num --;
            count ++;
        }
        return count;
    }

    public int[] decompressRLElist(int[] nums) {
        int[] result = new int[0];
        for(int i = 0; i < nums.length; i+=2){
            int[] append = new int[nums[i]];
            for(int j = 0; j < nums[i]; j++){
                append[j] = nums[i + 1];
            }
            result = IntStream.concat(Arrays.stream(result), Arrays.stream(append))
                    .toArray();
        }
        return result;
    }

    public int subtractProductAndSum(int n) {
        int p = 1;
        int s = 0;
        while(n > 0){
            p *= n%10;
            s += n%10;
            n = n/10;
        }
        return p-s;
    }

    public int findNumbers(int[] nums) {
        int total = 0;
        for(int num : nums){
            if((num > 9  && num < 100) || (num > 999 && num < 10000) || (num > 99999 && num < 1000000))
                total ++;
        }
        return total;
    }

    public int numJewelsInStones(String J, String S) {
        int total = 0;
        for(char j : J.toCharArray()){
            for(char s : S.toCharArray()){
                if(j == s)
                    total++;
            }
        }

        return total;
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for( int i=grid.length-1; i>=0; i--){
            if(grid[i][grid[i].length-1] >= 0)
                break;
            for(int j = grid[i].length-1; j >= 0; j--){
                if(grid[i][j] < 0)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    public int balancedStringSplit(String s) {
        int maxCount = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                String ss = s.substring(i,j);
                if(areBalanced(ss)) {
                    count++;
                    i=j-1;
                    break;
                }
            }

        }
        return count;
    }

    private boolean areBalanced(String s){
        int lCount = 0;
        int rCount = 0;
        for(int j = 0; j < s.length(); j++){
            if('R' == s.charAt(j))
                rCount++;
            if('L'  == s.charAt(j))
                lCount++;
        }
        return lCount == rCount;
    }

    public int getDecimalValue(ListNode head) {
        //check for next val
        if(head.next != null){
            // add curr val * 2 and add to next val
            head.next.val += (head.val << 1);
            return getDecimalValue(head.next);
        }
        //if no next val return curr
        else{
            return head.val;
        }

    }

    public int maximum69Number (int num) {
        int x = 100000;
        int tmp = num;
        while(x > 0){
            int z = tmp/x;
            if(z == 6){
                return num + (x*3);
            }
            if(x < tmp)
                tmp %= (int) Math.pow(10, (int) Math.log10(tmp));
            x = x/10;
        }
        return num;
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0;
        int i = 0;
        while(i < points.length-1){
            distance += Math.max(Math.abs(points[i][0] - points[i+1][0]), Math.abs(points[i][1] - points[i+1][1]));
            i++;
        }
        return distance;
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int total = 0;
        if(root == null)
            return 0;
        else if ( root.val >= L && root.val <= R){
            total += root.val;
        }
        total += rangeSumBST(root.right, L, R);
        total += rangeSumBST(root.left, L, R);
        return total;
    }

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for(int[] row : matrix){
            for(int cell : row){
                cell = 0;
            }
        }
        for(int i = 0; i < indices.length; i++){
            for(int j = 0; j < matrix[indices[i][0]].length; j++){
                matrix[indices[i][0]][j] += 1;
            }
            for(int j = 0; j < matrix.length; j++){
                matrix[j][indices[i][1]] += 1;
            }
        }
        int totalOdd = 0;
        for(int[] row : matrix){
            for(int cell : row){
               if(cell % 2 != 0){
                   totalOdd++;
               }
            }
        }
        return totalOdd;
    }

    public String freqAlphabets(String s) {
        char[] cArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cArr.length; i++){
            int c = cArr[i] + 48;
            if(i+2 < cArr.length && cArr[i+2] == '#'){
                if(cArr[i] == '1') {
                    c = cArr[i + 1] + 10 + 48;
                }
                else{
                    c = cArr[i + 1] + 20 + 48;
                }
                i+=2;
            }
            sb.append((char) c);
        }
        return sb.toString();
    }

    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        for(int i = arr.length -2 ; i>-1; i--){
            int j = arr[i];
            arr[i] = max;

            if(j > max)
                max = j;
        }
        arr[arr.length-1] = -1;
        return arr;
    }

    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = i;
            sum += i;
        }
        arr[0] = 0 - sum;
        return arr;
    }

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int lSum = 1;
        for(int i = 1; i < S.length(); i++){
            char c = S.charAt(i);
            if(S.charAt(i) == '('){
                lSum ++;
            }
            if(S.charAt(i) == ')'){
                lSum --;
            }
            if(lSum != 0){
                sb.append(S.charAt(i));
            }
            else{
                lSum = 1;
                i++;
            }
        }
        return sb.toString();
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> unique = new HashSet();
        for(String word : words){
            String morseWord = "";
            for(char c : word.toCharArray()){
                morseWord += morse[c - 97];
            }
            unique.add(morseWord);
        }
        return unique.size();
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        for(int i = 0; i < A.length; i++){
            int k = 0;
            for(int j = A[i].length-1; j > -1; j--){
                result[i][k] = Math.abs(A[i][j] - 1);
                k++;
            }
        }
        return result;
    }

    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int oddLoc = A.length-1;
        int evenLoc = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i]%2 == 0) {
                result[evenLoc] = A[i];
                evenLoc++;
            }
            else {
                result[oddLoc] = A[i];
                oddLoc--;
            }
        }
        return result;
    }

    public int repeatedNTimes(int[] A) {
        int[] counts = IntStream.generate(() -> 0).limit(10000).toArray();
        int lim = A.length/2;
        for(int i = 0; i < A.length; i++){
            counts[A[i]]++;
            if(counts[A[i]] >= lim){
                return A[i];
            }
        }
        return 0;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int a : arr){
            if(m.get(a) == null)
                m.put(a, 1);
            else
                m.put(a, m.get(a)+1);
        }
        return m.values().stream().filter(i -> Collections.frequency(m.values(), i) >1)
                .collect(Collectors.toSet()).size() == 0;
    }

    public  List<Integer> selfDividingNumbers(int left, int right){
        List<Integer> result = new ArrayList<>();
        for(int i = right; i >= left; i--) {
            int number = i;
            boolean selfDividing = true;
            while (number > 0) {
                int digit = number % 10;
                if(digit == 0 || number % digit != 0){
                    selfDividing = false;
                }
                number = number / 10;
            }
            if(selfDividing){
                result.add(0, i);
            }
        }
        return result;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[i] > nums[j])
                    count++;
            }
            result[i] = count;
        }
        return result;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i <= index[i]) {
                result[index[i]] = nums[i];
            }
            else {
                for(int j = nums.length-2; j >= index[i]; j--) {
                    int next = j+1;
                    result[next] = result[j];
                }
                result[index[i]] = nums[i];
            }
        }
        return result;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2*n];
        int k = 0;
        for(int i = 0; i < n; i++){
            result[k] = nums[i];
            result[k+1] = nums[i+n];
            k = k+2;
        }
        return result;
    }
}
