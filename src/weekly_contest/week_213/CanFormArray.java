package weekly_contest.week_213;

import java.util.Arrays;

/**
 * 同 单词拆分
 * 5554. 能否连接形成数组
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 *
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [85], pieces = [[85]]
 * 输出：true
 * 示例 2：
 *
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 3：
 *
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 4：
 *
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 * 示例 5：
 *
 * 输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/1 10:31 上午
 */
public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // dp[i] 表示字符串 arr 前 i 个元素组成的数组 s[0..i-1] 是否能被空格拆分成若干个pieces中出现的数组
        boolean[] dp = new boolean[arr.length + 1];
        dp[0] = true;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < i; j++) {
                // j之前的存在 并且最后一个也存在 更新i为存在
                if (dp[j] && judgeInPieces(Arrays.copyOfRange(arr, j, i), pieces)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[arr.length];
    }

    /**
     * 判断target是否在pieces中
     * @param target
     * @param pieces
     * @return
     */
    private boolean judgeInPieces(int[] target, int[][] pieces) {
        String targetStr = Arrays.toString(target);
        for (int[] piece : pieces) {
            String pieceStr = Arrays.toString(piece);
            if (pieceStr.equals(targetStr)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanFormArray can = new CanFormArray();
        int[] arr = new int[]{49,18,16};
        int[][] pieces = new int[][]{{16,18,49}};
        System.out.println(can.canFormArray(arr, pieces));
    }
}
