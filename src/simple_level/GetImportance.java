package simple_level;

import java.util.*;

/**
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/1 17:36
 */
public class GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        // ×ª»¯Îªmap
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        int sum = 0;
        Queue<Employee> queue = new LinkedList<>();
        Employee target = map.get(id);
        if (target == null) {
            return 0;
        }
        queue.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Employee e = queue.poll();
                sum += e.importance;
                for (Integer subordinate : e.subordinates) {
                    queue.add(map.get(subordinate));
                }
            }
        }
        return sum;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
