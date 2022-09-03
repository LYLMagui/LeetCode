import java.util.*;

/**
 * @author ukir
 * @date 2022/09/03 11:42
 **/
public class TwoSum {
    public static void main(String[] args) {
        int target = 6;
        int[] nums = new int[]{3, 2, 4};
        TwoSum two = new TwoSum();
//        for (int a : two.twoSum(nums, target)) {
//            System.out.println(a);
//        }
        for (int a : two.twoSum2(nums, target)) {
            System.out.println(a);
        }


    }

    /**
     * 方法1： 暴力枚举
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int n, sum;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            n = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = n + nums[j];
                if (target == sum) {
                    return new int[]{i, j};
                }
            }
        }
        //因为题目中说传入的数组一定有一个与之对应的答案，因此代码不会执行到这里，所以需要返回一个数组
        return new int[0];
    }

    /**
     * 方法2；哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        //创建一个哈希表用来存储数组中的元素和下标
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            //遍历之前先判断表中是否存在一个值和当前的num[i]的和等于target
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]),i};
            }
            //如果不存在，则将当前值存入哈希表中
            hashMap.put(nums[i],i );
        }
        return new int[0];

    }

}

