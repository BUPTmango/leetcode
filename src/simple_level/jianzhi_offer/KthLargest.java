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
    /**
     * 二叉搜索树的中序遍历是按照从小到大或者从大到小的顺序排列的（取决于左子树在前还是右子树在前）
     * 这里就用到排序
     * 之后用到stack的pop到第k个
     * @param root
     * @param k
     * @return
     */


    int count;
    int result = -1;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        kthLargest(root);
        return result;
    }

    private void kthLargest(TreeNode root) {
        if (Objects.nonNull(root)) {
            kthLargest(root.right);
            if (count == 1) {
                result = root.val;
                count--;
                return;
            }
            count--;
            kthLargest(root.left);
        }
    }


    // 中序遍历为排序好的数组
    List<Integer> list = new ArrayList<>();

    /**
     * 中序遍历之后为从小到大的有序数组，之后取size - k索引位置的元素
     * @param root
     * @param k
     * @return
     */
    public int kthLargest_inorder(TreeNode root, int k) {
        inorder(root);
        return list.get(list.size() - k);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
