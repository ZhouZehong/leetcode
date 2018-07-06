import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example: Given binary tree{1,#,2,3},
 * 1
 *  \
 *   2
 * /
 * 3
 * return[3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreePostorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }

    // recursive
//    public ArrayList<Integer> postorderTraversal(TreeNode root){
//        ArrayList<Integer> res = new ArrayList<>();
//        core(res, root);
//        return res;
//    }
//
//    private void core(ArrayList<Integer> res, TreeNode node){
//        if (node == null) return;
//        core(res, node.left);
//        core(res, node.right);
//        res.add(node.val);
//    }
}
