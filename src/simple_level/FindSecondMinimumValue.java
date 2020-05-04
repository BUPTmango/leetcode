package simple_level;

import data_structure.TreeNode;

/**
 * 671. �������еڶ�С�Ľڵ�
 * ����һ���ǿ�����Ķ�������ÿ���ڵ㶼������������ÿ���ڵ���ӽڵ�����ֻ��Ϊ?2?��?0�����һ���ڵ��������ӽڵ�Ļ�����ô����ڵ��ֵ�����������ӽڵ��ֵ��?
 *
 * ����������һ��������������Ҫ������нڵ��еĵڶ�С��ֵ������ڶ�С��ֵ�����ڵĻ������ -1 ��
 *
 * ʾ�� 1:
 *
 * ����:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * ���: 5
 * ˵��: ��С��ֵ�� 2 ���ڶ�С��ֵ�� 5 ��
 * ʾ�� 2:
 *
 * ����:
 *     2
 *    / \
 *   2   2
 *
 * ���: -1
 * ˵��: ��С��ֵ�� 2, ���ǲ����ڵڶ�С��ֵ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/4 10:35 ����
 */
public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return -1;//û����С�ڵ�

        //�ҳ���ѡ����Ĭ�Ͼ����ӽڵ�ֵ������ӽڵ�ֵ��rootֵ��ͬ���ݹ飬��������Ѱ�Һ�ѡ��
        int left = root.left.val;
        int right = root.right.val;
        if(root.left.val == root.val){
            left = findSecondMinimumValue(root.left);
        }
        if(root.right.val == root.val){
            right = findSecondMinimumValue(root.right);
        }

        //������Һ�ѡ�������������ؽ�Сֵ�Ϳ�
        if(left != -1 && right != -1){
            return Math.min(left, right);
        }
        //�����ѡ����-1��˵������������û�пɹ���ѡ����
        if(left != -1){
            //�������������𰸾�����ߵĺ�ѡ��
            return left;
        }else{
            //���������������ش�
            //����������Ҳû�к�ѡ��������-1����right
            return right;
        }
    }
}
