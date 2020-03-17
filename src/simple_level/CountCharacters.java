package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. ƴд����
 * ����һ�ݡ��ʻ�����ַ������飩?words?��һ�š���ĸ�����ַ�����?chars��
 *
 * �����������?chars?�еġ���ĸ�����ַ���ƴд�� words?�е�ĳ�������ʡ����ַ���������ô���Ǿ���Ϊ��������������ʡ�
 *
 * ע�⣺ÿ��ƴдʱ��chars �е�ÿ����ĸ��ֻ����һ�Ρ�
 *
 * ���شʻ��?words?�������յ����е��ʵ� ����֮�͡�
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺words = ["cat","bt","hat","tree"], chars = "atach"
 * �����6
 * ���ͣ�
 * �����γ��ַ��� "cat" �� "hat"�����Դ��� 3 + 3 = 6��
 * ʾ�� 2��
 *
 * ���룺words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * �����10
 * ���ͣ�
 * �����γ��ַ��� "hello" �� "world"�����Դ��� 5 + 5 = 10��
 * ?
 *
 * ��ʾ��
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length?<= 100
 * �����ַ����ж�������СдӢ����ĸ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/17 11:02 ����
 */
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> source = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (source.containsKey(c)) {
                source.put(c, source.get(c) + 1);
            } else {
                source.put(c, 1);
            }
        }
        for (char c : source.keySet()) {
            System.out.println(c + " : " + source.get(c));
        }
        System.out.println();
        System.out.println();

        for (String s : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            for (char c : map.keySet()) {
                System.out.println(c + " : " + map.get(c));
            }
            System.out.println();
            boolean flag = true;
            for (char target : map.keySet()) {
                if (!source.containsKey(target)) {
                    flag = false;
                    break;
                }
                if (source.get(target) < map.get(target)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += s.length();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountCharacters c = new CountCharacters();
        System.out.println(c.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}
