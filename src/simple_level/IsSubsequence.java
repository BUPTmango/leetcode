package simple_level;

/**
 * ����ת�㷨������Ƶ���⡷̰���㷨
 * 392. �ж�������
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 *
 * �������Ϊ s �� t �н�����Ӣ��Сд��ĸ���ַ��� t ���ܻ�ܳ������� ~= 500,000������ s �Ǹ����ַ��������� <=100����
 *
 * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
 *
 * ʾ��?1:
 * s = "abc", t = "ahbgdc"
 *
 * ����?true.
 *
 * ʾ��?2:
 * s = "axc", t = "ahbgdc"
 *
 * ����?false.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/5 1:03 ����
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
