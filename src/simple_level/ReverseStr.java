package simple_level;

/**
 * 541. ��ת�ַ��� II
 * ����һ���ַ��� s ��һ������ k������Ҫ�Դ��ַ�����ͷ�����ÿ��?2k ���ַ���ǰ k ���ַ����з�ת��
 *
 * ���ʣ���ַ����� k ������ʣ���ַ�ȫ����ת��
 * ���ʣ���ַ�С�� 2k �����ڻ���� k ������תǰ k ���ַ��������ַ�����ԭ����
 * ?
 *
 * ʾ��:
 *
 * ����: s = "abcdefg", k = 2
 * ���: "bacdfeg"
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/5 10:15 ����
 */
public class ReverseStr {
    /**
     * ֱ�ӷ�תÿ�� 2k �ַ���
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                // ��β����
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
