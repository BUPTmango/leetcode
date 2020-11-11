package hard_level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ��������
 * 239. �����������ֵ
 * ����һ������ nums����һ����СΪk�Ļ������ڴ������������ƶ�����������Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k�����֡���������ÿ��ֻ�����ƶ�һλ��
 *
 * ���ػ��������е����ֵ��
 *
 * ���ף�
 *
 * ����������ʱ�临�Ӷ��ڽ��������
 *
 * ʾ��:
 *
 * ����: nums = [1,3,-1,-3,5,3,6,7], �� k = 3
 * ���: [3,3,5,5,6,7]
 * ����:
 *
 *   �������ڵ�λ��                ���ֵ
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 10^5
 * -10^4<= nums[i]<= 10^4
 * 1 <= k<= nums.length
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/11 7:52 ����
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // ���������ڵ�ǰk-1
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                // ������ǰ�ƶ� ����������
                window.push(nums[i]);
                // ��¼��ǰ�������ֵ
                res.add(window.max());
                // �Ƴ�������
                window.pop(nums[i - k + 1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    class MonotonicQueue {
        // Ҫʹ��һ�����ݽṹ֧����ͷ����β�����в����ɾ�� ˫����
        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n) {
            // ��ǰ��С���Լ���Ԫ�ض�ɾ��
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.pollLast();
            }
            queue.addLast(n);
        }

        public int max() {
            // ��ͷԪ�ؿ϶�������
            return queue.getFirst();
        }

        public void pop(int n) {
            // ��ɾ���Ķ�ͷԪ�ؿ����Ѿ��������� ��ʱ��Ͳ���ɾ����
            if (n == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }
}
