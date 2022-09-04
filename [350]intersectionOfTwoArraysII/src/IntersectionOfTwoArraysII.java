import org.junit.Test;

import java.util.*;

/**
 * 350. 两个数组的交集
 **/
public class IntersectionOfTwoArraysII {

    /**
     * 方法一：哈希表
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hash = new HashMap<>();
        //将长度较短的数组赋给temp
        int[] temp = nums1.length > nums2.length ? nums2 : nums1;

        //遍历temp
        for (int i = 0; i < temp.length; i++) {
            if (hash.containsKey(temp[i])) {
                //map中存在这个键则让这个数的次数 + 1
                //hash.put(temp[i], hash.get(temp[i]) + 1); //未优化
                hash.put(temp[i], hash.getOrDefault(temp[i], 0) + 1); //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            } else {
                //不存在则添加到map中，value表示出现了一次
                hash.put(temp[i], 1);
            }
        }
        //用来存放结果
        System.out.println(temp.length);
        int[] result = new int[temp.length];
        //将较长的数组赋给temp
        temp = !(nums1.length > nums2.length) ? nums2 : nums1;
        int index = 0;
        //遍历temp
        for (int num : temp) {
            //是否存在这个key，且次数大于0
            if (hash.containsKey(num) && hash.get(num) > 0) {
                //次数 -1
                hash.put(num, hash.get(num) - 1);
                //添加到存放结果的数组中
                result[index++] = num;
            }
        }
        return Arrays.copyOfRange(result,0,index); //将数组拷贝至另外一个数组 参数：original 要拷贝的数组对象 from 开始位置 to 结束位置
    }


    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        int[] intersect = intersectionOfTwoArraysII.intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        int[] intersect = intersectionOfTwoArraysII.intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }

    @Test
    public void test3(){

        int[] n = new int[5];
        int[] m = new int[]{1,2,3};

        //可以使用copyOfRange()方法截取数组。
        int[] ints = Arrays.copyOfRange(n, 0, 1);
        for(int l:ints){
            System.out.println(l);
        }



    }
}
