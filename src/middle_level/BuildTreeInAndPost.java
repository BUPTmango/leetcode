package middle_level;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * ���������
 * 106. �����������������й��������
 * ����һ��������������������������������
 * <p>
 * ע��:
 * ����Լ�������û���ظ���Ԫ�ء�
 * <p>
 * ���磬����
 * <p>
 * ������� inorder =?[9,3,15,20,7]
 * ������� postorder = [9,15,7,20,3]
 * �������µĶ�������
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/6 9:22 ����
 */
public class BuildTreeInAndPost {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left,
                                int postorder_right) {
        if (postorder_left > postorder_right) {
            return null;
        }

        // ��������е����һ���ڵ���Ǹ��ڵ�
        int postorder_root = postorder_right;
        // ����������ж�λ���ڵ�
        int inorder_root = indexMap.get(postorder[postorder_root]);

        // �ȰѸ��ڵ㽨������
        TreeNode root = new TreeNode(postorder[postorder_root]);
        // �õ��������еĽڵ���Ŀ
        int size_left_subtree = inorder_root - inorder_left;
        // �ݹ�ع����������������ӵ����ڵ�
        root.left = myBuildTree(inorder, postorder, inorder_left, inorder_root - 1, postorder_left,
                postorder_left + size_left_subtree - 1);
        // �ݹ�ع����������������ӵ����ڵ�
        root.right = myBuildTree(inorder, postorder, inorder_root + 1, inorder_right,
                postorder_left + size_left_subtree, postorder_root - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        // �����ϣӳ�䣬�������ǿ��ٶ�λ���ڵ�
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }
}
