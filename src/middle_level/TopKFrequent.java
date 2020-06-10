package middle_level;

import java.util.*;

/**
 * 347. ǰ K ����ƵԪ��
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ?k?�ߵ�Ԫ�ء�
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ����: nums = [1,1,1,2,2,3], k = 2
 * ���: [1,2]
 * ʾ�� 2:
 *
 * ����: nums = [1], k = 1
 * ���: [1]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/10 11:45 ����
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>(Comparator.comparingInt(count::get));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }
}
