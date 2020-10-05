package middle_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * ������ 02.08. ��·���
 * ����һ��������������л�����ʵ��һ���㷨���ػ�·�Ŀ�ͷ�ڵ㡣
 * �л�����Ķ��壺��������ĳ���ڵ��nextԪ��ָ������ǰ����ֹ��Ľڵ㣬�������������ڻ�·��
 *
 *
 * ʾ�� 1��
 *
 * ���룺head = [3,2,0,-4], pos = 1
 * �����tail connects to node index 1
 * ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 *
 * ʾ�� 2��
 *
 * ���룺head = [1,2], pos = 0
 * �����tail connects to node index 0
 * ���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
 *
 * ʾ�� 3��
 *
 * ���룺head = [1], pos = -1
 * �����no cycle
 * ���ͣ�������û�л���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/5 8:37 ����
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // �˴������if (slow != null && fast != null && slow.val == fast.val) �ᳬ��ʱ������
            if (slow == fast) {
                break;
            }
        }
        // ������ᴦ�����޻�·
        if (fast == null || fast.next == null) {
            return null;
        }

        // ����������ͬ���ٶ��ƶ������Ȼ�ڻ�·��ʼ������
        // slow��head��ʼ��fast�������㿪ʼ��һ��һ�����ٴ�������Ϊ�����
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
