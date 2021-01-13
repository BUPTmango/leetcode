package simple_level.jianzhi_offer;

/**
 * ������05. ti�滻�ո�
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

    public String replaceSpace_array(String s) {
        int length = s.length();
        // ����Ϊ3���Ĵ�С ����ȫ�ǿո�Ҳ����Խ��
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}
