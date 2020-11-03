package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;

/**
 * 二分搜索树
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数?kthSmallest?来查找其中第?k?个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 * ?  2
 * 输出: 1
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
 * 输出: 3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/1 11:26 上午
 */
public class KthSmallest_SearchTree {
    /**
     * 递归
     * 通过构造 BST 的中序遍历序列，则第 k-1 个元素就是第 k 小的元素。
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}
