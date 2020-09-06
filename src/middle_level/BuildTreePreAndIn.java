package middle_level;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. ��ǰ��������������й��������
 * ����һ������ǰ�������������������������
 *
 * ע��:
 * ����Լ�������û���ظ���Ԫ�ء�
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
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/29 9:42 ����
 */
public class BuildTreePreAndIn {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // ǰ������еĵ�һ���ڵ���Ǹ��ڵ�
        int preorder_root = preorder_left;
        // ����������ж�λ���ڵ�
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // �ȰѸ��ڵ㽨������
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // �õ��������еĽڵ���Ŀ
        int size_left_subtree = inorder_root - inorder_left;
        // �ݹ�ع����������������ӵ����ڵ�
        // ��������С��� ��߽�+1 ��ʼ�� size_left_subtree����Ԫ�ؾͶ�Ӧ����������С��� ��߽� ��ʼ�� ���ڵ㶨λ-1����Ԫ��
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // �ݹ�ع����������������ӵ����ڵ�
        // ��������С��� ��߽�+1+�������ڵ���Ŀ ��ʼ�� �ұ߽硹��Ԫ�ؾͶ�Ӧ����������С��� ���ڵ㶨λ+1 �� �ұ߽硹��Ԫ��
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // �����ϣӳ�䣬�������ǿ��ٶ�λ���ڵ�
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
