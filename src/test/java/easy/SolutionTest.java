package easy;

import easy.Solution;
import main.model.ListNode;
import main.model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionTest {

    Solution s = new Solution();


    @Test
    public void solTest(){
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        //n1.next = n2;
        //n2.next = n3;

        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(4);
        //n4.next = n5;
        //n5.next = n6;
        Assertions.assertEquals(0, s.solutionRec(n1, n4, 0).val);
    }

    @Test
    public void solution1342(){
        assert(s.numberOfSteps(14) == 6);
        assert(s.numberOfSteps(0) == 0);
        assert(s.numberOfSteps(123) == 12);
    }

    @Test
    public void solution1313(){
        int[] test = {1,2,3,4};
        int[] result = {2,4,4,4};
        Assertions.assertArrayEquals(result, s.decompressRLElist(test));
    }

    @Test
    public void solution1281(){
        assert(15 == s.subtractProductAndSum(234));
        assert(21 == s.subtractProductAndSum(4421));
    }

    @Test
    public void solution1295(){
        int[] test = {12,345,2,6,7896};
        Assertions.assertEquals(2, s.findNumbers(test));
        int[] test2 = {555,901,482,1771};
        Assertions.assertEquals(1, s.findNumbers(test2));
    }

    @Test
    public void solution1221(){
        Assertions.assertEquals(4, s.balancedStringSplit("RLRRLLRLRL"));
        Assertions.assertEquals(3, s.balancedStringSplit("RLLLLRRRLR"));
        Assertions.assertEquals(1, s.balancedStringSplit("LLLLRRRR"));
        Assertions.assertEquals(2, s.balancedStringSplit("RLRRRLLRLL"));
    }

    @Test
    public void solution1290(){
        ListNode n1 = new ListNode(0);
        makeNodeList(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0}, n1);
        Assertions.assertEquals(18880, s.getDecimalValue(n1));
        makeNodeList(new int[]{1,0,1}, n1);
        Assertions.assertEquals(5, s.getDecimalValue(n1));
    }

    @Test
    public void maximum69Number(){
        Assertions.assertEquals(9969, s.maximum69Number(9669));
    }

    @Test
    public void rangeSumBST(){

        TreeNode root = makeBST(new int[]{10, 5,15,3,7,-1,18}, new TreeNode(0), 0);
        Assertions.assertEquals(32, s.rangeSumBST(root, 7, 15));
        root = makeBST(new int[]{10,5,15,3,7,13,18,1,-1,6}, new TreeNode(0), 0);
        Assertions.assertEquals(23, s.rangeSumBST(root, 6, 10));
    }

    @Test
    public void toLowerCase() {
        Assertions.assertEquals("lower", s.toLowerCase("LOWER"));
    }

    @Test
    public void oddCells(){
        Assertions.assertEquals(6, s.oddCells(2,3,new int[][]{new int[]{0,1}, new int[]{1,1}}));
        Assertions.assertEquals(0, s.oddCells(2,2,new int[][]{new int[]{1,1}, new int[]{0,0}}));
        Assertions.assertEquals(0, s.oddCells(1,1,new int[][]{new int[]{0,0}, new int[]{0,0}}));
    }

    @Test
    public void freqAlphabets() {

        Assertions.assertEquals("jkab", s.freqAlphabets("10#11#12"));
        Assertions.assertEquals("acz", s.freqAlphabets("1326#"));
        Assertions.assertEquals("y", s.freqAlphabets("25#"));
        Assertions.assertEquals("abcdefghijklmnopqrstuvwxyz", s.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

    @Test
    public void replaceElements(){
        Assertions.assertArrayEquals(new int[]{18,6,6,6,1,-1}, s.replaceElements(new int[]{17, 18,5,6,6,1}));
    }

    @Test
    public void sumZero(){
        int[] arr = s.sumZero(5);
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        Assertions.assertEquals(0, sum);
    }

    @Test
    public void removeOuterParentheses(){
        Assertions.assertEquals("()()()", s.removeOuterParentheses("(()())(())"));
        Assertions.assertEquals("()()()()(())", s.removeOuterParentheses("(()())(())(()(()))"));
        Assertions.assertEquals("", s.removeOuterParentheses("()()"));
    }

    @Test
    public void uniqueMorseRepresentations(){
        Assertions.assertEquals(2, s.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    @Test
    public void flipAndInvertImage(){
        int[][] arr = new int[][] {{1,1,0},{1,0,1},{0,0,0}};
        int[][] result = s.flipAndInvertImage(arr);
    }

    @Test
    public void sortArrayByParity(){
        Assertions.assertArrayEquals(new int[]{2,4,1,3}, s.sortArrayByParity(new int[]{3,1,2,4}));
    }

    @Test
    public void repeatedNTimes(){
        Assertions.assertEquals(3, s.repeatedNTimes(new int[]{1,2,3,3}));
        Assertions.assertEquals(2, s.repeatedNTimes(new int[]{2,1,2,5,3,2}));
        Assertions.assertEquals(5, s.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
        Assertions.assertEquals(2, s.repeatedNTimes(new int[]{2,6,2,1}));
    }

    @Test
    public void uniqueOccurrences(){
        Assertions.assertEquals(true, s.uniqueOccurrences(new int[] {1,2,2,1,1,3}));
    }

    @Test
    public void selfDividingNumbers(){
        Assertions.assertEquals(Arrays.asList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22}), s.selfDividingNumbers(1,22));
    }

    @Test
    public void smallerNumbersThanCurrent(){
        int[] test = {6,5,4,8};
        Assertions.assertArrayEquals(new int[]{2,1,0,3}, s.smallerNumbersThanCurrent(test));
        test = new int[]{7,7,7,7};
        Assertions.assertArrayEquals(new int[]{0,0,0,0}, s.smallerNumbersThanCurrent(test));
    }

    @Test
    public void createTargetArray(){
        Assertions.assertArrayEquals(new int[]{0,4,1,3,2}, s.createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1}));
        Assertions.assertArrayEquals(new int[]{0,1,2,3,4}, s.createTargetArray(new int[]{1,2,3,4,0}, new int[]{0,1,2,3,0}));
        Assertions.assertArrayEquals(new int[]{0,4,1,3,2}, s.createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1}));
    }

    private void makeNodeList(int[] arr, ListNode root){
        root.val = arr[0];
        ListNode prev = root;
        for(int i = 1; i < arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            prev.next = node;
            prev = node;
        }
    }

    private TreeNode makeBST(int[] arr,  TreeNode root, int i) {
        if (i < arr.length) {
            TreeNode temp = null;
            if (arr[i] >= 0)
                temp = new TreeNode(arr[i]);
            root = temp;
            if (root != null) {
                // insert left child
                root.left = makeBST(arr, root.left,
                        2 * i + 1);

                // insert right child
                root.right = makeBST(arr, root.right,
                        2 * i + 2);
            }
        }
        return root;
    }
}
