import java.util.*;

public class Main {
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hm.containsKey(diff)) {
                return new int[] {hm.get(diff), i};
            }
            hm.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsStr = scanner.nextLine().split(",");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i].trim());
        }
        int target = Integer.parseInt(scanner.nextLine().trim());
        int[] result = twoSum(nums, target);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(result[i]);
        }
        System.out.println(sb);
    }
}
