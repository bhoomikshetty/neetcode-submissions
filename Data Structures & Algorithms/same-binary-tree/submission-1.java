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
class Solution 
{
    public boolean isTreeEqual(TreeNode a, TreeNode b)
    {
        return (a == null && b == null) || !(a != null && b == null) && !(a == null && b != null) && (a.val == b.val && isTreeEqual(a.left, b.left) && isTreeEqual(a.right, b.right));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        return isTreeEqual(p, q);           
    }
}       