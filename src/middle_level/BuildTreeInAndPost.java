package middle_level;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 构造二叉树
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder =?[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/6 9:22 上午
 */
public class BuildTreeInAndPost {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left,
                                int postorder_right) {
        if (postorder_left > postorder_right) {
            return null;
        }

        // 后序遍历中的最后一个节点就是根节点
        int postorder_root = postorder_right;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(postorder[postorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(postorder[postorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        root.left = myBuildTree(inorder, postorder, inorder_left, inorder_root - 1, postorder_left,
                postorder_left + size_left_subtree - 1);
        // 递归地构造右子树，并连接到根节点
        root.right = myBuildTree(inorder, postorder, inorder_root + 1, inorder_right,
                postorder_left + size_left_subtree, postorder_root - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }
}
