package middle_level;

import data_structure.linked_list.ListNode;

import java.util.Random;

/**
 * 382. ��������ڵ�
 * ����һ�����������ѡ�������һ���ڵ㣬��������Ӧ�Ľڵ�ֵ����֤ÿ���ڵ㱻ѡ�ĸ���һ����
 *
 * ����:
 * �������ʮ�ִ��ҳ���δ֪����ν��������⣿���ܷ�ʹ�ó������ռ临�Ӷ�ʵ�֣�
 *
 * ʾ��:
 *
 * // ��ʼ��һ�������� [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom()����Ӧ�������1,2,3�е�һ������֤ÿ��Ԫ�ر����صĸ�����ȡ�
 * solution.getRandom();
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/8 20:23
 */
public class GetLinkedListRandom {

    ListNode head;
    Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public GetLinkedListRandom(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int reserve = 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            int  r = this.random.nextInt(count) + 1;
            if (r == count) {
                reserve = cur.val;
            }
            cur = cur.next;
        }
        return reserve;
    }
}
