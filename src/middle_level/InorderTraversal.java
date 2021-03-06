package middle_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序遍历。
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
 * 输出: [1,3,2]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/28 6:09 下午
 */
public class InorderTraversal {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    /**
     * 非递归写法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_iterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            // 先尽可能找到左边的节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 打印
            root = stack.pop();
            res.add(root.val);
            // 继续寻找右边的
            root = root.right;
        }
        return res;
    }
}
