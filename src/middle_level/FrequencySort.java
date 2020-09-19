package middle_level;

import java.util.PriorityQueue;

/**
 * ����ת�㷨������Ƶ���⡷��������
 * 451. �����ַ�����Ƶ������
 * ����һ���ַ������뽫�ַ�������ַ����ճ��ֵ�Ƶ�ʽ������С�
 *
 * ʾ�� 1:
 *
 * ����:
 * "tree"
 *
 * ���:
 * "eert"
 *
 * ����:
 * 'e'�������Σ�'r'��'t'��ֻ����һ�Ρ�
 * ���'e'���������'r'��'t'֮ǰ�����⣬"eetr"Ҳ��һ����Ч�Ĵ𰸡�
 * ʾ�� 2:
 *
 * ����:
 * "cccaaa"
 *
 * ���:
 * "cccaaa"
 *
 * ����:
 * 'c'��'a'���������Ρ����⣬"aaaccc"Ҳ����Ч�Ĵ𰸡�
 * ע��"cacaca"�ǲ���ȷ�ģ���Ϊ��ͬ����ĸ�������һ��
 * ʾ�� 3:
 *
 * ����:
 * "Aabb"
 *
 * ���:
 * "bbAa"
 *
 * ����:
 * ���⣬"bbaA"Ҳ��һ����Ч�Ĵ𰸣���"Aabb"�ǲ���ȷ�ġ�
 * ע��'A'��'a'����Ϊ�����ֲ�ͬ���ַ���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/19 9:25 ����
 */
public class FrequencySort {
    /**
     * �ù�ϣ��洢ÿ���ַ��ĳ��ִ�����
     * ��ͨ��һ���󶥶ѣ����ݳ��ִ������򣩣�����ȡ���Ѷ�Ԫ�أ�
     * ʹ��StringBuilder����append���ɡ�
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        int[] letters = new int[128];
        // ��hash��洢ÿ��Ԫ�صĳ��ִ���
        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
        StringBuilder res = new StringBuilder();

        // ����Ԫ�صĳ��ִ�����Ԫ�ط���һ���󶥶���
        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] != 0) {
                heap.offer((char)i);
            }
        }

        // �����ִ�����Ϊ0���ַ�append��stringBuilder��
        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (letters[c]-- > 0) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
