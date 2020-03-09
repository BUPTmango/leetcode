package simple_level.jianzhi_offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ������40. ��С��k����
 * ������������ arr ���ҳ�������С�� k ���������磬����4��5��1��6��2��7��3��8��8�����֣�����С��4��������1��2��3��4��
 *
 * ʾ�� 1��
 *
 * ���룺arr = [3,2,1], k = 2
 * �����[1,2] ���� [2,1]
 * ʾ�� 2��
 *
 * ���룺arr = [0,1,2,1], k = 1
 * �����[0]
 * ?
 * ���ƣ�
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]?<= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/9 9:25 ����
 */
public class GetLeastNumbers {
    /**
     * Ӧ��PriorityQueue
     * ���Ǻ�ʱ��Ƚϳ�
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for(int i : arr) {
            if(queue.size() < k) {
                queue.add(i);
            } else {
                if(queue.peek() > i) {
                    queue.remove();
                    queue.add(i);
                }
            }
        }
        int[] ref = new int[k];
        int cnt = 0;
        while(queue.size() > 0) {
            ref[cnt++] = queue.remove();
        }
        return ref;
    }
}
