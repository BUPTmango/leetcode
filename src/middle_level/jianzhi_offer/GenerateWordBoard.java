
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
        GenerateWordBoard g = new GenerateWordBoard();
        g.generateCharBoard("vocabulary", 5, 5);
    }

    private void generateCharBoard(String word, int m, int n) {
        // 单词为空 直接返回
        if (word.isEmpty()) {
            return;
        }
        // 单词长度大于棋盘 铺不下 直接返回
        if (word.length() > m * n) {
            return;
        }
        // 初始化棋盘 全为*
        initBoard(m, n);

        char[] wordChar = word.toCharArray();
        // 随机选取一个位置开始
        Random random = new Random();
        int randomX = random.nextInt(m);
        int randomY = random.nextInt(n);
        // 开始从随机位置dfs铺单词 从index 0 开始
        boolean result = generateDfs(board, wordChar, randomX, randomY, 0);
        // 如果没有找到路线 那么从四个角开始 必能找到一条路
        if (!result) {
            List<int[]> starts = Arrays.asList(new int[]{0, 0}, new int[]{0, n - 1}, new int[]{m - 1, 0},
                    new int[]{m - 1, n - 1});
            // 随机四个角的一个
            Collections.shuffle(starts);
            // 初始化棋盘
            initBoard(m, n);
            // dfs铺单词
            generateDfs(board, wordChar, starts.get(0)[0], starts.get(0)[1], 0);
        }
        // 查看结果
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private void initBoard(int m, int n) {
        // 初始化
        board = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '*';
            }
        }
    }

    /**
     * 返回true则为找到一条路 返回false为死路
     */
    private boolean generateDfs(char[][] board, char[] wordChar, int i, int j, int index) {
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
            // 如果res为true 说明找到一条路 就不再遍历了 还原后返回true
            if (res) {
                // 还原矩阵元素
                board[i][j] = tmp;
                return true;
            }
        }
        // 还原矩阵元素
        board[i][j] = '*';
        return false;
    }
}
