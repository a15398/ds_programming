/**
 * @link:https://leetcode.com/problems/sum-of-left-leaves/
 Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
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
class LeftLeavesSum {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root,false);
    }
    
    private int sumOfLeftLeaves(TreeNode r, boolean isLeft){
        return r==null?0:((r.left == null && r.right==null)?(isLeft?r.val:0):(sumOfLeftLeaves(r.left, true) + sumOfLeftLeaves(r.right, false)));
    }
}