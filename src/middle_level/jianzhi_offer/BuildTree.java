package middle_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.HashMap;

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
    // ������������� map key->��������Ԫ�� value->������������
    HashMap<Integer, Integer> dic = new HashMap<>();
    // ���ǰ�������� ����
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int pre_root, int in_left, int in_right) {
        if(in_left > in_right) return null;
        // ����ǰ������������������ڵ�
        TreeNode root = new TreeNode(po[pre_root]);
        // ͨ��ǰ��������õ����������
        int i = dic.get(po[pre_root]);
        // ���������� ���ݸ��ڵ�����i���зָ�
        root.left = recur(pre_root + 1, in_left, i - 1);
        // ���������� ���ݸ��ڵ�����i���зָ�
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }
}
