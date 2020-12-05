package middle_level;

import java.util.*;

/**
 * 621. ���������
 * ����һ�����ַ�����tasks ��ʾ�� CPU ��Ҫִ�е������б�����ÿ����ĸ��ʾһ�ֲ�ͬ����������������������˳��ִ�У�����ÿ�����񶼿����� 1 ����λʱ����ִ���ꡣ���κ�һ����λʱ�䣬CPU �������һ�����񣬻��ߴ��ڴ���״̬��
 *
 * Ȼ�������� ��ͬ���� ������֮������г���Ϊ���� n ����ȴʱ�䣬������������� n ����λʱ���� CPU ��ִ�в�ͬ�����񣬻����ڴ���״̬��
 *
 * ����Ҫ�������������������Ҫ�� ���ʱ�� ��
 *
 * ʾ�� 1��
 *
 * ���룺tasks = ["A","A","A","B","B","B"], n = 2
 * �����8
 * ���ͣ�A -> B -> (����) -> A -> B -> (����) -> A -> B
 *      �ڱ�ʾ���У�������ͬ��������֮�����������Ϊ n = 2 ����ȴʱ�䣬��ִ��һ������ֻ��Ҫһ����λʱ�䣬�����м�����ˣ�������״̬��
 * ʾ�� 2��
 *
 * ���룺tasks = ["A","A","A","B","B","B"], n = 0
 * �����6
 * ���ͣ�����������£��κδ�СΪ 6 �����ж���������Ҫ����Ϊ n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * �������
 * ʾ�� 3��
 *
 * ���룺tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * �����16
 * ���ͣ�һ�ֿ��ܵĽ�������ǣ�
 *      A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (����) -> (����) -> A -> (����) -> (����) -> A
 * 
 * ��ʾ��
 *
 * 1 <= task.length <= 104
 * tasks[i] �Ǵ�дӢ����ĸ
 * n ��ȡֵ��ΧΪ [0, 100]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/5 8:52 ����
 */
public class LeastInterval {
    /**
     * ģ��
     * ��Ҫѡ������ȴ�в���ʣ��ִ�д��������Ǹ�����
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // ��������
        int m = freq.size();
        // ������ȴ���� �������ִ�е�ʱ��
        List<Integer> nextValid = new ArrayList<>();
        // ʣ��ִ�д���
        List<Integer> rest = new ArrayList<>();
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int time = 0;
        for (int i = 0; i < tasks.length; ++i) {
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            // Ѱ����̵���һ������ִ�е�
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best = -1;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    // Ѱ��timeʱ�䷶Χ�ڵ�ʣ���������
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }

        return time;
    }

    /**
     * https://leetcode-cn.com/problems/task-scheduler/solution/tian-tong-si-lu-you-tu-kan-wan-jiu-dong-by-mei-jia/
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval_better(char[] tasks, int n) {
        // ͳ��ÿ������ĳ��ִ���
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A'] += 1;
        }
        // ��������������ִ���
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        // Ͱ�����������ľ��Σ����һ���� max count ��������
        int maxCount = 0;
        for (int count : counts) {
            if (count == max) {
                maxCount++;
            }
        }
        return Math.max((n + 1) * (max - 1) + maxCount, tasks.length);
    }
}
