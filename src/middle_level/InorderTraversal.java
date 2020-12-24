package middle_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 94. ���������������
 * ����һ���������������������������
 *
 * ʾ��:
 *
 * ����: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * ���: [1,3,2]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/28 6:09 ����
 */
public class InorderTraversal {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    /**
     * �ǵݹ�д��
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_iterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            // �Ⱦ������ҵ���ߵĽڵ�
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // ��ӡ
            root = stack.pop();
            res.add(root.val);
            // ����Ѱ���ұߵ�
            root = root.right;
        }
        return res;
    }
}
