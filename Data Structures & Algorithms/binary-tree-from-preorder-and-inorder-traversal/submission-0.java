/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int counter = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        int root = preorder[counter++];
        int rootIndx = getIndexOf(inorder,root);
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = buildTree(preorder,Arrays.copyOfRange(inorder,0, rootIndx));
        rootNode.right = buildTree(preorder,Arrays.copyOfRange(inorder,rootIndx + 1, inorder.length));
        return rootNode;
    }
    private int getIndexOf(int[] arr, int val){
        for(int i=0; i< arr.length; i++) {
            if(arr[i] == val) return i;
        }
        return 0;
    }
}
