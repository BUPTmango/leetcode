package middle_level;

import data_structure.TreeNode;

/**
 * ���������� �ж�BST�ĺϷ��ԡ�����ɾ����
 * ����ת�㷨������Ƶ���⡷����������
 * 450. ɾ�������������еĽڵ�
 * ����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е�?key?��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣���ض������������п��ܱ����£��ĸ��ڵ�����á�
 *
 * һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺
 *
 * �����ҵ���Ҫɾ���Ľڵ㣻
 * ����ҵ��ˣ�ɾ������
 * ˵���� Ҫ���㷨ʱ�临�Ӷ�Ϊ?O(h)��h Ϊ���ĸ߶ȡ�
 *
 * ʾ��:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * ������Ҫɾ���Ľڵ�ֵ�� 3���������������ҵ� 3 ����ڵ㣬Ȼ��ɾ������
 *
 * һ����ȷ�Ĵ��� [5,4,6,2,null,null,7], ����ͼ��ʾ��
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * ��һ����ȷ���� [5,2,6,null,4,null,7]��
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/9 8:20 ����
 */
public class DeleteNode {

    /**
     * �ҵ���̽ڵ�
     * @param root
     * @return
     */
    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /**
     * �ҵ�ǰ��ڵ�
     * @param root
     * @return
     */
    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // ��������Ѱ��
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            // ��������Ѱ��
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            // ɾ���ڵ�
        } else {
            // ��Ҷ�ӽڵ� ֱ��ɾ��
            if (root.left == null && root.right == null) {
                root = null;
                // ����Ҷ�ӽڵ� ������������
            } else if (root.right != null) {
                // ʹ�ú�̽ڵ���Ϊ�µĸ��ڵ�
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
                // ����Ҷ�ӽڵ� û�������� ֻ��������
            } else {
                // ʹ��ǰ��ڵ���Ϊ�µĸ��ڵ�
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
