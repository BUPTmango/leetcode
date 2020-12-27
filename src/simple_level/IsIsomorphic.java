package simple_level;

/**
 * 205. ͬ���ַ���
 * ���������ַ���?s?��?t���ж������Ƿ���ͬ���ġ�
 *
 * ���?s?�е��ַ����Ա��滻�õ�?t?����ô�������ַ�����ͬ���ġ�
 *
 * ���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ�����
 *
 * ʾ�� 1:
 *
 * ����: s = "egg", t = "add"
 * ���: true
 * ʾ�� 2:
 *
 * ����: s = "foo", t = "bar"
 * ���: false
 * ʾ�� 3:
 *
 * ����: s = "paper", t = "title"
 * ���: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/14 8:59 ����
 */
public class IsIsomorphic {
    /**
     * ������һ�������������������������ĸ���ֵ�˳�򣬰������ַ�����ӳ�䵽��һ�������С�
     * ����һ�����ֵ���ĸӳ��� 1���ڶ������ֵ���ĸӳ��� 2
     *
     * ���� egg
     * e -> 1
     * g -> 2
     * Ҳ���ǽ� egg �� e ���� 1, g ���� 2, �ͱ���� 122
     *
     * ���� add
     * a -> 1
     * d -> 2
     * Ҳ���ǽ� add �� a ���� 1, d ���� 2, �ͱ���� 122
     *
     * egg -> 122, add -> 122
     * ������� 122�����������ַ���ͬ����
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //��ǰ��ӳ��ֵ�Ƿ���ͬ
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else {
                //�Ƿ��Ѿ��޸Ĺ����޸Ĺ��Ͳ���Ҫ�ٴ���
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}
