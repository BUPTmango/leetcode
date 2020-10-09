package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》二分搜索树
 * 378. 有序矩阵中第K小的元素
 * 给定一个?n x n?矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * 示例:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/13 12:06 下午
 */
public class KthSmallest {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k - 1);
    }

    /**
     * 中序遍历
     * @param node
     */
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}
