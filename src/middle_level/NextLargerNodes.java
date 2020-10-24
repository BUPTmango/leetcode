package middle_level;

import data_structure.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1019. �����е���һ������ڵ�
 * ����һ����ͷ�ڵ�head��Ϊ��һ���ڵ�����������еĽڵ�ֱ���Ϊ��node_1, node_2, node_3, ... ��
 *
 * ÿ���ڵ㶼��������һ������ֵ��next larger value��������node_i�������next_larger(node_i)��node_j.val����ô����j > i��node_j.val > node_i.val����j�ǿ��ܵ�ѡ������С���Ǹ������������������j����ô��һ������ֵΪ0��
 *
 * ��������������answer������answer[i] = next_larger(node_{i+1})��
 *
 * ע�⣺�������ʾ���У����� [2,1,5] ���������루�������������������л���ʾ����ͷ�ڵ��ֵΪ2���ڶ����ڵ�ֵΪ 1���������ڵ�ֵΪ5 ��
 *
 * 
 *
 * ʾ�� 1��
 *
 * ���룺[2,1,5]
 * �����[5,5,0]
 * ʾ�� 2��
 *
 * ���룺[2,7,4,3,5]
 * �����[7,0,5,5,0]
 * ʾ�� 3��
 *
 * ���룺[1,7,5,1,9,2,5,1]
 * �����[7,9,9,9,0,5,0,0]
 * 
 *
 * ��ʾ��
 *
 * ���������е�ÿ���ڵ㣬1 <= node.val<= 10^9
 * �����б�ĳ����� [0, 10000]��Χ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/24 11:36 ����
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // ����һ������ջ
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[list.size()];
        // �Ӻ���ǰ����
        for (int i = list.size() - 1; i >= 0; i--) {
            // ���ջ�бȵ�ǰԪ��С������Ԫ��
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }
            // ȡ��ջ��Ԫ����Ϊ�����iλ��
            res[i] = stack.isEmpty() ? 0 : stack.peek();
            // ��list�е�iλ�ü���ջ��
            stack.push(list.get(i));
        }
        return res;
    }
}
