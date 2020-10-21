package simple_level;

/**
 * 925. ��������
 * �����������ʹ�ü���������������name��ż�����ڼ����ַ�cʱ���������ܻᱻ���������ַ����ܱ����� 1 �λ��Ρ�
 *
 * �㽫�������������ַ�typed���������Ӧ�Ŀ�����������ѵ����֣�����һЩ�ַ����ܱ�����������ô�ͷ���True��
 *
 * ʾ�� 1��
 *
 * ���룺name = "alex", typed = "aaleex"
 * �����true
 * ���ͣ�'alex' �е� 'a' �� 'e' ��������
 * ʾ�� 2��
 *
 * ���룺name = "saeed", typed = "ssaaedd"
 * �����false
 * ���ͣ�'e' һ����Ҫ���������Σ����� typed ������в���������
 * ʾ�� 3��
 *
 * ���룺name = "leelee", typed = "lleeelee"
 * �����true
 * ʾ�� 4��
 *
 * ���룺name = "laiden", typed = "laiden"
 * �����true
 * ���ͣ����������е��ַ������Ǳ�Ҫ�ġ�
 *
 * ��ʾ��
 *
 * name.length <= 1000
 * typed.length <= 1000
 * name ��typed���ַ�����Сд��ĸ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/21 8:58 ����
 */
public class IsLongPressedName {
    /**
     * ˫ָ��
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
