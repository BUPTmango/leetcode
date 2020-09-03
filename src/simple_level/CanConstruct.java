package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. �����
 * ����һ������� (ransom) �ַ�����һ����־(magazine)�ַ������жϵ�һ���ַ��� ransom �ܲ����ɵڶ����ַ��� magazines ������ַ����ɡ�������Թ��ɣ����� true �����򷵻� false��
 *
 * (��Ŀ˵����Ϊ�˲���¶������ּ���Ҫ����־������������Ҫ����ĸ����ɵ����������˼����־�ַ����е�ÿ���ַ�ֻ����������ַ�����ʹ��һ�Ρ�)
 *
 * ?
 *
 * ע�⣺
 *
 * ����Լ��������ַ�����ֻ����Сд��ĸ��
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/3 9:25 ����
 */
public class CanConstruct {
    /**
     * �Լ���д��
     *
     * ����һ��˼·��
     * ��һ�α�������¼ransonNote����ĸ���ֵĴ�����
     * �ڶ��α�������¼magazine����ĸ���ֵĴ�����
     * Ȼ��֤ransonNote����ĸ���ֵĴ��� <= magazine����Ӧ��ĸ�������ɡ�
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] source = magazine.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : source) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        char[] result = ransomNote.toCharArray();
        for (char ch : result) {
            if (!charMap.containsKey(ch)) {
                return false;
            } else if (charMap.get(ch) == 0) {
                return false;
            } else {
                charMap.put(ch, charMap.get(ch) - 1);
            }
        }

        return true;
    }
}
