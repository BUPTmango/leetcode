package simple_level;

/**
 * 125. ��֤���Ĵ�
 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
 * <p>
 * ˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: "A man, a plan, a canal: Panama"
 * ���: true
 * ʾ�� 2:
 * <p>
 * ����: "race a car"
 * ���: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/28 10:41 ����
 */
public class IsPalindrome_string {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(c);
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindrome_twoPointer(String s) {

        if (s.length() == 0)
            return true;

        String low = s.toLowerCase();

        int i = 0;
        int j = low.length() - 1;

        while (i < j)
        {
            if (!Character.isLetterOrDigit(low.charAt(i)))
            {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(low.charAt(j)))
            {
                j--;
                continue;
            }
            if (low.charAt(i) != low.charAt(j))
                return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }
}
