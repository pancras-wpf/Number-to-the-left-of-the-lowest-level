package 左下节点;

import java.util.LinkedList;
import java.util.Queue;

/*给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。

假设二叉树中至少有一个节点。*/
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(1), new TreeNode(4));
        Solution solution = new Solution();
        solution.findBottomLeftValue(treeNode);
    }
}

//Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }
}