package simple_level.coder_gold;

/**
 * 面试题 16.17. 连续数列
 * 给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/25 8:55 上午
 */
public class MaxSubArray {
    /**
     * 大老板sum，和他的小喽啰b，以收割土地（数值）为生。
     * b拿着sum的资产出门，遇到数值以后，b先看自己的资产，如果是正的，那么直接掠夺别人相加；如果是负的，就把自己的扔掉，让别人的数直接覆盖，因为如果相加的话，自己的负资产一定会拖后腿。
     * 然后带着自己的新资产情况回去和sum比较，来对比自己收割情况，情况好的话更新大老板数据，不好的话出去掠夺，以保持sum的总和是最大的。
     * 并且，b累计的和一直是连续计算的。
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
