package middle_level.jianzhi_offer;

import java.util.Stack;

/**
 * ��ָ Offer 31. ջ��ѹ�롢��������
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ�
 * ���磬���� {1,2,3,4,5} ��ĳջ��ѹջ���У����� {4,5,3,2,1} �Ǹ�ѹջ���ж�Ӧ��һ���������У��� {4,3,5,1,2} �Ͳ������Ǹ�ѹջ���еĵ������С�
 *
 * ʾ�� 1��
 *
 * ���룺pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * �����true
 * ���ͣ����ǿ��԰�����˳��ִ�У�
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * ʾ�� 2��
 *
 * ���룺pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * �����false
 * ���ͣ�1 ������ 2 ֮ǰ������
 * ?
 *
 * ��ʾ��
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed?��?popped?�����С�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/20 12:23 ����
 */
public class ValidateStackSequences {
    /**
     * ���ǽ���һ������ջ stackstack ��ģ�� ѹ�� / �������������С������Ƿ�ģ��ɹ������ɵõ������
     *
     * ��ջ������ ����ѹջ���е�˳��ִ�С�
     * ��ջ������ ÿ����ջ��ѭ���ж� ��ջ��Ԫ�� == �������еĵ�ǰԪ�ء� �Ƿ�����������ϵ�������˳���ջ��Ԫ��ȫ��������
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // ����ջ
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            // num ��ջ
            stack.push(num);
            // ѭ���ж����ջ
            while(!stack.isEmpty() && stack.peek() == popped[i]) {
                // ջ��Ԫ�� == �������еĵ�ǰԪ��
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
