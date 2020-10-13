package middle_level;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 二维平面
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/13 10:50 上午
 */
public class Exist {
    /**
     * DFS
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 越界或者当前矩阵元素和目标不同
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        // 字符串已经全部匹配
        if(k == word.length - 1) {
            return true;
        }
        // 记录当前矩阵元素
        char tmp = board[i][j];
        // 修改为/ 表示已经访问过
        board[i][j] = '/';
        // 向上下左右四个方向开启递归
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        // 还原矩阵元素
        board[i][j] = tmp;
        return res;
    }
}
