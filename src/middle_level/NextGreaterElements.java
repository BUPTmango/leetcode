package middle_level;

import java.util.Stack;

/**
 * ����ջ
 * 503. ��һ������Ԫ�� II
 * ����һ��ѭ�����飨���һ��Ԫ�ص���һ��Ԫ��������ĵ�һ��Ԫ�أ������ÿ��Ԫ�ص���һ������Ԫ�ء����� x ����һ�������Ԫ���ǰ��������˳���������֮��ĵ�һ�������������������ζ����Ӧ��ѭ��������������һ�������������������ڣ������ -1��
 *
 * ʾ�� 1:
 *
 * ����: [1,2,1]
 * ���: [2,-1,2]
 * ����: ��һ�� 1 ����һ����������� 2��
 * ���� 2 �Ҳ�����һ�����������
 * �ڶ��� 1 ����һ����������Ҫѭ�����������Ҳ�� 2��
 * ע��: ��������ĳ��Ȳ��ᳬ�� 10000��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/11 11:02 ����
 */
public class NextGreaterElements {
    /**
     * ����ջ
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // ��װ������鳤�ȷ�����
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            // ����Ҫ��ģ �����ĺ�ģ��һ��
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
