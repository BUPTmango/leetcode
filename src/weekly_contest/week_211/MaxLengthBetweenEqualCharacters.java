package weekly_contest.week_211;

import java.util.HashMap;
import java.util.Map;

/**
 * 5543. ������ͬ�ַ�֮�������ַ���
 * ����һ���ַ��� s�����㷵�� ������ͬ�ַ�֮�������ַ����ĳ��� �����㳤��ʱ�����������ַ���������������������ַ��������� -1 ��
 *
 * ���ַ��� ���ַ����е�һ�������ַ����С�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "aa"
 * �����0
 * ���ͣ����ŵ����ַ��������� 'a' ֮��Ŀ����ַ�����
 * ʾ�� 2��
 *
 * ���룺s = "abca"
 * �����2
 * ���ͣ����ŵ����ַ����� "bc" ��
 * ʾ�� 3��
 *
 * ���룺s = "cbzxy"
 * �����-1
 * ���ͣ�s �в����ڳ��ֳ������ε��ַ������Է��� -1 ��
 * ʾ�� 4��
 *
 * ���룺s = "cabbac"
 * �����4
 * ���ͣ����ŵ����ַ����� "abba" �������ķ����Ž���� "bb" �� "" ��
 *
 *
 * ��ʾ��
 *
 * 1 <= s.length <= 300
 * s ֻ��СдӢ����ĸ
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 10:32 ����
 */
public class MaxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        // to hashmap
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // ע�⣡���� Ĭ��ֵΪ-1
        int max = -1;
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) < 2) {
                continue;
            }
            // ��Ȼ���ֹ���������
            int length = 0;
            for (int j = i + 1; j < chars.length; j++) {
                // �ҵ��ظ��ַ� ���³���
                if (chars[i] == chars[j]) {
                    length = j - i - 1;
                }
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
