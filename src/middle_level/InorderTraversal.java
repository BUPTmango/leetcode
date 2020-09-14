package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * �ݹ�ĵ��ù����ǲ���������ߣ�������߲���ȥ�ˣ��ʹ�ӡ�ڵ㣬��ת���ұߣ�Ȼ���ұ߼���������̡�
     * �����ڵ���ʵ��ʱ���Ϳ�����ջ��ģ������ĵ��ù��̡�
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(stack.size() > 0 || root != null) {
            // �����������������ߣ�ÿ��һ�ξͽ���ǰ�ڵ㱣�浽ջ��
            // ����ģ��ݹ�ĵ���
            if(root != null) {
                stack.add(root);
                root = root.left;
                // ��ǰ�ڵ�Ϊ�գ�˵������ߵ�ͷ�ˣ���ջ�е����ڵ㲢����
                // Ȼ��ת���ұ߽ڵ㣬����������������
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }
}
