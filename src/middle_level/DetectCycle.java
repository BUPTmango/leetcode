package middle_level;

import data_structure.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
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
    public ListNode detectCycle_pointer(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            // slow��һ�� fast������
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                // ���ߵ�ͷ ˵��û�л�
                return null;
            }
            // �ҵ���֮�� ��ͷ����
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public ListNode detectCycle_set(ListNode head) {
        ListNode pos = head;
        Set<ListNode> set = new HashSet<>();
        while (pos != null) {
            if (set.contains(pos)) {
                // ���ֻ�
                return pos;
            } else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
