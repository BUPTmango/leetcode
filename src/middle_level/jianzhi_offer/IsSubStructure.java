package middle_level.jianzhi_offer;

import data_structure.TreeNode;

/**
 * ��ָ Offer 26. �����ӽṹ
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��(Լ��������������һ�������ӽṹ)
 *
 * B��A���ӽṹ�� �� A���г��ֺ�B��ͬ�Ľṹ�ͽڵ�ֵ��
 *
 * ����:
 * �������� A:
 *
 * ? ? ?3
 * ? ? / \
 * ? ?4 ? 5
 * ? / \
 * ?1 ? 2
 * �������� B��
 *
 * ? ?4?
 * ? /
 * ?1
 * ���� true����Ϊ B �� A ��һ������ӵ����ͬ�Ľṹ�ͽڵ�ֵ��
 *
 * ʾ�� 1��
 *
 * ���룺A = [1,2,3], B = [3,1]
 * �����false
 * ʾ�� 2��
 *
 * ���룺A = [3,4,5,1,2], B = [4,1]
 * �����true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/27 1:40 ����
 */
public class IsSubStructure {
    /**
     * ��������� A �е�ÿ���ڵ� n_A������Ӧ���� isSubStructure(A, B)��
     * �ж��� A �� �� n_AΪ���ڵ������ �Ƿ������ B ������Ӧ���� recur(A, B)��
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /*
        �������� �� �� A Ϊ�� �� �� B Ϊ�� ʱ��ֱ�ӷ��� false ��
        ����ֵ�� ���� B ���� A ���ӽṹ��������������������֮һ������û� || ���ӣ�
        �� �ڵ� A Ϊ���ڵ������ ������ B ����Ӧ recur(A, B)��
        �� B �� �� A ������ ���ӽṹ����Ӧ isSubStructure(A.left, B)��
        �� B �� �� A ������ ���ӽṹ����Ӧ isSubStructure(A.right, B)��
         */
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        // ���ڵ� B Ϊ�գ�˵���� B ��ƥ����ɣ�Խ��Ҷ�ӽڵ㣩����˷��� true ��
        if(B == null) {
            return true;
        }
        // ���ڵ� A Ϊ�գ�˵���Ѿ�Խ���� A Ҷ�ӽڵ㣬��ƥ��ʧ�ܣ����� false ��
        // ���ڵ� A �� B ��ֵ��ͬ��˵��ƥ��ʧ�ܣ����� false ��
        if(A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
