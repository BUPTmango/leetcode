package weekly_contest.week_215;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 5603. ȷ�������ַ����Ƿ�ӽ�
 * �������ʹ�����²�����һ���ַ����õ���һ���ַ���������Ϊ�����ַ��� �ӽ� ��
 *
 * ���� 1�������������� ���� �ַ���
 * ���磬abcde -> aecdb
 * ���� 2����һ�� ���� �ַ���ÿ�γ���ת��Ϊ��һ�� ���� �ַ���������һ���ַ�ִ����ͬ�Ĳ�����
 * ���磬aacabb -> bbcbaa������ a ת��Ϊ b �������е� b ת��Ϊ a ��
 * ����Ը�����Ҫ������һ���ַ������ʹ�������ֲ�����
 *
 * ���������ַ�����word1 �� word2 ����� word1 �� word2 �ӽ� ���ͷ��� true �����򣬷��� false ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺word1 = "abc", word2 = "bca"
 * �����true
 * ���ͣ�2 �β����� word1 ��� word2 ��
 * ִ�в��� 1��"abc" -> "acb"
 * ִ�в��� 1��"acb" -> "bca"
 * ʾ�� 2��
 *
 * ���룺word1 = "a", word2 = "aa"
 * �����false
 * ���ͣ�����ִ�ж��ٴβ��������޷��� word1 �õ� word2 ����֮��Ȼ��
 * ʾ�� 3��
 *
 * ���룺word1 = "cabbba", word2 = "abbccc"
 * �����true
 * ���ͣ�3 �β����� word1 ��� word2 ��
 * ִ�в��� 1��"cabbba" -> "caabbb"
 * ִ�в��� 2��"caabbb" -> "baaccc"
 * ִ�в��� 2��"baaccc" -> "abbccc"
 * ʾ�� 4��
 *
 * ���룺word1 = "cabbba", word2 = "aabbss"
 * �����false
 * ���ͣ�����ִ�ж��ٴβ��������޷��� word1 �õ� word2 ����֮��Ȼ��
 *
 * ��ʾ��
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 �� word2 ������СдӢ����ĸ
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/15 10:53 ����
 */
public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        // ͳ�������ַ���������
        Map<Character, Integer> map1 = getMap(word1);
        Map<Character, Integer> map2 = getMap(word2);
        int[] arr1 = countString(map1);
        int[] arr2 = countString(map2);
        char[] keySet1 = getKeySet(map1);
        char[] keySet2 = getKeySet(map2);

        return Arrays.equals(arr1, arr2) && Arrays.equals(keySet1, keySet2);
    }

    private Map<Character, Integer> getMap(String str) {
        char[] chars = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    private int[] countString(Map<Character, Integer> map) {
        int[] res = new int[map.size()];
        int index = 0;
        for (char key : map.keySet()) {
            res[index++] = map.get(key);
        }
        Arrays.sort(res);
        return res;
    }

    private char[] getKeySet(Map<Character, Integer> map) {
        Set<Character> characters = map.keySet();
        char[] chars = new char[characters.size()];
        int index = 0;
        for (char c : characters) {
            chars[index++] = c;
        }
        Arrays.sort(chars);
        return chars;
    }

    public static void main(String[] args) {
        CloseStrings closeStrings = new CloseStrings();
        String word1 = "cabbba";
        String word2 = "aabbss";
        System.out.println(closeStrings.closeStrings(word1, word2));
    }
}
