package middle_level;

/**
 * 430. ��ƽ���༶˫������
 * �༶˫�������У�����ָ����һ���ڵ��ǰһ���ڵ�ָ��֮�⣬������һ��������ָ�룬����ָ�򵥶���˫��������Щ���б�Ҳ���ܻ���һ�������Լ�������������ƣ����ɶ༶���ݽṹ���������ʾ����ʾ��
 * <p>
 * ����λ���б��һ����ͷ�ڵ㣬�����ƽ���б�ʹ���н������ڵ���˫�����С�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * �����[1,2,3,7,8,11,12,9,10,4,5,6]
 * ���ͣ�
 * <p>
 * ����Ķ༶�б�����ͼ��ʾ��
 * <p>
 * ��ƽ�������������ͼ��
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺head = [1,2,null,3]
 * �����[1,3,2]
 * ���ͣ�
 * <p>
 * ����Ķ༶�б�����ͼ��ʾ��
 * <p>
 * 1---2---NULL
 * |
 * 3---NULL
 * ʾ�� 3��
 * <p>
 * ���룺head = []
 * �����[]
 * <p>
 * <p>
 * ��α�ʾ���������еĶ༶����
 * <p>
 * �� ʾ�� 1 Ϊ����
 * <p>
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * ���л����е�ÿһ��֮��
 * <p>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * Ϊ�˽�ÿһ�������л���һ��������Ҫÿһ�������ֵΪ null ��Ԫ�أ��Ա�ʾû�нڵ����ӵ���һ�����ϼ��ڵ㡣
 * <p>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * �ϲ��������л��������ȥ��ĩβ�� null ��
 * <p>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <p>
 * ��ʾ��
 * <p>
 * �ڵ���Ŀ������ 1000
 * 1 <= Node.val <= 10^5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/5 12:08 ����
 */
public class FlattenDouble {
    /**
     * �� child ָ�뵱����������ָ���������� left ָ�롣
     * ͬ����next ָ����Ե����Ƕ������е� right ָ�롣
     * Ȼ����������������������õ��𰸡�
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        // ����ͷ�ڵ�
        Node pseudoHead = new Node(0, null, head, null);

        flattenDFS(pseudoHead, head);

        // detach the pseudo head from the real head
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    /**
     * ��������ָ����Ϊ�������������ر�ƽ���б��е�β��ָ��
     * @param prev prev ָ��ָ�� curr ָ��Ԫ�ص�ǰһ��Ԫ��
     * @param curr curr ָ��ָ������Ҫ��ƽ�������б�
     * @return
     */
    public Node flattenDFS(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;

        // ��������������tail
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        // ����tail��next
        return flattenDFS(tail, tempNext);
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    ;
}
