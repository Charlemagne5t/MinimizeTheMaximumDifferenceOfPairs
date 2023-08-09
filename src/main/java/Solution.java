import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int[] absDiffs = new int[nums.length];
        absDiffs[0] = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            absDiffs[i] = Math.abs(nums[i] - nums[i - 1]);
        }
        Map<String, Integer> memo = new HashMap<>();

        return dfs(absDiffs, p, 1, 0, memo);
    }

    private int dfs(int[] absDiffs, int p, int i, int maxDif, Map<String, Integer> memo) {
        if(memo.containsKey(p + " " + i + " " + maxDif)){
            return memo.get(p + " " + i + " " + maxDif);
        }
        if (p == 0) {
            return maxDif;
        }
        if (i >= absDiffs.length) {
            return Integer.MAX_VALUE / 2;
        }

        int result = Math.min(dfs(absDiffs, p - 1, i + 2, Math.max(maxDif, absDiffs[i]), memo), dfs(absDiffs, p, i + 1, maxDif, memo));
        memo.put(p + " " + i + " " + maxDif, result);
        return result;
    }

}
