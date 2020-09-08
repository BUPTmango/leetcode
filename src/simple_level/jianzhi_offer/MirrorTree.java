package simple_level.jianzhi_offer;

import data_structure.TreeNode;

/**
 * ������27. �������ľ���
 * �����һ������������һ�����������ú���������ľ���
 *
 * �������룺
 *
 * ? ? ?4
 * ? ?/ ? \
 * ? 2 ? ? 7
 * ?/ \ ? / \
 * 1 ? 3 6 ? 9
 * ���������
 *
 * ? ? ?4
 * ? ?/ ? \
 * ? 7 ? ? 2
 * ?/ \ ? / \
 * 9 ? 6 3? ?1
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺root = [4,2,7,1,3,6,9]
 * �����[4,7,2,9,6,3,1]
 * ?
 *
 * ���ƣ�
 *
 * 0 <= �ڵ���� <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/26 8:17 ����
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
