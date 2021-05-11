package middle_level;

/**
 * 1734. 解码异或后的排列
 *
 * 给你一个整数数组perm，它是前n个正整数的排列，且n是个 奇数。
 * 它被加密成另一个长度为 n - 1的整数数组encoded，满足encoded[i] = perm[i] XOR perm[i + 1]。比方说，如果perm = [1,3,2]，那么encoded = [2,1]。
 * 给你encoded数组，请你返回原始数组perm。题目保证答案存在且唯一。
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/11 09:05
 */
public class Decode {
    public int[] decode(int[] encoded) {
        // 求出first元素就可以计算了
        // 先算出perm[A,B,C,D,E]的异或值ABCDE
        int[] perm = new int[encoded.length + 1];
        int total = 0;
        for (int i = 1; i <= perm.length; i++) {
            total ^= i;
        }
        // 算奇数位置的 统计BCDE
        int odd = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            odd ^= encoded[i];
        }
        // 计算出第一个位置的元素
        perm[0] = odd ^ total;
        for (int i = 0; i < perm.length - 1; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}
