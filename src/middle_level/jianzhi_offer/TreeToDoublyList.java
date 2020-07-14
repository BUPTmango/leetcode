package middle_level.jianzhi_offer;

/**
 * ��ָ Offer 36. ������������˫������
 * ����һ�ö��������������ö���������ת����һ�������ѭ��˫������Ҫ���ܴ����κ��µĽڵ㣬ֻ�ܵ������нڵ�ָ���ָ��
 *
 *
 * Ϊ���������õ�������⣬������Ķ���������Ϊ����
 *
 * ����ϣ�����������������ת��Ϊ˫��ѭ�����������е�ÿ���ڵ㶼��һ��ǰ���ͺ��ָ�롣����˫��ѭ��������һ���ڵ��ǰ�������һ���ڵ㣬���һ���ڵ�ĺ���ǵ�һ���ڵ㡣
 *
 * ��ͼչʾ������Ķ���������ת���ɵ�������head�� ��ʾָ������������СԪ�صĽڵ㡣
 *
 *
 * �ر�أ�����ϣ�����Ծ͵����ת����������ת������Ժ����нڵ����ָ����Ҫָ��ǰ�������нڵ����ָ����Ҫָ���̡�����Ҫ���������еĵ�һ���ڵ��ָ�롣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/14 5:59 ����
 */
public class TreeToDoublyList {
    Node pre, head;

    /**
     * �� ���������� ת����һ�� �������ѭ��˫������ �����а�������Ҫ�أ�
     *
     * �������� �ڵ�Ӧ��С�����������Ӧʹ�� ������� ����С���󡱷������Ľڵ㣻
     * ˫������ �ڹ������ڽڵ㣨��ǰ���ڵ� prepre ����ǰ�ڵ� curcur ����ϵʱ������Ӧ pre.right = curpre.right=cur ��ҲӦ cur.left = precur.left=pre ��
     * ѭ������ ������ͷ�ڵ� headhead ��β�ڵ� tailtail ����Ӧ���� head.left = tailhead.left=tail �� tail.right = headtail.right=head ��
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        // ��һ�� ��������
        dfs(root);
        // ������ ѭ������ ͷβ����
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) {
            return;
        }
        dfs(cur.left);
        // �ڶ��� ˫������ ������ left->right right->left
        if(pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
