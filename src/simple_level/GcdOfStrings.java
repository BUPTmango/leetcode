package simple_level;

/**
 * 1071. �ַ������������
 * �����ַ���?S ��?T��ֻ���� S = T + ... + T��T?���������� 1 �λ��Σ�ʱ�����ǲ��϶�?��T �ܳ��� S����
 *
 * ������ַ���?X��Ҫ������?X �ܳ��� str1 ��?X �ܳ��� str2��
 *
 * ʾ�� 1��
 *
 * ���룺str1 = "ABCABC", str2 = "ABC"
 * �����"ABC"
 * ʾ�� 2��
 *
 * ���룺str1 = "ABABAB", str2 = "ABAB"
 * �����"AB"
 * ʾ�� 3��
 *
 * ���룺str1 = "LEET", str2 = "CODE"
 * �����""
 * ?
 * ��ʾ��
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] ��?str2[i] Ϊ��дӢ����ĸ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/4 12:13 ����
 */
public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        // ����str1��N��x��str2��M��x����ôstr1+str2�϶��ǵ���str2+str1�ġ�
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // շת�������gcd��
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }
}
