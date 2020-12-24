package middle_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 145. �������ĺ������
 * ����һ������������������ ����?������
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
 * ���: [3,2,1]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/28 6:22 ����
 */
public class PostorderTraversal {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }
    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal_iterate(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        // �����ط���ǰ��һ��
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // ��һ���ĵ�һ���ط� ��listͷ����Ԫ��ֵ
            res.addFirst(node.val);
            // ��һ���ĵڶ����ط� ��left��right
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }
}
