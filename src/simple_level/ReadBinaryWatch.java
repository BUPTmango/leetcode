package simple_level;

import java.util.LinkedList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 组合问题
 * 401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * <p>
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * <p>
 * 例如，上面的二进制手表读取 “3:25”。
 * <p>
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/13 9:30 上午
 */
public class ReadBinaryWatch {
    private List<String> res = new LinkedList<>();

    public List<String> readBinaryWatch(int num) {
        res.clear();
        dfs(num, 0, 0, 1, 1, new LinkedList<>(), new LinkedList<>());
        return res;
    }

    // h：小时数，m：分钟数
    // hstart、mstart：从hstart、mstart开始继续遍历小时和分钟
    // hours：选中的小时，minutes：选中的分钟
    private void dfs(int num, int h, int m, int hstart, int mstart, LinkedList<Integer> hours, LinkedList<Integer> minutes) {
        if (hours.size() + minutes.size() == num) {
            if (h < 12 && m < 60) {
                res.add(String.format("%d:%02d", h, m));
            }
            return;
        }
        for (int i = hstart; i <= 8; i <<= 1) {
            hours.addLast(i);
            dfs(num, h + i, m, i << 1, mstart, hours, minutes);
            hours.removeLast();
        }
        for (int i = mstart; i <= 32; i <<= 1) {
            minutes.addLast(i);
            // hstart 直接设置为16（>=12)，避免重复计算
            dfs(num, h, m + i, 16, i << 1, hours, minutes);
            minutes.removeLast();
        }
    }
}
