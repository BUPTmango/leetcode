package middle_level;

import data_structure.TreeNode;

/**
 * 《玩转算法面试视频例题》二叉树 递归
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~?2h?个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 8:26 上午
 */
public class CountNodes {

    private int count = 0;

    /**
     * 自己的做法
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        count(root);
        return count;
    }
    private void count(TreeNode node) {
        if (node == null) {
            return;
        }
        count++;
        count(node.left);
        count(node.right);
    }


    public int countNodes_better(TreeNode root) {
        return root != null ? 1 + countNodes_better(root.right) + countNodes_better(root.left) : 0;
    }

}
