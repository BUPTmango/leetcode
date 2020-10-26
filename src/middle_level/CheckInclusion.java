package middle_level;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������ģ��
 * 567. �ַ���������
 * ���������ַ���s1��s2��дһ���������ж� s2 �Ƿ���� s1�����С�
 * <p>
 * ���仰˵����һ���ַ���������֮һ�ǵڶ����ַ������Ӵ���
 * <p>
 * ʾ��1:
 * <p>
 * ����: s1 = "ab" s2 = "eidbaooo"
 * ���: True
 * ����: s2 ���� s1 ������֮һ ("ba").
 * <p>
 * <p>
 * ʾ��2:
 * <p>
 * ����: s1= "ab" s2 = "eidboaoo"
 * ���: False
 * <p>
 * <p>
 * ע�⣺
 * <p>
 * ������ַ���ֻ����Сд��ĸ
 * �����ַ����ĳ��ȶ��� [1, 10,000] ֮��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/26 11:03 ����
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();

        // need��¼Ѱ���ִ���Ҫ�����������ַ� window��¼�����е������ַ�
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char n : char1) {
            need.put(n, need.getOrDefault(n, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = char2[right];
            right++;
            // ��������
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // ���ȴ���Ŀ��Ϳ�������
            while (right - left >= s1.length()) {
                // �������ж��Ƿ��ҵ��˺Ϸ����Ӵ�
                if (valid == need.size()) {
                    return true;
                }
                char d = char2[left];
                left++;
                // ���д��������ݵ�һϵ�и���
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // δ�ҵ�
        return false;
    }
}
