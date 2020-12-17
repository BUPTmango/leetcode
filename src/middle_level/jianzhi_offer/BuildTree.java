package middle_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * ������07. �ؽ�������
 * ����ĳ��������ǰ���������������Ľ�������ؽ��ö����������������ǰ���������������Ľ���ж������ظ������֡�
 *
 * ?
 *
 * ���磬����
 *
 * ǰ����� preorder =?[3,9,20,15,7]
 * ������� inorder = [9,3,15,20,7]
 * �������µĶ�������
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ?
 *
 * ���ƣ�
 *
 * 0 <= �ڵ���� <= 5000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/7 10:05 ����
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

        // ǰ�����
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1);
        root.right = buildTree(preorder, inorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd);
        return root;
    }
}
