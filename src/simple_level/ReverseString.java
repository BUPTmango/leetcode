package simple_level;

/**
 * ����ת�㷨������Ƶ���⡷��ײָ��
 * 344
 * ��ת�ַ���
 * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������
 *
 * ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
 *
 * ����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���
 *
 * ʾ�� 1��
 *
 * ���룺["h","e","l","l","o"]
 * �����["o","l","l","e","h"]
 * ʾ�� 2��
 *
 * ���룺["H","a","n","n","a","h"]
 * �����["h","a","n","n","a","H"]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/18 9:16 ����
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        char middle;
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            middle = s[i];
            s[i] = s[j];
            s[j] = middle;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseString re = new ReverseString();
        re.reverseString(new char[] {'h', 'l', 'l', 'o'});
    }
}
