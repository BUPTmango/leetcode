package middle_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷ ����
 * 92. ��ת���� II
 * ��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��
 * <p>
 * ˵��:
 * 1 ��?m?��?n?�� �����ȡ�
 * <p>
 * ʾ��:
 * <p>
 * ����: 1->2->3->4->5->NULL, m = 2, n = 4
 * ���: 1->4->3->2->5->NULL
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/3 3:24 ����
 */
public class ReverseBetween {
    /**
     * �����ⷨ �Ƽ�
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween_iterator(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        // �ҵ���ʼ��
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // tail ָ��ָ�������ͷ��ĵ� m ����㣬�˽���Ƿ�ת�������β�����ʳ�Ϊ tail��
        // con ָ��ָ��� m ������ǰһ����㣬�˽�����������ͷ����'
        // tail �� con ָ�����㷨��ʼʱ����ʼ�������㷨��󱻵��ã������������ת��
        ListNode con = prev, tail = cur;

        // ��ת����
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // ʹ�� con ָ�������� prev ָ��
        // ���� tail ָ�������� prev ָ��֮��Ľ�� cur
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }


    private boolean stop;
    private ListNode left;

    /**
     * �ݹ�ⷨ
     * ������Ҫ������ָͬ�룬һ��ָ��� m ����㣬��һ��ָ��� n ����㡣
     * һ������������ָ�룬���ǾͿ��Բ��ϵؽ���������ָ��ָ��������ݣ���������ָ�������ƶ��������ַ��������������
     *
     * @param right
     * @param m
     * @param n
     */
    public void recurseAndReverse(ListNode right, int m, int n) {

        // ��n��ֵ����1ʱ�����Ǿͻ���
        if (n == 1) {
            return;
        }

        // ����rightָ��
        right = right.next;

        // ����leftָ��
        if (m > 1) {
            this.left = this.left.next;
        }

        // m��nͬʱ��һ�����ݹ�
        this.recurseAndReverse(right, m - 1, n - 1);

        // �������ָ�뽻�����ָ��ͬһ���ڵ� ��ֹͣ
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        // �޸�left��right�ڵ�����ݵ�ֵ �п��ܲ�����
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween_recursive(ListNode head, int m, int n) {
        // �ʼleft��right�ڵ㶼ָ��head�ڵ�
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }
}
