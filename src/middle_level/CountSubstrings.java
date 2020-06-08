package middle_level;

/**
 * 647. �����Ӵ�
 * ����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���
 *
 * ���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ��Ϊ�ǲ�ͬ���Ӵ���
 *
 * ʾ�� 1:
 *
 * ����: "abc"
 * ���: 3
 * ����: ���������Ӵ�: "a", "b", "c".
 * ʾ�� 2:
 *
 * ����: "aaa"
 * ���: 6
 * ˵��: 6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa".
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/8 10:05 ����
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        // ������չ��
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left��rightָ������ĵ�Ĺ�ϵ�ǣ�
            // ������left����һ�������Ե�2����ϵ�Ĵ��ڣ������right��
            // ���ܺ�leftָ��ͬһ����ż��ʱ����Ҳ���������ƶ�һ����������
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
