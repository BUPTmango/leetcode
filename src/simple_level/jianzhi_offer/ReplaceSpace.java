package simple_level.jianzhi_offer;

/**
 * ������05. �滻�ո�
 * ��ʵ��һ�����������ַ��� s �е�ÿ���ո��滻��"%20"��
 *
 * ʾ�� 1��
 *
 * ���룺s = "We are happy."
 * �����"We%20are%20happy."
 * ?
 *
 * ���ƣ�
 *
 * 0 <= s �ĳ��� <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/26 8:11 ����
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.replace(" ", "%20");
        return s;
    }
}
