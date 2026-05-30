// Problem: Subarray Sum Equals K
// Approach: Prefix Sum + HashMap
// Time Complexity: O(n)

import java.util.*;

public class SubArraySumEqualsK{

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // To handle subarrays starting from index 0
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            // Check if (sum - k) exists
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Store current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k value: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays = " + result);

        sc.close();
    }
}