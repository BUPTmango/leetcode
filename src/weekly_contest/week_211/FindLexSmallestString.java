package weekly_contest.week_211;

import java.util.ArrayList;
import java.util.List;

/**
 * 5544. ִ�в������ֵ�����С���ַ���
 * ����һ���ַ��� s �Լ��������� a �� b �����У��ַ��� s �ĳ���Ϊż�����ҽ������� 0 �� 9 ��ɡ�
 * <p>
 * ������� s �ϰ�����˳����ִ��������������֮һ��
 * <p>
 * �ۼӣ���  a �ӵ� s �������±�Ϊ������Ԫ���ϣ��±�� 0 ��ʼ��������һ������ 9 �ͻ��� 0�����ѭ�����������磬��� s = "3456" �� a = 5����ִ�д˲����� s ��� "3951"��
 * ��ת���� s ������ת b λ�����磬��� s = "3456" �� b = 1����ִ�д˲����� s ��� "6345"��
 * ���㷵���� s ��ִ��������������κ���Եõ��� �ֵ�����С ���ַ�����
 * <p>
 * ��������ַ���������ͬ����ô�ַ��� a �ֵ�����ַ��� b С�����������壺�� a �� b ���ֲ�ͬ�ĵ�һ��λ���ϣ��ַ��� a �е��ַ���������ĸ���е�ʱ������ b �еĶ�Ӧ�ַ������磬"0158�� �ֵ���� "0190" С����Ϊ��ͬ�ĵ�һ��λ�����ڵ������ַ�����Ȼ '5' ������ '9' ֮ǰ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "5525", a = 9, b = 2
 * �����"2050"
 * ���ͣ�ִ�в������£�
 * ��̬��"5525"
 * ��ת��"2555"
 * �ۼӣ�"2454"
 * �ۼӣ�"2353"
 * ��ת��"5323"
 * �ۼӣ�"5222"
 * �ۼӣ�"5121"
 * ��ת��"2151"
 * �ۼӣ�"2050"????????????
 * �޷�����ֵ���С�� "2050" ���ַ�����
 * ʾ�� 2��
 * <p>
 * ���룺s = "74", a = 5, b = 1
 * �����"24"
 * ���ͣ�ִ�в������£�
 * ��̬��"74"
 * ��ת��"47"
 * �ۼӣ�"42"
 * ��ת��"24"
 * �޷�����ֵ���С�� "24" ���ַ�����
 * ʾ�� 3��
 * <p>
 * ���룺s = "0011", a = 4, b = 2
 * �����"0011"
 * ���ͣ��޷�����ֵ���С�� "0011" ���ַ�����
 * ʾ�� 4��
 * <p>
 * ���룺s = "43987654", a = 7, b = 3
 * �����"00553311"
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= s.length <= 100
 * s.length ��ż��
 * s �������� 0 �� 9 ���
 * 1 <= a <= 9
 * 1 <= b <= s.length - 1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 10:45 ����
 */
public class FindLexSmallestString {
    String rotate(String s1, String s2, int b) {
        String s = "";
        for (int i = 0; i < s1.length(); i++) {
            s += s2.charAt(i);
            s += s1.charAt(i);
        }
        if (b == 0) {
            return s;
        }
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str += s.charAt((i + b) % s.length());
        }
        return str;
    }

    String helper(String s, List<Integer> lst, int b) {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                s3 += s.charAt(i);
            } else {
                s4 += s.charAt(i);
            }
        }
        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        lst1.add(s3);
        lst2.add(s4);
        for (int i = 0; i < lst.size(); i++) {
            int n = lst.get(i);
            s1 = "";
            s2 = "";
            for (int j = 1; j < s.length(); j += 2) {
                int k = s.charAt(j) - '0' - n;
                if (k < 0) k += 10;
                s1 += k;
            }
            lst1.add(s1);
            if (b % 2 == 1) {
                for (int j = 0; j < s.length(); j += 2) {
                    int k = s.charAt(j) - '0' - n;
                    if (k < 0) k += 10;
                    s2 += k;
                }
                lst2.add(s2);
            }
        }
        String str = s;
        for (int i = 0; i < lst2.size(); i++) {
            for (int j = 0; j < lst1.size(); j++) {
                int l = 1;
                String temp = rotate(lst1.get(j), lst2.get(i), 0);
                if (str.compareTo(temp) > 0) str = temp;
                while (l * b % s.length() != 0) {

                    temp = rotate(lst1.get(j), lst2.get(i), l * b);
                    if (str.compareTo(temp) > 0) str = temp;
                    l++;
                }
            }
        }
        return str;

    }

    public String findLexSmallestString(String s, int a, int b) {
        List<Integer> lst = new ArrayList<>();
        int n = 10 - a;
        int k = n;
        do {
            if (k != 0) {
                lst.add(k);
            }
            k = (n + k) % 10;
        } while (n != k);
        return helper(s, lst, b);
    }
}
