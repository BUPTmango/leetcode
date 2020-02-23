package simple_level;

/**
 * 198
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 *
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬�������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
 *
 * ʾ�� 1:
 *
 * ����: [1,2,3,1]
 * ���: 4
 * ����: ͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��
 * ?    ͵�Ե�����߽�� = 1 + 3 = 4 ��
 * ʾ�� 2:
 *
 * ����: [2,7,9,3,1]
 * ���: 12
 * ����: ͵�� 1 �ŷ��� (��� = 2), ͵�� 3 �ŷ��� (��� = 9)������͵�� 5 �ŷ��� (��� = 1)��
 * ?    ͵�Ե�����߽�� = 2 + 9 + 1 = 12 ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/16 12:16 ����
 */
public class Rob {

    public static int[] result;
    public int solve(int[] nums,int index){
        if(index < 0){
            return 0;
        }
        if(result[index] >= 0){
            return result[index];
        }
        result[index]=Math.max(solve(nums,index-1),solve(nums,index-2)+nums[index]);
        return result[index];
    }

    /**
     * https://www.jianshu.com/p/77f1e8157277
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=-1;
        }
        return solve(nums,nums.length-1);
    }
}
