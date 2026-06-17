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
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        // BFS approach:
        // Queue<TreeNode> q = new LinkedList<>();

        // q.add(root);

        // while(!q.isEmpty()) {
        //     int size = q.size();
        //     for(int i = 0; i< size; i++) {
        //         TreeNode cur = q.poll();
        //         if(cur == null) return res;
        //         if(i == size - 1) res.add(cur.val);
        //         if(cur.left != null) q.add(cur.left);
        //         if(cur.right != null) q.add(cur.right);
        //     }
        // }


        // DFS approach:
        getright(root, 0);
        return res;
    }

    public void getright(TreeNode root, Integer depth) {
        if(root == null) return;

        if(depth == res.size()) {
            res.add(root.val);
        }

        getright(root.right, depth + 1);
        getright(root.left, depth + 1);
    }
}
