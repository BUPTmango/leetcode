package simple_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
 *
 *
 * 举个例子，如上图所示，给定一棵叶值序列为(6, 7, 4, 9, 8)的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
 *
 * 如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
 *
 * 示例 1：
 *
 *
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 *
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 *
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 *
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * 示例 5：
 *
 *
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/10 09:24
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sequence1 = findSequence(root1);
        List<Integer> sequence2 = findSequence(root2);
        // 对比
        if (sequence1.size() != sequence2.size()) {
            return false;
        }
        for (int i = 0; i < sequence1.size(); i++) {
            if (!sequence1.get(i).equals(sequence2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> findSequence(TreeNode root) {
        // 前序遍历寻找
        List<Integer> sequence = new ArrayList<>();
        preOrder(root, sequence);
        return sequence;
    }
    
    private void preOrder(TreeNode node, List<Integer> sequence) {
        if (node == null) {
            return;
        }
        preOrder(node.left, sequence);
        if (node.left == null && node.right == null) {
            sequence.add(node.val);
        }
        preOrder(node.right, sequence);
    }
}
