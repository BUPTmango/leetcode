package simple_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. ���ҳ����ַ�
 * ��������Сд��ĸ��ɵ��ַ������� A�������б��е�ÿ���ַ����ж���ʾ��ȫ���ַ��������ظ��ַ�����ɵ��б����磬���һ���ַ���ÿ���ַ����г��� 3 �Σ������� 4 �Σ�����Ҫ�����մ��а������ַ� 3 �Ρ�
 *
 * ����԰�����˳�򷵻ش𰸡�
 *
 * ʾ�� 1��
 *
 * ���룺["bella","label","roller"]
 * �����["e","l","l"]
 * ʾ�� 2��
 *
 * ���룺["cool","lock","cook"]
 * �����["c","o"]
 *
 * ��ʾ��
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] ��Сд��ĸ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/14 11:52 ����
 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            // ͳ�Ƶ������ַ����ֵĴ���
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            // ÿ��ȡ���е�����ÿ���ַ����ֵ���Сֵ
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        // �����õ����
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
