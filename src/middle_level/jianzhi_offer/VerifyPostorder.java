package middle_level.jianzhi_offer;

/**
 * ��ָ Offer 33. �����������ĺ����������
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�����������������򷵻�?true�����򷵻�?false���������������������������ֶ�������ͬ��
 *
 * �ο�������Ŷ�����������
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * ʾ�� 1��
 *
 * ����: [1,6,3,2,5]
 * ���: false
 * ʾ�� 2��
 *
 * ����: [1,3,2,6,5]
 * ���: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/24 5:06 ����
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) {
            // ˵�����Ľڵ�С�ڵ���1 ֱ�ӷ���true
            return true;
        }
        int p = i;
        // �������������� ������������� [i, j] ����Ԫ�أ�Ѱ�� ��һ�����ڸ��ڵ� �Ľڵ㣬������Ϊ m ��
        // ��ʱ���ɻ��ֳ����������� [i,m-1] ������������ [m, j - 1] �����ڵ����� j ��
        while(postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        // ���������б�����ڸ�
        while(postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
