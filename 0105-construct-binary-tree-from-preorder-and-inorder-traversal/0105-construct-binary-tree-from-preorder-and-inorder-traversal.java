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

    HashMap<Integer,Integer> map = new HashMap<>();

    int idx = 0;   // Global

    TreeNode construct(int[] preorder, int[] inorder, int start, int end){

        if(start > end)
            return null;

        int rootVal = preorder[idx++];
        int i = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = construct(preorder, inorder, start, i - 1);

        root.right = construct(preorder, inorder, i + 1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;

        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return construct(preorder, inorder, 0, n - 1);
    }
}
