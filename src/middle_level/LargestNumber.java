package middle_level;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/4/12 10:58
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            String s1 = o1 + "";
            String s2 = o2 + "";
            return (s2 + s1).compareTo(s1 + s2);
        });
        for (int num : nums) {
            queue.add(num);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll() + "");
        }
        String s = sb.toString();
        s = s.charAt(0) == '0' ? "0" : s;
        return s;
    }

    public static void main(String[] args) {
        LargestNumber num = new LargestNumber();
        System.out.println(num.largestNumber(new int[]{10, 2}));
    }
}
