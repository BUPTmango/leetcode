package middle_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * ������ 02.08. ��·���
 * ����һ��������������л�����ʵ��һ���㷨���ػ�·�Ŀ�ͷ�ڵ㡣
 * �л�����Ķ��壺��������ĳ���ڵ��nextԪ��ָ������ǰ����ֹ��Ľڵ㣬�������������ڻ�·��
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺head = [3,2,0,-4], pos = 1
 * �����tail connects to node index 1
 * ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺head = [1,2], pos = 0
 * �����tail connects to node index 0
 * ���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
 * <p>
 * ʾ�� 3��
 * <p>
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
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            // ע�⣡�� ����Ҫ�������ж�
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // �ҵ�����
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
