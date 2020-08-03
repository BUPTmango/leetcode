
package middle_level.jianzhi_offer;

import java.util.*;

/**
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/31 5:50 下午
 */
public class GenerateWordBoard {

    private static char[][] board;

    public static void main(String[] args) {
        generateCharBoard("vocabulary", 5, 5);
    }

    /**
     * 生成棋盘
     *
     * @param word 单词
     * @param m    长度
     * @param n    宽度
     */
    private static void generateCharBoard(String word, int m, int n) {
        // 单词为空 直接返回
        if (word.isEmpty()) {
            return;
        }
        // 单词长度大于棋盘 铺不下 直接返回
        if (word.length() > m * n) {
            return;
        }

        // 初始化
        board = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '*';
            }
        }

        char[] wordChar = word.toCharArray();
        // 随机选取一个位置开始
        Random random = new Random();
        int randomX = random.nextInt(m);
        int randomY = random.nextInt(n);
        // 开始dfs铺单词 从index 0 开始
        generateDfs(board, wordChar, randomX, randomY, 0);

        // 查看结果
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 返回true则为找到一条路 返回false为死路
     */
    private static boolean generateDfs(char[][] board, char[] wordChar, int i, int j, int index) {
        // 碰到边 或者碰到已经走过的位置 不能走了 死路
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == '/') {
            return false;
        }

        // 摆放一个字母
        board[i][j] = wordChar[index];

        //如果已经达到单词长度则直接返回 找到一条路
        if (index == wordChar.length - 1) {
            return true;
        }

        // 记录当前矩阵元素
        char tmp = board[i][j];
        // 修改为/ 表示已经访问过
        board[i][j] = '/';

        // 向上下左右四个方向开启递归
        // 查看能走几个方向 随机选择一个
        List<int[]> directions = Arrays.asList(new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1});
        Collections.shuffle(directions);
        boolean res = false;
        for (int k = 0; k < directions.size(); k++) {
            int di = i + directions.get(k)[0], dj = j + directions.get(k)[1];
            boolean partialRes = generateDfs(board, wordChar, di, dj, index + 1);
            if (k == 0) {
                res = partialRes;
            } else {
                res = res || partialRes;
            }
            if (res) {
                // 还原矩阵元素
                board[i][j] = tmp;
                return true;
            }
        }
        // 还原矩阵元素
        board[i][j] = tmp;
        return false;
    }
}
