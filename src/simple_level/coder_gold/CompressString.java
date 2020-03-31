package simple_level.coder_gold;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ 01.06. �ַ���ѹ��
 * �ַ���ѹ���������ַ��ظ����ֵĴ�������дһ�ַ�����ʵ�ֻ������ַ���ѹ�����ܡ����磬�ַ���aabcccccaaa���Ϊa2b1c5a3������ѹ��������ַ���û�б�̣��򷵻�ԭ�ȵ��ַ���������Լ����ַ�����ֻ������СдӢ����ĸ��a��z����
 *
 * ʾ��1:
 *
 *  ���룺"aabcccccaaa"
 *  �����"a2b1c5a3"
 * ʾ��2:
 *
 *  ���룺"abbccd"
 *  �����"abbccd"
 *  ���ͣ�"abbccd"ѹ����Ϊ"a1b2c2d1"����ԭ�ַ������ȸ�����
 * ��ʾ��
 *
 * �ַ���������[0, 50000]��Χ�ڡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/31 11:20 ����
 */
public class CompressString {
    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char target = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == target) {
                count++;
            } else {
                sb.append(target);
                sb.append(count);
                target = S.charAt(i);
                count = 1;
            }
        }
        sb.append(target);
        sb.append(count);
        return sb.toString().length() < S.length() ? sb.toString() : S;
    }
}
