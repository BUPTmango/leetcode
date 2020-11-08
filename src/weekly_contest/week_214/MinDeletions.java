package weekly_contest.week_214;

import java.util.HashMap;
import java.util.Map;

/**
 * 5562. �ַ�Ƶ��Ψһ����Сɾ������
 * ����ַ��� s �� ������ ������ͬ�ַ� Ƶ�� ��ͬ��������ͳ� s �� �����ַ��� ��
 * <p>
 * ����һ���ַ��� s������ʹ s ��Ϊ �����ַ��� ��Ҫɾ���� ��С �ַ�����
 * <p>
 * �ַ������ַ��� Ƶ�� �Ǹ��ַ����ַ����еĳ��ִ��������磬���ַ��� "aab" �У�'a' ��Ƶ���� 2���� 'b' ��Ƶ���� 1 ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aab"
 * �����0
 * ���ͣ�s �Ѿ��������ַ�����
 * ʾ�� 2��
 * <p>
 * ���룺s = "aaabbbcc"
 * �����2
 * ���ͣ�����ɾ������ 'b' , �õ������ַ��� "aaabcc" ��
 * ��һ�ַ�ʽ��ɾ��һ�� 'b' ��һ�� 'c' ���õ������ַ��� "aaabbc" ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "ceabaacb"
 * �����2
 * ���ͣ�����ɾ������ 'c' �õ������ַ��� "eabaab" ��
 * ע�⣬ֻ��Ҫ��ע����ַ�������Ȼ���ڵ��ַ���������Ƶ��Ϊ 0 ���ַ�����Բ��ơ���
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 105
 * s ����СдӢ����ĸ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/8 11:12 ����
 */
public class MinDeletions {
    public int minDeletions(String s) {
        int len = s.length();
        int[] tmp = new int[len + 1];
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map.keySet()) {
            tmp[map.get(ch)]++;
        }
        // ����1��ȫ�����¼�1
        for (int i = len; i > 0; i--) {
            if (tmp[i] > 1) {
                res += tmp[i] - 1;
                tmp[i - 1] += tmp[i] - 1;
            }
        }
        return res;
    }
}
