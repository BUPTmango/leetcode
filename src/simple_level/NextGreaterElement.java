package simple_level;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ����ջ
 * 496. ��һ������Ԫ�� I
 * �������� û���ظ�Ԫ�� ������nums1 ��nums2������nums1��nums2���Ӽ����ҵ�nums1��ÿ��Ԫ����nums2�е���һ��������ֵ��
 *
 * nums1������x����һ������Ԫ����ָx��nums2�ж�Ӧλ�õ��ұߵĵ�һ����x���Ԫ�ء���������ڣ���Ӧλ����� -1 ��
 *
 * ʾ�� 1:
 *
 * ����: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * ���: [-1,3,-1]
 * ����:
 *     ����num1�е�����4�����޷��ڵڶ����������ҵ���һ����������֣������� -1��
 *     ����num1�е�����1���ڶ�������������1�ұߵ���һ���ϴ������� 3��
 *     ����num1�е�����2���ڶ���������û����һ����������֣������� -1��
 * ʾ�� 2:
 *
 * ����: nums1 = [2,4], nums2 = [1,2,3,4].
 * ���: [3,-1]
 * ����:
 *    ���� num1 �е����� 2 ���ڶ��������е���һ���ϴ������� 3 ��
 *     ���� num1 �е����� 4 ���ڶ���������û����һ����������֣������� -1 ��
 * 
 * ��ʾ��
 *
 * nums1��nums2������Ԫ����Ψһ�ġ�
 * nums1��nums2�������С��������1000��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/31 5:13 ����
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nums2����map�� �������
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        int[] fullRes = new int[nums2.length];
        // ������ջ���
        for (int i = nums2.length - 1; i >= 0; i--) {
            // �жϸ��Ӹ߰�
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                // ������ ����Ҳ��������
                stack.pop();
            }
            fullRes[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = fullRes[map.get(nums1[i])];
        }
        return res;
    }
}
