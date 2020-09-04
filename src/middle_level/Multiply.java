package middle_level;

import java.util.Arrays;

/**
 * 43. �ַ������
 * �����������ַ�����ʽ��ʾ�ķǸ�����?num1?��?num2������?num1?��?num2?�ĳ˻������ǵĳ˻�Ҳ��ʾΪ�ַ�����ʽ��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: num1 = "2", num2 = "3"
 * ���: "6"
 * ʾ��?2:
 * <p>
 * ����: num1 = "123", num2 = "456"
 * ���: "56088"
 * ˵����
 * <p>
 * num1?��?num2?�ĳ���С��110��
 * num1 ��?num2 ֻ��������?0-9��
 * num1 ��?num2?�������㿪ͷ������������ 0 ����
 * ����ʹ���κα�׼��Ĵ������ͣ����� BigInteger����ֱ�ӽ�����ת��Ϊ����������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/4 6:30 ����
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        // ��num1��num2��ת����charArray
        char[] chrs1 = num1.toCharArray();
        char[] chrs2 = num2.toCharArray();
        // �洢�����char����
        char[] res = new char[chrs1.length + chrs2.length];
        Arrays.fill(res, '0');
        // ��ʽ�˷�
        for (int j = chrs2.length - 1; j >= 0; j--) {
            for (int i = chrs1.length - 1; i >= 0; i--) {
                // �˷�
                int product = (chrs1[i] - '0') * (chrs2[j] - '0');
                // ��ǰλ����productΪtmp
                int tmp = (res[i + j + 1] - '0') + product;
                // tmp����10���������ڵ�ǰλ�������λ
                res[i + j + 1] = (char) (tmp % 10 + '0');
                res[i + j] = (char) ((res[i + j] - '0') + tmp / 10 + '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        // ȥ��ͷ��0
        boolean seen = false;
        for (char c : res) {
            if (c == '0' && !seen) {
                continue;
            } else {
                seen = true;
                sb.append(c);
            }
        }
        // ����Ϊ0��˵������ͷ���ո�ȥ����
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
