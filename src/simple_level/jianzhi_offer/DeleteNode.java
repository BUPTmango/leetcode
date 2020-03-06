package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

/**
 * ������18. ɾ������Ľڵ�
 * �������������ͷָ���һ��Ҫɾ���Ľڵ��ֵ������һ������ɾ���ýڵ㡣
 *
 * ����ɾ����������ͷ�ڵ㡣
 *
 * ע�⣺����Ա�ԭ���иĶ�
 *
 * ʾ�� 1:
 *
 * ����: head = [4,5,1,9], val = 5
 * ���: [4,1,9]
 * ����: ������������ֵΪ?5?�ĵڶ����ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 1 -> 9.
 * ʾ�� 2:
 *
 * ����: head = [4,5,1,9], val = 1
 * ���: [4,5,9]
 * ����: ������������ֵΪ?1?�ĵ������ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 5 -> 9.
 * ?
 *
 * ˵����
 *
 * ��Ŀ��֤�����нڵ��ֵ������ͬ
 * ��ʹ�� C �� C++ ���ԣ��㲻��Ҫ free �� delete ��ɾ���Ľڵ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/6 8:37 ����
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
