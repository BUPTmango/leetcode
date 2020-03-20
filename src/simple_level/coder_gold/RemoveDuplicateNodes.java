package simple_level.coder_gold;

import data_structure.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ������ 02.01. �Ƴ��ظ��ڵ�
 * ��д���룬�Ƴ�δ���������е��ظ��ڵ㡣�����ʼ���ֵĽڵ㡣
 *
 * ʾ��1:
 *
 *  ���룺[1, 2, 3, 3, 2, 1]
 *  �����[1, 2, 3]
 * ʾ��2:
 *
 *  ���룺[1, 1, 1, 1, 2]
 *  �����[1, 2]
 * ��ʾ��
 *
 * ��������[0, 20000]��Χ�ڡ�
 * ����Ԫ����[0, 20000]��Χ�ڡ�
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/20 9:23 ����
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode prev = new ListNode(0);
        ListNode current = head;
        prev.next = head;
        while (current != null) {
            if (set.contains(current.val)) {
                prev.next = current.next;
            } else {
                set.add(current.val);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
