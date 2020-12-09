package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 和上一个不同的是 不是返回树的个数 而是需要返回具体的所有树
 *
 * 给定一个整数 n，生成所有由 1 ...n 为节点所组成的 二叉搜索树 。
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *  [1,null,3,2],
 *  [3,2,null,1],
 *  [3,1,null,null,2],
 *  [2,1,3],
 *  [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/9 11:34 上午
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        // 注意！！！ 注意以下两个特殊情况的处理
        // 此时没有数字，将 null 加入结果中
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        // 只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            allTrees.add(tree);
            return allTrees;
        }
        // 遍历成为根节点的数字
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
