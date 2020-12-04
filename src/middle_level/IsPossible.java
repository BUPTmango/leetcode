package middle_level;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 659. �ָ�����Ϊ����������
 * ����һ��������������������� num�����ܰ����ظ����֣������㽫���Ƿָ��һ�����������У�����ÿ�������ж���������������ҳ�������Ϊ 3 ��
 * <p>
 * ���������������ָ�򷵻� true �����򣬷��� false ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ����: [1,2,3,3,4,5]
 * ���: True
 * ����:
 * ����Էָ�������������������� :
 * 1, 2, 3
 * 3, 4, 5
 * <p>
 * ʾ�� 2��
 * <p>
 * ����: [1,2,3,3,4,4,5,5]
 * ���: True
 * ����:
 * ����Էָ�������������������� :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * <p>
 * ʾ�� 3��
 * <p>
 * ����: [1,2,3,4,4,5]
 * ���: False
 * <p>
 * ��ʾ��
 * <p>
 * ��������鳤�ȷ�ΧΪ [1, 10000]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/4 8:52 ����
 */
public class IsPossible {
    /**
     * ��ϣ�� + ��С��
     * ֻҪ֪�������е����һ��Ԫ�غ������еĳ��ȾͿ���ȷ��������
     * ��ϣ��ļ�Ϊ�����е����һ�����֣�ֵΪ��С�ѣ����ڴ洢���е������г��ȣ���С������Ѷ���Ԫ������С�ģ���˶Ѷ���Ԫ�ؼ�Ϊ��С�������г��ȡ�
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<>());
            }
            // �� x ��������ʱ���������һ���������� x-1 ��β������Ϊ k������Խ� x ������������У��õ�����Ϊ k+1 �������С�
            // ����������� x-1 ��β�������У�������½�һ��ֻ���� x �������У�����Ϊ 1��
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                // ȡ���˼ǵ�ɾ��
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                // ����ԭ������������
                map.get(x).offer(prevLength + 1);
            } else {
                // �����µ�������
                map.get(x).offer(1);
            }
        }

        // ��Ϊ��С�������ж��ڶѶ� ���Ա���ÿ���ѵĶѶ�Ԫ�� ���Ȳ�С��3����
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }

    /**
     * ̰��
     * �������ⴴ���̵�������
     * @param nums
     * @return
     */
    public boolean isPossible_faster(int[] nums) {
        // ͳ��ÿ�����ֳ��ֵĴ���
        Map<Integer, Integer> countMap = new HashMap<>();
        // �洢�����е�ÿ��������Ϊ��β�������е�����
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0) + 1;
            countMap.put(x, count);
        }
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if (count > 0) {
                int prevEndCount = endMap.getOrDefault(x - 1, 0);
                // �����x-1�������оͼ���
                if (prevEndCount > 0) {
                    // ��Ϊʹ����һ�� countҪ��1
                    countMap.put(x, count - 1);
                    // x-1Ϊ��β��������1 xΪ��β��������1
                    endMap.put(x - 1, prevEndCount - 1);
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {
                    // xҪ�������� ��Ϊ���Ȳ�������3 ��ôx+1��x+2�ĸ���������Ϊ0 �����ܴ���
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    int count2 = countMap.getOrDefault(x + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(x, count - 1);
                        countMap.put(x + 1, count1 - 1);
                        countMap.put(x + 2, count2 - 1);
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
