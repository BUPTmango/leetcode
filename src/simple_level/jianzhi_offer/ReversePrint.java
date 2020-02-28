package simple_level.jianzhi_offer;

import data_structure.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ������06. ��β��ͷ��ӡ����
 * ����һ�������ͷ�ڵ㣬��β��ͷ����������ÿ���ڵ��ֵ�������鷵�أ���
 *
 * ʾ�� 1��
 *
 * ���룺head = [1,3,2]
 * �����[2,3,1]
 * ?
 * ���ƣ�
 *
 * 0 <= ������ <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/28 7:54 ����
 */
public class ReversePrint {
    /**
     * ʹ��ջ
     * Stack
     * @param head
     * @return
     */
    public int[] reversePrint_stack(ListNode head) {
        ListNode iter = head;
        Stack<ListNode> stack = new Stack<>();
        while (iter != null) {
            stack.push(iter);
            iter = iter.next;
        }
        // stack�ĳ����ǻ�ı�ģ�������ǰ��ã���������
        int size = stack.size();
        int[] result = new int[size];
        for (int j = 0; j < size; j++) {
            result[j] = stack.pop().val;
        }
        return result;
    }

}
