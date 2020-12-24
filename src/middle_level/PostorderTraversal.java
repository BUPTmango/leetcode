package middle_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序?遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/28 6:22 下午
 */
public class PostorderTraversal {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }
    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal_iterate(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        // 两个地方和前序不一样
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 不一样的第一个地方 在list头部加元素值
            res.addFirst(node.val);
            // 不一样的第二个地方 先left后right
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }
}
