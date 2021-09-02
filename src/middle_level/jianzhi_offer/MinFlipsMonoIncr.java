package middle_level.jianzhi_offer;

/**
 * ��ָ Offer II 092. ��ת�ַ�
 * ���һ����'0' �� '1'��ɵ��ַ���������һЩ '0'������û�� '0'���������һЩ '1'��Ҳ����û�� '1'������ʽ��ɵģ���ô���ַ����ǵ��������ġ�
 * ���Ǹ���һ�����ַ� '0' �� '1'��ɵ��ַ��� s�����ǿ��Խ��κ�'0' ��תΪ'1'���߽�'1'��תΪ'0'��
 * ����ʹ s������������С��ת������
 *
 * ʾ�� 1��
 *
 * ���룺s = "00110"
 * �����1
 * ���ͣ����Ƿ�ת���һλ�õ� 00111.
 * ʾ�� 2��
 *
 * ���룺s = "010110"
 * �����2
 * ���ͣ����Ƿ�ת�õ� 011111�������� 000111��
 * ʾ�� 3��
 *
 * ���룺s = "00011000"
 * �����2
 * ���ͣ����Ƿ�ת�õ� 00000000��
 * 
 *
 * ��ʾ��
 *
 * 1 <= s.length <= 20000
 * s ��ֻ�����ַ�'0'��'1'
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/2 14:40
 */
public class MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int numOfOne = (chars[0] == '1') ? 1 : 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (chars[i] == '1') {
                dp[i] = Math.min(dp[i - 1], numOfOne + 1);
                numOfOne++;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, numOfOne);
            }
        }
        return dp[len - 1];
    }
}
