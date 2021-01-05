package middle_level.jianzhi_offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * ��ָ Offer 38. �ַ���������
 * ����һ���ַ�������ӡ�����ַ������ַ����������С�
 * <p>
 * �����������˳�򷵻�����ַ������飬�����治�����ظ�Ԫ�ء�
 * <p>
 * ʾ��:
 * <p>
 * ���룺s = "abc"
 * �����["abc","acb","bac","bca","cab","cba"]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/23 5:59 ����
 */
public class Permutation {
    List<String> res = new LinkedList<>();
    char[] c;

    /**
     * ���з��������� ����һ������Ϊ nn ���ַ����������ַ������ظ����������й��� n \times (n-1) \times (n-2) �� \times 2 \times 1n��(n?1)��(n?2)����2��1 �ַ�����
     * <p>
     * ���з��������ɷ����� �����ַ������е��ص㣬����������������������з�������ͨ���ַ��������ȹ̶��� 1 λ�ַ��� nn ����������ٹ̶��� 2 λ�ַ��� n-1 ���������... �����̶��� n λ�ַ��� 1 ���������
     * <p>
     * �ظ��������֦�� ���ַ��������ظ��ַ�ʱ�����з�����Ҳ�����ظ�������Ϊ�ų��ظ����������ڹ̶�ĳλ�ַ�ʱ����֤ ��ÿ���ַ�ֻ�ڴ�λ�̶�һ�Ρ� ���������ظ��ַ�ʱ��������ֱ���������� DFS �Ƕȿ����˲�����Ϊ ����֦�� ��
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    /**
     * x��ʾ�̶��ַ���index
     *
     * @param x
     */
    void dfs(int x) {
        if (x == c.length - 1) {
            // ������з���
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            // �ظ�����˼�֦
            if (set.contains(c[i])) {
                continue;
            }
            // �� c[i] ���� Set ���Ա�֮�������ظ��ַ�ʱ��֦
            set.add(c[i]);
            // �̶��ַ��� ���ַ� c[i] �� c[x] ���������̶� c[i] Ϊ��ǰλ�ַ�
            swap(i, x);
            // �����²�ݹ飺 ���� dfs(x + 1) ������ʼ�̶��� x + 1 ���ַ�
            dfs(x + 1);
            // ��ԭ������ ���ַ� c[i] �� c[x] ��������ԭ֮ǰ�Ľ�����
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
