package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. ���ʹ���
 * ����һ�ֹ��� pattern?��һ���ַ���?str?���ж� str �Ƿ���ѭ��ͬ�Ĺ��ɡ�
 * <p>
 * �����?��ѭ?ָ��ȫƥ�䣬���磬?pattern?���ÿ����ĸ���ַ���?str?�е�ÿ���ǿյ���֮�������˫�����ӵĶ�Ӧ���ɡ�
 * <p>
 * ʾ��1:
 * <p>
 * ����: pattern = "abba", str = "dog cat cat dog"
 * ���: true
 * ʾ�� 2:
 * <p>
 * ����:pattern = "abba", str = "dog cat cat fish"
 * ���: false
 * ʾ�� 3:
 * <p>
 * ����: pattern = "aaaa", str = "dog cat cat dog"
 * ���: false
 * ʾ��?4:
 * <p>
 * ����: pattern = "abba", str = "dog dog dog dog"
 * ���: false
 * ˵��:
 * ����Լ���?pattern?ֻ����Сд��ĸ��?str?�������ɵ����ո�ָ���Сд��ĸ��? ??
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/24 9:13 ����
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map index = new HashMap();
        // ͨ��put�ķ���ֵ�ж� ��������ͬʱӳ�䵽һ��������������
        for (Integer i = 0; i < words.length; ++i) {
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}
