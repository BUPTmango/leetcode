package simple_level.coder_gold;

import data_structure.TreeNode;

import java.util.Arrays;

/**
 * ������ 04.02. ��С�߶���
 * ����һ�������������飬Ԫ�ظ�����ͬ�Ұ��������У���дһ���㷨������һ�ø߶���С�Ķ�����������
 *
 * ʾ��:
 * ������������: [-10,-3,0,5,9],
 *
 * һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/16 9:46 ����
 */
public class SortedArrayToBST {
    /**
     * sortedArrayToBST�����Ǵ���һ�����飬
     * Ȼ��ȡ�����м�����������ڵ�root��Ȼ�����м�Ϊ�ֽ磬
     * ����ߵ���������ұߵ�������ֱ���sortedArrayToBST���еݹ飬
     * ���ص������������������ĸ��ڵ㣬�������root.left��root.right���ɣ�
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) {
            return null;
        }
        TreeNode n = new TreeNode(nums[nums.length/2]);
        n.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        n.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return n;
    }
}
