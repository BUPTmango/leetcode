package middle_level;

import data_structure.Node;

/**
 * 117. ���ÿ���ڵ����һ���Ҳ�ڵ�ָ�� II
 * ����һ��������
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * �������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��
 *
 * ��ʼ״̬�£�����?next ָ�붼������Ϊ NULL��
 *
 * ���ף�
 *
 * ��ֻ��ʹ�ó���������ռ䡣
 * ʹ�õݹ����Ҳ����Ҫ�󣬱����еݹ����ռ�õ�ջ�ռ䲻��������Ŀռ临�Ӷȡ�
 *
 * ʾ����
 *
 * ���룺root = [1,2,3,4,5,null,7]
 * �����[1,#,2,3,#,4,5,7,#]
 * ���ͣ�������������ͼ A ��ʾ����ĺ���Ӧ���������ÿ�� next ָ�룬��ָ������һ���Ҳ�ڵ㣬��ͼ B ��ʾ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/28 9:03 ����
 */
public class ConnectII {
    /**
     * �������Ӷ��У�������nextָ�����ӣ�����nextָ��getNextNoNullChild
     * ֻ�����ӣ�����ָ��getNextNoNullChild��
     * ֻ�����ӣ�����ָ��getNextNoNullChild��
     *
     * ע�⣺�ݹ�ʱҪ�ȵݹ��������������ϼ��ڵ�next��ϵû���ã��¼��޷��ɹ�getNextNoNullChild
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        // �������Ӷ��У�������nextָ�����ӣ�����nextָ��getNextNoNullChild
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNoNullChild(root);
        }
        // ֻ�����ӣ�����ָ��getNextNoNullChild
        if (root.left == null) {
            root.right.next = getNextNoNullChild(root);
        }
        // ֻ�����ӣ�����ָ��getNextNoNullChild
        if (root.right == null) {
            root.left.next = getNextNoNullChild(root);
        }

        // ����Ҫע�⣺�ȵݹ����������������������ڵ�next��ϵû�����ã����������������ӽڵ��޷���ȷ����
        root.right = connect(root.right);
        root.left = connect(root.left);

        return root;
    }

    /**
     * һ·�����ҵ����ӽڵ�ĸ��ڵ�
     */
    private static Node getNextNoNullChild(Node root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }
}
