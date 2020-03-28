package simple_level.coder_gold;

/**
 * ������ 01.09. �ַ�����ת
 * �ַ�����ת�����������ַ���s1��s2�����д������s2�Ƿ�Ϊs1��ת���ɣ����磬waterbottle��erbottlewat��ת����ַ�������
 *
 * ʾ��1:
 *
 *  ���룺s1 = "waterbottle", s2 = "erbottlewat"
 *  �����True
 * ʾ��2:
 *
 *  ���룺s1 = "aa", "aba"
 *  �����False
 * ��ʾ��
 *
 * �ַ���������[0, 100000]��Χ�ڡ�
 * ˵��:
 *
 * ����ֻ����һ�μ���Ӵ��ķ�����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/27 12:09 ����
 */
public class IsFlipedString {
    /**
     * ��s1�������� ��s1��Ѱ��s2
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length()) {
            return false;
        }
        if(s1.equals(s2)) {
            return true;
        }
        s1+=s1;
        return s1.contains(s2);
    }
}
