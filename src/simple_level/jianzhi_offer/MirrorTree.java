package simple_level.jianzhi_offer;

import data_structure.TreeNode;

/**
 * 面试题27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 * ? ? ?4
 * ? ?/ ? \
 * ? 2 ? ? 7
 * ?/ \ ? / \
 * 1 ? 3 6 ? 9
 * 镜像输出：
 *
 * ? ? ?4
 * ? ?/ ? \
 * ? 7 ? ? 2
 * ?/ \ ? / \
 * 9 ? 6 3? ?1
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * ?
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/26 8:17 上午
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode middle = root.left;
        root.left = root.right;
        root.right = middle;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
