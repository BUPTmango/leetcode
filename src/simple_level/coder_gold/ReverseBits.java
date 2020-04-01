package simple_level.coder_gold;

/**
 * 面试题 05.03. 翻转数位
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * 示例 1：
 *
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 *
 * 输入: num = 7(01112)
 * 输出: 4
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/1 9:32 上午
 */
public class ReverseBits {
    /**
     * 不明白
     * @param num
     * @return
     */
    public int reverseBits(int num) {
        int curNum = 0, preNum = 0, maxNum = 0;
        for(int i = 0; i < 32; ++i){
            if((num & 1) == 1){
                curNum++;
            }else{
                curNum -= preNum;
                curNum++;
                preNum = curNum;
            }
            maxNum = Math.max(maxNum, curNum);
            num >>= 1;
        }
        return maxNum;
    }

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(111));
    }
}
