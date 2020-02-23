package test;

import main.easy.Solution;
import main.model.ListNode;
import main.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

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
        Assert.assertEquals(0, s.solutionRec(n1, n4, 0).val);
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
        Assert.assertArrayEquals(result, s.decompressRLElist(test));
    }

    @Test
    public void solution1281(){
        assert(15 == s.subtractProductAndSum(234));
        assert(21 == s.subtractProductAndSum(4421));
    }

    @Test
    public void solution1295(){
        int[] test = {12,345,2,6,7896};
        Assert.assertEquals(2, s.findNumbers(test));
        int[] test2 = {555,901,482,1771};
        Assert.assertEquals(1, s.findNumbers(test2));
    }

    @Test
    public void solution1221(){
        Assert.assertEquals(4, s.balancedStringSplit("RLRRLLRLRL"));
        Assert.assertEquals(3, s.balancedStringSplit("RLLLLRRRLR"));
        Assert.assertEquals(1, s.balancedStringSplit("LLLLRRRR"));
        Assert.assertEquals(2, s.balancedStringSplit("RLRRRLLRLL"));
    }

    @Test
    public void solution1290(){
        ListNode n1 = new ListNode(0);
        makeNodeList(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0}, n1);
        Assert.assertEquals(18880, s.getDecimalValue(n1));
        makeNodeList(new int[]{1,0,1}, n1);
        Assert.assertEquals(5, s.getDecimalValue(n1));
    }

    @Test
    public void maximum69Number(){
        Assert.assertEquals(9969, s.maximum69Number(9669));
    }

    @Test
    public void rangeSumBST(){

        TreeNode root = makeBST(new int[]{10, 5,15,3,7,-1,18}, new TreeNode(0), 0);
        Assert.assertEquals(32, s.rangeSumBST(root, 7, 15));
        root = makeBST(new int[]{10,5,15,3,7,13,18,1,-1,6}, new TreeNode(0), 0);
        Assert.assertEquals(23, s.rangeSumBST(root, 6, 10));
    }

    @Test
    public void toLowerCase() {
        Assert.assertEquals("lower", s.toLowerCase("LOWER"));
    }

    @Test
    public void oddCells(){
        Assert.assertEquals(6, s.oddCells(2,3,new int[][]{new int[]{0,1}, new int[]{1,1}}));
        Assert.assertEquals(0, s.oddCells(2,2,new int[][]{new int[]{1,1}, new int[]{0,0}}));
        Assert.assertEquals(0, s.oddCells(1,1,new int[][]{new int[]{0,0}, new int[]{0,0}}));
    }

    @Test
    public void freqAlphabets() {

        Assert.assertEquals("jkab", s.freqAlphabets("10#11#12"));
        Assert.assertEquals("acz", s.freqAlphabets("1326#"));
        Assert.assertEquals("y", s.freqAlphabets("25#"));
        Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", s.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

    @Test
    public void replaceElements(){
        Assert.assertArrayEquals(new int[]{18,6,6,6,1,-1}, s.replaceElements(new int[]{17, 18,5,6,6,1}));
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

    private TreeNode makeBST(int[] arr,  TreeNode root, int i){
        if (i < arr.length) {
            TreeNode temp = null;
            if(arr[i] >= 0)
                temp = new TreeNode(arr[i]);
            root = temp;
            if(root != null) {
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
