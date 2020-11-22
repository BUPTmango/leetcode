package weekly_contest.week_216;

/**
 * 5605. ��������ַ��������Ƿ����
 * ���������ַ������� word1 �� word2 ��������������ʾ���ַ�����ͬ������ true �����򣬷��� false ��
 *
 * �����ʾ���ַ��� ���������е�����Ԫ�� ��˳�� �����γɵ��ַ�����
 *
 * ʾ�� 1��
 *
 * ���룺word1 = ["ab", "c"], word2 = ["a", "bc"]
 * �����true
 * ���ͣ�
 * word1 ��ʾ���ַ���Ϊ "ab" + "c" -> "abc"
 * word2 ��ʾ���ַ���Ϊ "a" + "bc" -> "abc"
 * �����ַ�����ͬ������ true
 * ʾ�� 2��
 *
 * ���룺word1 = ["a", "cb"], word2 = ["ab", "c"]
 * �����false
 * ʾ�� 3��
 *
 * ���룺word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * �����true
 *
 *
 * ��ʾ��
 *
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] �� word2[i] ��Сд��ĸ���
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/22 10:32 ����
 */
public class ArrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return arrayToString(word1).equals(arrayToString(word2));
    }

    private String arrayToString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
