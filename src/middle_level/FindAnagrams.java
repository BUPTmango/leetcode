package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������ģ��
 * ����ת�㷨������Ƶ���⡷ ��������
 * 438. �ҵ��ַ�����������ĸ��λ��
 * ����һ���ַ���?s?��һ���ǿ��ַ���?p���ҵ�?s?��������?p?����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������
 * <p>
 * �ַ���ֻ����СдӢ����ĸ�������ַ���?s?�� p?�ĳ��ȶ������� 20100��
 * <p>
 * ˵����
 * <p>
 * ��ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 * �����Ǵ������˳��
 * ʾ��?1:
 * <p>
 * ����:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * ���:
 * [0, 6]
 * <p>
 * ����:
 * ��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����ĸ��λ�ʡ�
 * ��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����ĸ��λ�ʡ�
 * ?ʾ�� 2:
 * <p>
 * ����:
 * s: "abab" p: "ab"
 * <p>
 * ���:
 * [0, 1, 2]
 * <p>
 * ����:
 * ��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
 * ��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����ĸ��λ�ʡ�
 * ��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/19 10:45 ����
 */
public class FindAnagrams {
    /**
     * ���ڻ���+��������ָ��
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();

        // ������󷵻صĽ��
        List<Integer> ans = new ArrayList<>();

        // ����һ�� needs �������� arrP �а���Ԫ�صĸ���
        int[] needs = new int[26];
        // ����һ�� window �������������������Ƿ��� arrP �е�Ԫ�أ�����¼���ֵĸ���
        int[] window = new int[26];
        // �Ƚ� arrP �е�Ԫ�ر��浽 needs ������
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }

        // ���廬�����ڵ�����
        int left = 0;
        int right = 0;

        // �Ҵ��ڿ�ʼ���������ƶ�
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            // ���Ҵ��ڵ�ǰ���ʵ���Ԫ�� curR ������ 1
            window[curR] += 1;

            // �� window ������ curR �� needs �����ж�ӦԪ�صĸ���Ҫ���ʱ��͸��ƶ��󴰿�ָ��
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                // ���󴰿ڵ�ǰ���ʵ���Ԫ�� curL ������ 1
                window[curL] -= 1;
            }

            // ���ｫ���з���Ҫ����󴰿��������뵽�˽��ս���� List ��
            if (right - left == arrP.length) {
                ans.add(left);
            }
        }
        return ans;
    }
}
