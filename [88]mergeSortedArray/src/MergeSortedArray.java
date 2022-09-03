import org.junit.Test;

import java.util.Arrays;

/**
 * @author ukir
 * @date 2022/09/03 13:39
 **/
public class MergeSortedArray {

    /**
     * 方法1：合并后排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        for (int i : nums1) {
            System.out.print(i + ",");
        }
    }

    /**
     * 方法2：双指针
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int p;
        int[] sorted = new int[m + n];

        while (p1 < m || p2 < n) {
            if (p1 == m) {
                p = nums2[p2++];
            } else if (p2 == n) {
                p = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                p = nums1[p1++];
            } else {
                p = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = p;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
            System.out.print(nums1[i] + ",");
        }


    }

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, m, nums2, n);
        System.out.println();

    }

    @Test
    public void test2() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge2(nums1, m, nums2, n);
        System.out.println();

    }


}
