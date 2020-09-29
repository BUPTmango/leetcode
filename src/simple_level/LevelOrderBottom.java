package simple_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 《玩转算法面试视频例题》队列 层序遍历
 * 102 103 107 199用的是相同的代码
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @author mango
 * @create 2019-03-18 3:48 PM
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom_BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (queue.size() > 0) {
            // 获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            // 将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            // 如果节点的左/右子树不为空，也放入队列中
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            // 将临时list加入最终返回结果中 自底向上输出
            res.add(0, tmp);
        }
        return res;
    }



    List<List<Integer>> levels = new ArrayList<>();

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        // 如果是当前层的第一个元素 添加一个空的list
        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);

        // 分别遍历左右节点
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    /**
     * 递归方法 DFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom_DFS(TreeNode root) {
        if (root == null) {
            return levels;
        }
        dfs(root, 0);
        Collections.reverse(levels);
        return levels;
    }
}