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

    HashMap<Integer, Integer> map = new HashMap<>();
    int idx;

    TreeNode construct(int[] inorder, int[] postorder, int start, int end) {

        if (start > end)
            return null;

        int rootVal = postorder[idx--];

        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        // Build right first
        root.right = construct(inorder, postorder, mid + 1, end);

        root.left = construct(inorder, postorder, start, mid - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n = inorder.length;

        for (int i = 0; i < n; i++)
            map.put(inorder[i], i);

        idx = n - 1;

        return construct(inorder, postorder, 0, n - 1);
    }
}