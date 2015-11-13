package leetcode;

import java.util.Arrays;

public class FindMedianSolution
{
    public static void main(String[] args)
    {
        int[] num1 = new int[]{1,3,5};
        int[] num2 = new int[]{2,4};
        FindMedianSolution fms = new FindMedianSolution();
        double median = fms.findMedianSortedArrays(num1,num2);
        System.out.println(median);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        double median = 0 ;
        int lengthNum = nums1.length+nums2.length;
        int[] num = new int[lengthNum];

        for (int i = 0; i < nums1.length; i++)
        {
            num[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++)
        {
            num[nums1.length+i] = nums2[i];
        }

        Arrays.sort(num);
        median = (double) num.length%2 == 0 ? (num[num.length/2-1]+num[num.length/2])/2.0:(num[num.length/2]);

        return median;
    }
}