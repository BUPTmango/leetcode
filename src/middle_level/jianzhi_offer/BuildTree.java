package middle_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    private Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 前序遍历
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1);
        root.right = buildTree(preorder, inorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd);
        return root;
    }
}
