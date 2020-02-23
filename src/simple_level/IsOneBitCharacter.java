package simple_level;

/**
 * 717
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处
 *
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2019/9/9 9:13 下午
 */

public class IsOneBitCharacter {
    /**
     * 明白题目意图，就会发现，题目的意思是要判断最后一个0元素是属于0还是输入10；
     * 遍历数组，给定指针，若当前位为1则指针+2；若当前位为0，则指针+1；
     * 判断最后指针是否与bits.length-1相等，相等则为真，否则为假；其中length=1的情况也包括进去了。
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        if (bits.length == 1) {
            return true;
        }
        int i = 0;
        while (i < bits.length-1){
            if (bits[i] == 1){
                i += 2;
            }else{
                i++;
            }
        }
        return i == bits.length-1;
    }
}
