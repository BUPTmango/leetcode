package middle_level;

import data_structure.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * <p>
 * ?
 * <p>
 * 例如,?
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * 或者这个树也是有效的:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 * ?
 * <p>
 * 提示：
 * <p>
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/30 8:43 上午
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    // 注意要break
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    // 注意要break
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }


    /**
     * 递归
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST_recursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        // 根据BST的性质找到需要插入的点
        if (root.val > val) {
            root.left = insertIntoBST_recursive(root.left, val);
        } else {
            root.right = insertIntoBST_recursive(root.right, val);
        }
        return root;
    }
}
