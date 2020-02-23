package beforeBegining_2018;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * @author mango
 * @create 2019-02-27 10:38 AM
 */
public class FindMajorityElement {
    /**
     * 自己写的复杂的双重for循环
     * 记录每个数字出现的次数 大于n/2时返回
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        //出现次数要大于standard
        int standard = nums.length / 2;
        int count = 0;
        int target = -1;
        for (int i = 0; i < nums.length; i++) {
            target = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == target) {
                    count++;
                }
            }
            if (count >= target) {
                break;
            }
            count = 0;
        }
        return target;
    }

    /**
     * 摩尔投票法
     * 设置一个计数器，选定第一个值作为起始值
     * 然后后面的值如果是这个值那么计数加一
     * 如果不等，那么计数减一
     * 当计数器的值为零时，选取当前值作为新值继续计数
     * 因为众数肯定大于1/2所以最后计数器不为零的数肯定是众数
     * @param nums
     * @return
     */
    public static int majorityElement_new(int[] nums) {
        int count = 0;
        int target = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    target = nums[i];
                    count++;
                }
            }
        }
        return target;
    }

    public static void main(String[] args) {
        int[] data1 = {3,2,3};
        int[] data2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement_new(data1));
        System.out.println(majorityElement_new(data2));
    }
}