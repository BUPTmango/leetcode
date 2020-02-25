package simple_level.jianzhi_offer;

/**
 * ������58 - II. ����ת�ַ���
 * �ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β�����붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
 *
 * ʾ�� 1��
 *
 * ����: s = "abcdefg", k = 2
 * ���:?"cdefgab"
 * ʾ�� 2��
 *
 * ����: s = "lrloseumgh", k = 6
 * ���:?"umghlrlose"
 * ?
 *
 * ���ƣ�
 *
 * 1 <= k < s.length <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/25 10:29 ����
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        String start = s.substring(0, n);
        String end = s.substring(n);
        return end + start;
    }

    public static void main(String[] args) {
        ReverseLeftWords re = new ReverseLeftWords();
        re.reverseLeftWords("abcdefg", 2);
    }
}
