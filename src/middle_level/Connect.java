package middle_level;

import data_structure.Node;

/**
 * 116. ���ÿ���ڵ����һ���Ҳ�ڵ�ָ��
 * ����һ��������������������Ҷ�ӽڵ㶼��ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ㡣�������������£�
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
 * ?
 *
 * ʾ����
 *
 *
 *
 * ���룺{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * �����{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 *
 * ���ͣ�������������ͼ A ��ʾ����ĺ���Ӧ���������ÿ�� next ָ�룬��ָ������һ���Ҳ�ڵ㣬��ͼ B ��ʾ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/26 12:01 ����
 */
public class Connect {
    /**
     * ÿ�� node �������� next , ���� node ��������
     * ÿ�� node �������� next, ���� node next �� ������
     * @param root
     * @return
     */
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node node, Node next) {
        if(node != null) {
            node.next = next;
            dfs(node.left, node.right);
            dfs(node.right, node.next != null ? node.next.left : null);
        }
    }
}
