package simple_level;

/**
 * 557
 * ��ת�ַ����еĵ��� III
 * ����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��
 *
 * ʾ��?1:
 *
 * ����: "Let's take LeetCode contest"
 * ���: "s'teL ekat edoCteeL tsetnoc"?
 * ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/24 9:51 ����
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] inputArray = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String str : inputArray) {
            StringBuilder builder = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                builder.append(str.charAt(i));
            }
            result.append(builder);
            result.append(" ");
        }
        return result.toString().substring(0, result.toString().length() - 1);
    }

    public static void main(String[] args) {
        ReverseWords re = new ReverseWords();
        System.out.println(re.reverseWords(null));
    }
}
