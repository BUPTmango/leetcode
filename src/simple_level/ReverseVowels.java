package simple_level;

/**
 * ����ת�㷨������Ƶ���⡷��ײָ��
 * 345. ��ת�ַ����е�Ԫ����ĸ
 * ��дһ�����������ַ�����Ϊ���룬��ת���ַ����е�Ԫ����ĸ��
 *
 * ʾ�� 1��
 *
 * ���룺"hello"
 * �����"holle"
 * ʾ�� 2��
 *
 * ���룺"leetcode"
 * �����"leotcede"
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/28 7:22 ����
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // ����Ԫ����ĸ
        String vowels = "aeiouAEIOU";

        // ���ַ���ת����char��������
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            // ˫ָ�����������Ԫ���ַ�
            while (start < end && !vowels.contains(chars[start] + "")) {
                start++;
            }
            while (start < end && !vowels.contains(chars[end] + "")) {
                end--;
            }
            // �ҵ��󽻻���ĸ
            swap(chars, start, end);
            // ������������
            start++;
            end--;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }
}
