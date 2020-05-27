package simple_level;

/**
 * 680. ��֤�����ַ��� ��
 * ����һ���ǿ��ַ���?s�����ɾ��һ���ַ����ж��Ƿ��ܳ�Ϊ�����ַ�����
 *
 * ʾ�� 1:
 *
 * ����: "aba"
 * ���: True
 * ʾ�� 2:
 *
 * ����: "abca"
 * ���: True
 * ����: �����ɾ��c�ַ���
 * ע��:
 *
 * �ַ���ֻ������ a-z ��Сд��ĸ���ַ�������󳤶���50000��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/27 11:17 ����
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length()-1, 1);
    }

    /**
     *
     * @param s �����ַ���
     * @param left ��ָ��
     * @param right ��ָ��
     * @param chance ɾ���ڵ�Ļ������
     */
    private boolean validPalindrome(String s, int left, int right, int chance) {
        if (left > right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return validPalindrome(s, left + 1, right - 1, chance);
        } else {
            if (chance == 0) {
                return false;
            }
            return validPalindrome(s, left, right - 1, chance-1) || validPalindrome(s, left + 1, right, chance-1);
        }
    }
}
