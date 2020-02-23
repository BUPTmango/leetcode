package middle_level;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author Wang Guolong
 * @create 2019-04-25 2:00 PM
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        //如果数组长度小于3，返回一个空集合
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        //对数组nums进行排序
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        //让i从数组下标为0开始跑
        for (int i = 0; i < nums.length; i++) {
            //j从i的后一个数开始
            int j = i + 1;
            //k从数组最后一个数（最大的数）往前跑
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    set.add(list);
                    //当有重复的数字出现时，j往前跑，防止结果有重复
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}