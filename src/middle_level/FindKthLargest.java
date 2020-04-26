package middle_level;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. �����еĵ�K�����Ԫ��
 * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 *
 * ʾ�� 1:
 *
 * ����: [3,2,1,5,6,4] �� k = 2
 * ���: 5
 * ʾ��?2:
 *
 * ����: [3,2,3,1,2,4,5,5,6] �� k = 4
 * ���: 4
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/25 12:00 ����
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // Comparator.comparingInt(n -> n)�ȼ���(n1, n2) -> n1 - n2
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        // ���������
        for (int n : nums) {
            heap.add(n);
            // ά����СΪk�Ķ�
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
