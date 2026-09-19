import java.util.*;

public class Main {
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
	for (int i = 0; i < nums.length; i++) {
		int complement = target - nums[i];
		if (hm.containsKey(complement)) {
			return new int[] {hm.get(complement), i};
		}
		hm.put(nums[i], i);
	}
	
	return new int[] {};
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
