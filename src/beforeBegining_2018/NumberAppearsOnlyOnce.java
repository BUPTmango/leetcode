package beforeBegining_2018;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *  你的算法应该具有线性时间复杂度
 * @author mango
 * @create 2019-02-27 10:31 AM
 */
public class NumberAppearsOnlyOnce {
    /**
     * 解法：异或
     * 异或运算的特点：两个相同的数字异或，结果为0。
     * 因为数组中除了一个元素只出现一次之外，其它的元素都出现两次
     * 如果把所有的数都异或，相同的数字异或为0，最后只剩下出现一次的数字，它和0异或，结果就是它本身
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num = num ^ i;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] data1 = {2,2,1};
        int[] data2 = {4,1,2,1,2};
        System.out.println(singleNumber(data1));
        System.out.println(singleNumber(data2));
    }
}