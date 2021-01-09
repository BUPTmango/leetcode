package middle_level.jianzhi_offer;


/**
 * ��ָ Offer 20. ��ʾ��ֵ���ַ���
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100"��"5e2"��"-123"��"3.1416"��"-1E-16"��"0123"����ʾ��ֵ����"12e"��"1a3.14"��"1.2.3"��"+-5"��"12e+5.4"�����ǡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/11 10:01 ����
 */
public class IsNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // �������������̣�ĩβ�пո������֣�����
        s = s.trim();
        try {
            double a = Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }

        char c = s.charAt(s.length() - 1);
        // �أ�ĩβ��f��d,D��Щ���㣬����3.�����֣��������������̣�
        return (c >= '0' && c <= '9') || c == '.';
    }
}
