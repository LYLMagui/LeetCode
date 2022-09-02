import java.util.HashSet;

/**
 * @author ukir
 * @date 2022/09/02 10:50
 **/
public class ExistDuplicateElements {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,1};
        int[] nums2 = new int[]{1,2,3,4};
        int[] nums3 = new int[]{1,1,1,3,3,4,3,2,4,2};

        ExistDuplicateElements e = new ExistDuplicateElements();
        System.out.println(e.containsDuplicate(nums1));
        System.out.println(e.containsDuplicate(nums2));
        System.out.println(e.containsDuplicate(nums3));


    }


    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet();
        //将数组内的数添加到HashSet集合内
        for(int i : nums){
            set.add(i);
        }
        //set集合内的值是唯一不重复，如果集合的长度等于数组nums的长度，则说明nums内的元素都是互不相同的，否则存在重复元素
        if (set.size() == nums.length){
            return false;
        }else {
            return true;
        }
    }


}
