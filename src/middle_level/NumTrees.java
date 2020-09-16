package middle_level;

/**
 * 96. ��ͬ�Ķ���������
 * ����һ������ n������?1 ...?n?Ϊ�ڵ���ɵĶ����������ж����֣�
 *
 * ʾ��:
 *
 * ����: 3
 * ���: 5
 * ����:
 * ���� n = 3, һ���� 5 �ֲ�ͬ�ṹ�Ķ���������:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/16 4:54 ����
 */
public class NumTrees {
    /**
     * ��̬�滮
     * ����һ���������� 1 \cdots n1?n��Ϊ�˹�����һ�ö��������������ǿ��Ա���ÿ������ ii������������Ϊ�������� 1 \cdots (i-1)1?(i?1) ������Ϊ���������� (i+1) \cdots n(i+1)?n ������Ϊ���������������ǿ��԰���ͬ���ķ�ʽ�ݹ鹹������������������
     *
     * �����������Ĺ����У����ڸ���ֵ��ͬ����������ܱ�֤ÿ�ö�����������Ψһ�ġ�
     *
     * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
