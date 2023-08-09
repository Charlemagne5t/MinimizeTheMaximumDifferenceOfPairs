import java.util.Arrays;


public class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p == 0){
            return 0;
        }
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ableToFormPPairs(nums, p, mid)) {
                result = Math.min(mid, result);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean ableToFormPPairs(int[] nums, int p, int target) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) <= target) {
                count++;
                i++;
                if (count == p) {
                    return true;
                }
            }
        }

        return false;
    }
}


