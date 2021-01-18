package middle_level;

import data_structure.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ����ָ�� �жϻ�
 * 142. �������� II
 * ����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣?��������޻����򷵻�?null��
 *
 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
 *
 * ˵�����������޸ĸ���������
 *
 *
 * ʾ�� 1��
 *
 * ���룺head = [3,2,0,-4], pos = 1
 * �����tail connects to node index 1
 * ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 *
 *
 * ʾ��?2��
 *
 * ���룺head = [1,2], pos = 0
 * �����tail connects to node index 0
 * ���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
 *
 *
 * ʾ�� 3��
 *
 * ���룺head = [1], pos = -1
 * �����no cycle
 * ���ͣ�������û�л���
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/10 9:07 ����
 */
public class DetectCycle {
    /**
     * ����ָ��
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // ���ڻ�
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
