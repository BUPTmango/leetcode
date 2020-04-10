package middle_level;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. ��ת�ַ�����ĵ���
 * ����һ���ַ����������ת�ַ����е�ÿ�����ʡ�
 *
 * ʾ�� 1��
 *
 * ����: "the sky is blue"
 * ���:?"blue is sky the"
 * ʾ�� 2��
 *
 * ����: " ?hello world! ?"
 * ���:?"world! hello"
 * ����: �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ʾ�� 3��
 *
 * ����: "a good ? example"
 * ���:?"example good a"
 * ����: ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/10 12:20 ����
 */
public class ReverseWords {
    public String reverseWords(String s) {
        // ��ȥ��ͷ��ĩβ�Ŀհ��ַ�
        s = s.trim();
        // ����ƥ�������Ŀհ��ַ���Ϊ�ָ����ָ�
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
