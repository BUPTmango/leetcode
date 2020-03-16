package simple_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * ������ 02.02. ���ص����� k ���ڵ�
 * ʵ��һ���㷨���ҳ����������е����� k ���ڵ㡣���ظýڵ��ֵ��
 *
 * ע�⣺�������ԭ�������Ķ�
 *
 * ʾ����
 *
 * ���룺 1->2->3->4->5 �� k = 2
 * ����� 4
 * ˵����
 *
 * ������ k?��֤����Ч�ġ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/16 9:56 ����
 */
public class KthToLast {
    /**
     * 1������fast��ǰ��K����
     * 2��slow��fastͬ��ǰ����fast����β��slow��Ŀ�ꡣ
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (k > 0) {
                fast = fast.next;
                k--;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow.val;
    }
}
