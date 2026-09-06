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

    static class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        long maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // First node of current level
            long first = q.peek().index;

            // Last node of current level
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair current = q.poll();

                TreeNode node = current.node;
                long index = current.index;

                // Last node of this level
                if (i == size - 1) {
                    last = index;
                }

                if (node.left != null) {
                    q.offer(
                        new Pair(node.left, 2 * index + 1)
                    );
                }

                if (node.right != null) {
                    q.offer(
                        new Pair(node.right, 2 * index + 2)
                    );
                }
            }

            long width = last - first + 1;

            maxWidth = Math.max(maxWidth, width);
        }

        return (int) maxWidth;
    }
}