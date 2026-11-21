import java.util.*;

public class Main {
    static int[] topKFrequent(int[] nums, int k) {
        // 1. Count occurrences in one pass
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) count.merge(n, 1, Integer::sum);

        // 2. buckets[f] = numbers that appear exactly f times
        //    Size n + 1 because a frequency can equal n (e.g. [1,1,1,1])
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int f = e.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(e.getKey());
        }

        // 3. Walk from the highest frequency down until we have k numbers
        int[] res = new int[k];
        int idx = 0;
        for (int f = buckets.length - 1; f > 0 && idx < k; f--) {
            if (buckets[f] == null) continue;
            for (int num : buckets[f]) {
                res[idx++] = num;
                if (idx == k) break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsStr = scanner.nextLine().split(",");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i].trim());
        }
        int k = Integer.parseInt(scanner.nextLine().trim());
        int[] result = topKFrequent(nums, k);
        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(result[i]);
        }
        System.out.println(sb);
    }
}
