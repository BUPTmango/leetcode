package middle_level;

import data_structure.linked_list.ListNode;
import util.LinkedListUtil;

/**
 * ����ת�㷨������Ƶ���⡷����
 * 86. �ָ�����
 * ����һ�������һ���ض�ֵ x����������зָ���ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��
 *
 * ��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�
 *
 * ?
 *
 * ʾ��:
 *
 * ����: head = 1->4->3->2->5->2, x = 3
 * ���: 1->2->2->4->3->5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/24 8:25 ����
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        // �ֱ�ʹ������������С��x�ʹ���x�� ֮������������
        if (head == null) {
            return null;
        }
        ListNode low = new ListNode(0);
        ListNode high = new ListNode(0);
        ListNode l_pointer = low, h_pointer = high;
        while (head != null) {
            if (head.val >= x) {
                h_pointer.next = head;
                h_pointer = h_pointer.next;
            } else {
                l_pointer.next = head;
                l_pointer = l_pointer.next;
            }
            head = head.next;
        }
        // Ҫ������仰 �������ѭ��
        // Ҫ�ϵ�֮��Ľڵ� Ҫ�������ѭ������ ��Ϊÿ�����head�ڵ�֮��ԭ�����ָ�벢û�жϵ�
        h_pointer.next = null;
        l_pointer.next = high.next;
        return low.next;
    }

    public static void main(String[] args) {
        PartitionLinkedList partition = new PartitionLinkedList();
        ListNode head = LinkedListUtil.create(new int[]{1, 4, 3, 2, 5, 2});
        LinkedListUtil.print(head);
        ListNode result = partition.partition(head, 3);
        LinkedListUtil.print(result);
    }
}
