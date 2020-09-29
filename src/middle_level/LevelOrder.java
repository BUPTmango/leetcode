package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 《玩转算法面试视频例题》队列 层序遍历
 * 102 103 107 199用的是相同的代码
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/7 10:46 上午
 */
public class LevelOrder {
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
    public List<List<Integer>> levelOrder_DFS(TreeNode root) {
        if (root == null) {
            return levels;
        }
        dfs(root, 0);
        return levels;
    }


    /**
     * 迭代实现 BFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_BFS(TreeNode root) {
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
            // 将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }
}
