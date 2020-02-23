package simple_level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242
 * ��Ч����ĸ��λ��
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 *
 * ʾ��?1:
 *
 * ����: s = "anagram", t = "nagaram"
 * ���: true
 * ʾ�� 2:
 *
 * ����: s = "rat", t = "car"
 * ���: false
 * ˵��:
 * ����Լ����ַ���ֻ����Сд��ĸ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/19 9:58 ����
 */
public class IsAnagram {
    /**
     * �Լ�������
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = countString(s);
        Map<Character, Integer> mapT = countString(t);

        boolean flag = true;
        for (char c : mapS.keySet()) {
            if (!mapS.get(c).equals(mapT.get(c))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private Map<Character, Integer> countString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+ 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    /**
     * �Ƽ�������
     * ͨ���� ss ����ĸ�������г� tt �����ɱ�λ�ʡ�
     * ��ˣ���� TT �� SS �ı�λ�ʣ��������ַ����������򽫲���������ͬ���ַ���
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_better(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }

}
