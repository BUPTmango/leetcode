package middle_level;

import data_structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 144. ��������ǰ�����
 * ����һ������������������?ǰ��?������
 *
 * ?ʾ��:
 *
 * ����: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * ���: [1,2,3]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/28 6:20 ����
 */
public class PreorderTraversal {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return list;
    }
    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * �ǵݹ�д��
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_iterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            // ��Ϊ����ջ ��������Ҫ������
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}
