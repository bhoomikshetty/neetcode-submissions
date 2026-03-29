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
    HashMap<Integer, Pair<Integer, Integer>> childrenCount;
    public void countChildren(TreeNode node)
    {
        if(node == null) return;

        countChildren(node.left);
        countChildren(node.right);

        Pair<Integer, Integer> leftSubtreeCount = node.left == null ? new Pair(0, 0) : childrenCount.get(node.left.val);        
        Pair<Integer, Integer> rightSubtreeCount = node.right == null ? new Pair(0, 0) : childrenCount.get(node.right.val);
        
        childrenCount.put(node.val, new Pair((node.left == null ? 0 : 1) + leftSubtreeCount.getKey() + leftSubtreeCount.getValue(), (node.right == null ? 0 : 1) + rightSubtreeCount.getKey() + rightSubtreeCount.getValue()));
    }

    public int findKthSmallestElement(TreeNode node, int k)
    {

        int value = node.val;
        Pair<Integer, Integer> children = childrenCount.get(value);
        int leftCount = children.getKey();
        int rightCount = children.getValue();

        int totalNodes = childrenCount.size();
        if((leftCount == 0 && totalNodes - rightCount == k) || leftCount == k - 1 || (node.left == null && node.right == null)) return value;

        if(leftCount >= k) return findKthSmallestElement(node.left, k);
        else return findKthSmallestElement(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) 
    {
        childrenCount = new HashMap<>();
        countChildren(root);

        System.out.println(childrenCount);
        return findKthSmallestElement(root, k);
    }
}
