import java.util.Arrays;

/**
 * @author ukir
 * @date 2022/09/02 15:34
 **/
public class TheMaxSumOfSubarray {


    public static void main(String[] args) {
        TheMaxSumOfSubarray theMaxSumOfSubarray = new TheMaxSumOfSubarray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(theMaxSumOfSubarray.maxSubArray(nums));


    }


    /**
     * 方法一：动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
