package middle_level;

/**
 * 《玩转算法面试视频例题》对撞指针
 * 11 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * @author Wang Guolong
 * @create 2019-04-16 2:03 PM
 */
public class MaxArea {
    /**
     * 暴力解法
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        //至少含有两条线
        int maxArea = 0;
        for (int x = 0; x < height.length; x++) {
            for (int y = x + 1; y < height.length; y++) {
                maxArea = Math.max(maxArea, (y - x) * Math.min(height[x], height[y]));
            }
        }
        return maxArea;
    }

    /**
     * 双指针
     * 参照这Leetcode 125:验证回文串、Leetcode 344:验证回文串、Leetcode 167:两数之和 II - 输入有序数组、Leetcode 345:反转字符串中的元音字母几篇文章中的解题思路。
     * 我们通过设置两个指针，分别指向数组的头l和尾r，计算容器可以容纳多少水contain。
     * 我们知道想要容乃的水最多，最好的情况是l和r都是最大，然后二者离的最远，
     * 但是这是理想情况，我们最一般的情况是
     * 二者离的足够远，但是二者都不是很大
     * 二者都很大，但是二者离的近
     * 所以我们一开始从两边考虑就是考虑的第一种可能。
     * 如果这个时候num[l] < num[r]，我们就需要将l++，
     * 因为我们的容量由短板决定，所以我们希望短板更长。
     * 如果这个时候num[l] > num[r]，我们就需要将r--。
     * 而num[l] == num[r]，l++或者r--都可以。
     * @param height
     * @return
     */
    public static int maxArea_better(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }

    /**
     *  每次选定围成水槽两板高度 h[i],h[j] 中的短板，向中间收窄 1 格。以下证明：
     * 设每一状态下水槽面积为 S(i, j),(0 <= i < j < n)，由于水槽的实际高度由两板中的短板决定，则可得面积公式 S(i, j) = min(h[i], h[j]) × (j - i)。
     * 在每一个状态下，无论长板或短板收窄 1 格，都会导致水槽 底边宽度 −1：
     * 若向内移动短板，水槽的短板 min(h[i], h[j]) 可能变大，因此水槽面积 S(i, j) 可能增大。
     * 若向内移动长板，水槽的短板 min(h[i], h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
     * 因此，向内收窄短板可以获取面积最大值。
     * @param height
     * @return
     */
    public static int maxArea_better_easy(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}