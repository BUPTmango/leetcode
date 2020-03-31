package simple_level.coder_gold;

/**
 * ������ 16.17. ��������
 * ����һ���������飨�������и��������ҳ��ܺ������������У��������ܺ͡�
 *
 * ʾ����
 *
 * ���룺 [-2,1,-3,4,-1,2,1,-5,4]
 * ����� 6
 * ���ͣ� ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/25 8:55 ����
 */
public class MaxSubArray {
    /**
     * ���ϰ�sum��������Сආ�b�����ո����أ���ֵ��Ϊ����
     * b����sum���ʲ����ţ�������ֵ�Ժ�b�ȿ��Լ����ʲ�����������ģ���ôֱ���Ӷ������ӣ�����Ǹ��ģ��Ͱ��Լ����ӵ����ñ��˵���ֱ�Ӹ��ǣ���Ϊ�����ӵĻ����Լ��ĸ��ʲ�һ�����Ϻ��ȡ�
     * Ȼ������Լ������ʲ������ȥ��sum�Ƚϣ����Ա��Լ��ո����������õĻ����´��ϰ����ݣ����õĻ���ȥ�Ӷᣬ�Ա���sum���ܺ������ġ�
     * ���ң�b�ۼƵĺ�һֱ����������ġ�
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int b = nums[0];
        int sum = b;
        for(int i = 1; i<nums.length;i++){
            if(b<0){
                b=nums[i];
            }else{
                b+=nums[i];
            }
            if(b>sum){
                sum=b;
            }
        }
        return sum;
    }
}