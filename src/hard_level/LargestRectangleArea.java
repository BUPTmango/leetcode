package hard_level;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. ��״ͼ�����ľ���
 * ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
 *
 * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
 *
 * ��������״ͼ��ʾ��������ÿ�����ӵĿ��Ϊ 1�������ĸ߶�Ϊ[2,1,5,6,2,3]��
 *
 * ͼ����Ӱ����Ϊ���ܹ��ճ�������������������Ϊ10����λ��
 *
 * ʾ��:
 *
 * ����: [2,1,5,6,2,3]
 * ���: 10
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/26 1:54 ����
 */
public class LargestRectangleArea {
    /**
     * ����ջ
     * https://www.bilibili.com/video/BV1eb411M7Gm
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // ��-1��ȥ �߽�����ô���
        stack.push(-1);
        int curIndex = 0;

        while (curIndex < n) {
            // ������������ �Ͱ�ǰ����ó�����һ��max
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[curIndex]) {
                max = Math.max(max, heights[stack.pop()] * (curIndex - stack.peek() - 1));
            }
            stack.push(curIndex++);
        }

        // ʣ�µ�ȫ���ǵ����� ����һ��max
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (n - stack.peek() - 1));
        }

        return max;
    }
}
