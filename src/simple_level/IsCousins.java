package simple_level;

import data_structure.TreeNode;

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/17 18:22
 */
public class IsCousins {
    private int x;
    private int y;
    private TreeNode xParent;
    private TreeNode yParent;
    private int xDepth;
    private int yDepth;
    private boolean xFound;
    private boolean yFound;

    public boolean isCousins(TreeNode root, int x, int y) {
        // 添加两个额外属性 深度和父亲
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xParent != yParent && xDepth == yDepth;
    }

    private void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }
        // 前序遍历
        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
            xFound = true;
        }
        if (node.val == y) {
            yDepth = depth;
            yParent = parent;
            yFound = true;
        }
        // 如果都找到了 提前结束
        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth + 1, node);
        dfs(node.right, depth + 1, node);
    }
}
