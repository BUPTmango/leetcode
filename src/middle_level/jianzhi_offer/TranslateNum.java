package middle_level.jianzhi_offer;

/**
 * ������46. �����ַ�����ַ���
 * ����һ�����֣����ǰ������¹����������Ϊ�ַ�����0 ����� ��a�� ��1 ����� ��b����������11 ����� ��l����������25 ����� ��z����һ�����ֿ����ж�����롣����ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ����: 12258
 * ���: 5
 * ����: 12258��5�ֲ�ͬ�ķ��룬�ֱ���"bccfi", "bwfi", "bczi", "mcfi"��"mzi"
 * ?
 *
 * ��ʾ��
 *
 * 0 <= num < 231
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/11 11:22 ����
 */
public class TranslateNum {
    /**
     * ��̬�滮 ���������� һ����ǰ�����м����һλ ��һ����ǰ�����м������λ
     * ʹ��ѭ������
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = s.length() - 2; i > -1; i--) {
            String tmp = s.substring(i, i + 2);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
