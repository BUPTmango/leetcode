package middle_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.HashMap;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * ?
 *
 * 例如，给出
 *
 * 前序遍历 preorder =?[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ?
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/7 10:05 上午
 */
public class BuildTree {
    // 存放中序遍历结果 map key->中序数组元素 value->中序数组索引
    HashMap<Integer, Integer> dic = new HashMap<>();
    // 存放前序遍历结果 数组
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int pre_root, int in_left, int in_right) {
        if(in_left > in_right) return null;
        // 根据前序遍历的索引创建根节点
        TreeNode root = new TreeNode(po[pre_root]);
        // 通过前序的索引得到中序的索引
        int i = dic.get(po[pre_root]);
        // 构建左子树 根据根节点索引i进行分割
        root.left = recur(pre_root + 1, in_left, i - 1);
        // 构建右子树 根据根节点索引i进行分割
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }
}
