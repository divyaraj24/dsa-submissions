import java.util.*;

public class Main {
    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        for (int i : nums) {
            if (hs.contains(i)) return true;
            hs.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsStr = scanner.nextLine().split(",");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i].trim());
        }
        System.out.println(containsDuplicate(nums));
    }
}
