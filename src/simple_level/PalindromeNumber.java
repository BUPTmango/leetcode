package simple_level;

/**No.9
 * 判断一个整数是否是回文数
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 用字符串方式过于简单 不能转换成字符串
 * @author mango
 * @create 2019-03-05 2:14 PM
 */
public class PalindromeNumber {
    /**
     * 只反转数字的一半 毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
     *
     * 例如，输入 1221，我们可以将数字“1221”的后半部分从“21”反转为“12”，
     * 并将其与前半部分“12”进行比较，因为二者相同，我们得知数字 1221 是回文。
     *
     * 我们将原始数字除以 10，然后给反转后的数字乘上 10，
     * 所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        //只有大于等于A零才可能是回文数
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        //大于零的情况
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}