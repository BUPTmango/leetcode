package middle_level;

import data_structure.linked_list.ListNode;

/**
 * 328. ��ż����
 * ����һ�������������е������ڵ��ż���ڵ�ֱ�����һ����ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�
 *
 * �볢��ʹ��ԭ���㷨��ɡ�����㷨�Ŀռ临�Ӷ�ӦΪ O(1)��ʱ�临�Ӷ�ӦΪ O(nodes)��nodes Ϊ�ڵ�������
 *
 * ʾ�� 1:
 *
 * ����: 1->2->3->4->5->NULL
 * ���: 1->3->5->2->4->NULL
 * ʾ�� 2:
 *
 * ����: 2->1->3->5->6->4->7->NULL
 * ���: 2->3->6->7->1->5->4->NULL
 * ˵��:
 *
 * Ӧ�����������ڵ��ż���ڵ�����˳��
 * ����ĵ�һ���ڵ���Ϊ�����ڵ㣬�ڶ����ڵ���Ϊż���ڵ㣬�Դ����ơ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/15 2:05 ����
 */
public class OddEvenList {
    /**
     * ����һ�����Ϊ�����ڵ���������һ�����Ϊż���ڵ������
     * �����Ϊż���ڵ�������������һ������Ľ�β
     * [note]
     * ���ȿ��ǵ��洢�ռ�Ҫ��˵����ѡֱ�Ӷ���������޸ģ������������µĿռ䡣
     * ��ο���ʱ�临�Ӷ�Ҫ��һ��ѭ����һ�α�������������
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}