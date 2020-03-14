package simple_level.jianzhi_offer;

/**
 * ������58 - I. ��ת����˳��
 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ϊ������������ź���ͨ��ĸһ���������������ַ���"I am a student. "�������"student. a am I"��
 *
 * ʾ�� 1��
 *
 * ����: "the sky is blue"
 * ���:?"blue is sky the"
 * ʾ�� 2��
 *
 * ����: " ?hello world! ?"
 * ���:?"world! hello"
 * ����: �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ʾ�� 3��
 *
 * ����: "a good ? example"
 * ���:?"example good a"
 * ����: ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 * ?
 * ˵����
 *
 * �޿ո��ַ�����һ�����ʡ�
 * �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/14 5:15 ����
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.trim().length() == 0) {
            return "";
        }
        String[] result = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i].length() != 0) {
                sb.append(result[i] + " ");
            }
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    public static void main(String[] args) {
        String s = "a good   example";
        String[] result = s.trim().split(" ");
        for (String str : result) {
            if (str.length() != 0) {
                System.out.println(str);
            }
        }
    }
}
