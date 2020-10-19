package simple_level;

/**
 * 844. �ȽϺ��˸���ַ���
 * ���� S �� T �����ַ����������Ƿֱ����뵽�հ׵��ı��༭�����ж϶����Ƿ���ȣ������ؽ���� # �����˸��ַ���
 *
 * ע�⣺����Կ��ı������˸��ַ����ı�����Ϊ�ա�
 *
 * 
 *
 * ʾ�� 1��
 *
 * ���룺S = "ab#c", T = "ad#c"
 * �����true
 * ���ͣ�S �� T ������ ��ac����
 * ʾ�� 2��
 *
 * ���룺S = "ab##", T = "c#d#"
 * �����true
 * ���ͣ�S �� T ������ ������
 * ʾ�� 3��
 *
 * ���룺S = "a##c", T = "#a#c"
 * �����true
 * ���ͣ�S �� T ������ ��c����
 * ʾ�� 4��
 *
 * ���룺S = "a#c", T = "b"
 * �����false
 * ���ͣ�S ���� ��c������ T ��Ȼ�� ��b����
 * 
 *
 * ��ʾ��
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S �� T ֻ����Сд��ĸ�Լ��ַ� '#'��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/19 11:33 ����
 */
public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return changeStr(S).equals(changeStr(T));
    }

    private String changeStr(String str) {
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '#') {
                if (builder.length() == 0) {
                    continue;
                } else {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
