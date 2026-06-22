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
    Map<Integer,Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length -1);
    }
    // private int getIndexOf(int[] arr, int val){
    //     for(int i=0; i< arr.length; i++) {
    //         if(arr[i] == val) return i;
    //     }
    //     return 0;
    // }

    private TreeNode build(int[] preorder, int left, int right){
        if(left > right) return null;
        int root = preorder[counter++];
        int rootIndx = inorderMap.get(root);
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = build(preorder, left, rootIndx - 1);
        rootNode.right = build(preorder, rootIndx + 1, right);
        return rootNode;
    }
}
