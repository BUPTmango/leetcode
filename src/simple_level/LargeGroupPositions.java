package simple_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. �ϴ�����λ��
 * ��һ����Сд��ĸ���ɵ��ַ��� s �У�������һЩ��������ͬ�ַ������ɵķ��顣
 *
 * ���磬���ַ��� s = "abbxxxxzyy"�У��ͺ��� "a", "bb", "xxxx", "z" �� "yy" ������һЩ���顣
 *
 * ������������� [start, end] ��ʾ������ start �� end �ֱ��ʾ�÷������ʼ����ֹλ�õ��±ꡣ�����е� "xxxx" �����������ʾΪ [3,6] ��
 *
 * ���ǳ����а������ڻ�������������ַ��ķ���Ϊ �ϴ���� ��
 *
 * �ҵ�ÿһ�� �ϴ���� �����䣬����ʼλ���±����˳������󣬷��ؽ����
 *
 * ʾ��1��
 *
 * ���룺s = "abbxxxxzzy"
 * �����[[3,6]]
 * ���ͣ�"xxxx" ��һ����ʼ�� 3 ����ֹ�� 6 �Ľϴ���顣
 * ʾ�� 2��
 *
 * ���룺s = "abc"
 * �����[]
 * ���ͣ�"a","b" �� "c" �����Ƿ���Ҫ��Ľϴ���顣
 * ʾ�� 3��
 *
 * ���룺s = "abcdddeeeeaabbbcd"
 * �����[[3,5],[6,9],[12,14]]
 * ���ͣ��ϴ����Ϊ "ddd", "eeee" �� "bbb"
 * ʾ�� 4��
 *
 * ���룺s = "aba"
 * �����[]
 * 
 * ��ʾ��
 *
 * 1 <= s.length <= 1000
 * s ����СдӢ����ĸ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/5 3:31 ����
 */
public class LargeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        int index = 0;
        int len = chars.length;
        while (index < len) {
            int begin = index, end = index;
            char target = chars[begin];
            while (end < len && chars[end] == target) {
                end++;
            }
            if (end - begin >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(begin);
                list.add(end - 1);
                res.add(list);
            }
            // ��������
            index = end;
        }
        return res;
    }
}
