/**
 @link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 Description: 
 Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
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
class MaxPathSum {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }
    private int postOrder(TreeNode r){
        if(r==null)return 0;
        int lV= postOrder(r.left);
        if(lV<0)lV=0;
        int rV= postOrder(r.right);
        if(rV<0)rV=0;
        if(max<(r.val+lV+rV))max=r.val+lV+rV;
        return (lV>rV?lV:rV)+r.val;
    }
}