package simple_level.jianzhi_offer;

import java.util.Arrays;

/**
 * 面试题61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例?1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例?2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 *
 * 数组长度为 5?
 *
 * 数组的数取值为 [0, 13] .
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/14 2:31 下午
 */
public class IsStraight {
    /**
     * 方法一 不使用排序
     *
     * 如果我们能够知道 5 张扑克牌中的最大值 maxValue 和最小值 minValue ，
     * 那我们就知道，要使它为顺子需要 maxValue - minValue + 1 张牌。
     * 在查找 maxValue 和 minValue 过程中，跳过大小王 0 。
     * 如果 maxValue - minValue + 1 > 5，
     * 说明题目给的 5 张牌不足以构成顺子，返回 false .
     * 即使里面有大小王，也不够用来填补使它构成顺子。
     * 如果 maxValue - minValue + 1 <= 5，说明 5 张牌足以构成顺子，返回 true。
     * 里面的大小王填补在合适位置即可。
     * 同时，我们再定义一个标志数组判断是否有重复数字，发现重复数字直接返回 false 即可。
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        boolean[] flag = new boolean[15];
        int minValue = 14, maxValue = 0;
        for (int item : nums) {
            if (item == 0) {
                continue;
            }
            // 有除了0以外的相同元素 肯定不能组成顺子
            if (flag[item]) {
                return false;
            }
            flag[item] = true;
            minValue = Math.min(minValue, item);
            maxValue = Math.max(maxValue, item);
        }
        return maxValue - minValue + 1 <= 5;
    }

    /**
     * 方法二 使用排序
     *
     * 排序之后扑克牌就有序了，我们就可以直接判断相邻两张牌之间需要多少个大王或小王来填补。
     * 如果需要填补大小王的数量，大于已有大小王的数量，则返回 falsefalse .
     * 相反，如果需要填补大小王的数量，小于或等于已有大小王的数量，则返回 truetrue .
     *
     * @param nums
     * @return
     */
    public boolean isStraight_sort(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < 4; i ++) {
            if (nums[i] == 0) {
                zero++;
                continue;
            }
            if (nums[i] == nums[i+1]) {
                return false;
            }
            zero -= nums[i+1]-nums[i] - 1;
        }
        return zero >= 0;
    }

    public static void main(String[] args) {
        IsStraight is = new IsStraight();
        System.out.println(is.isStraight(new int[]{0, 0, 1, 2, 6}));
    }
}
