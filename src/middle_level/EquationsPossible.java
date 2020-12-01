package middle_level;

/**
 * ���鼯
 * 990. ��ʽ���̵Ŀ�������
 * ����һ���ɱ�ʾ����֮���ϵ���ַ���������ɵ����飬ÿ���ַ������� equations[i] �ĳ���Ϊ 4�����������ֲ�ͬ����ʽ֮һ��"a==b" ��"a!=b"�������a �� b ��Сд��ĸ����һ����ͬ������ʾ����ĸ��������
 *
 * ֻ�е����Խ�������������������Ա��������и����ķ���ʱ�ŷ���true�����򷵻� false��
 *
 * ʾ�� 1��
 *
 * ���룺["a==b","b!=a"]
 * �����false
 * ���ͣ��������ָ����a = 1 �� b = 1����ô���������һ�����̣����޷�����ڶ������̡�û�а취�������ͬʱ�������������̡�
 * ʾ�� 2��
 *
 * ���룺["b==a","a==b"]
 * �����true
 * ���ͣ����ǿ���ָ�� a = 1 �� b = 1 �������������������̡�
 * ʾ�� 3��
 *
 * ���룺["a==b","b==c","a==c"]
 * �����true
 * ʾ�� 4��
 *
 * ���룺["a==b","b!=c","c==a"]
 * �����false
 * ʾ�� 5��
 *
 * ���룺["c==c","b==d","x!=z"]
 * �����true
 * 
 *
 * ��ʾ��
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] ��equations[i][3]��Сд��ĸ
 * equations[i][1] Ҫô��'='��Ҫô��'!'
 * equations[i][2]��'='
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/1 7:54 ����
 */
public class EquationsPossible {
    /**
     * ʹ�ò��鼯
     * �ȴ���==��ʽ��ʹ������ͨ����ȹ�ϵ���Թ��������
     * Ȼ����!=��ʽ����鲻�ȹ�ϵ�Ƿ��ƻ�����ȹ�ϵ����ͨ��
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            // ����Ĭ�� ÿ������ָ���Լ�
            parent[i] = i;
        }
        // �ȿ�==
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        // ֮��!=
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        // ��index1�������ӵ�index2��
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            // ·��ѹ��
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
