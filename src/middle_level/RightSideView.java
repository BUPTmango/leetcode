package middle_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 《玩转算法面试视频例题》队列 层序遍历
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入:?[1,2,3,null,5,null,4]
 * 输出:?[1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/22 11:53 上午
 */
public class RightSideView {
    /**
     * 思路
     *
     * 我们可以对二叉树进行层次遍历，那么对于每层来说，最右边的结点一定是最后被遍历到的。
     * 二叉树的层次遍历可以用广度优先搜索实现。
     *
     * 算法
     *
     * 执行广度优先搜索，左结点排在右结点之前，这样，我们对每一层都从左到右访问。
     * 因此，只保留每个深度最后访问的结点，我们就可以在遍历完整棵树后得到每个深度最右的结点。
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView_DFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode node, int level) {
        if(node != null) {
            // 添加这一层的第一个元素
            if(res.size() == level) {
                res.add(node.val);
            }
            // 继续遍历下一层 先右节点 之后左节点
            dfs(res, node.right, level + 1);
            dfs(res, node.left, level + 1);
        }
    }


    /**
     * 迭代方法
     * @param root
     * @return
     */
    public List<Integer> rightSideView_BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (queue.size() > 0) {
            // 获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            int ele = 0;
            // 将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            // 如果节点的左/右子树不为空，也放入队列中
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                ele = t.val;
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            // 将每一层的最后一个元素放到res中
            res.add(ele);
        }
        return res;
    }
}
