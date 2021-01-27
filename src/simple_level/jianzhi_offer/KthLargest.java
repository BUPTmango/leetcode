package simple_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 面试题54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * ?
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 * ?  2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * ?
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/1 10:11 上午
 */
public class KthLargest {
    private int count = 0;
    private int res = 0;

    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    /**
     * 注意！！ 改造的中序遍历 左右子树的遍历是反过来的 这样可以得到降序的序列
     * @param root
     * @param k
     */
    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.right, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        inorder(root.left, k);
    }
}
