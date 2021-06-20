package com.rookied.learning.sort;

import java.util.Arrays;

/**
 * @author zhangqiang
 * @date 2020/3/31
 */
public class SortTest {
    public static void main(String[] args) {
        int[] nums = {7, 9, 1, 6, 3, 3};
        //selectSort(nums);
        //insertSort(nums);
        //bubbleSort(nums);
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void selectSort(int[] nums){
        if(nums == null || nums.length<2){
            return;
        }
        for(int i=0;i<nums.length-1;i++){
            int min = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[min]>nums[j]){
                    min = j;
                }
            }
            if(min != i){
                swap(nums,min,i);
            }
        }

    }

    public static void insertSort(int[] nums){
        if(nums == null || nums.length<2){
            return;
        }
        for(int i=1;i<nums.length;i++){
            int value = nums[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(value<nums[j]){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j+1] = value;
        }
    }

    public static void bubbleSort(int[] nums){
        if(nums == null || nums.length<2){
            return;
        }
        for(int i=0;i<nums.length-1;i++){
            boolean isSort = true;
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                    isSort = false;
                }
            }
            if(isSort){
                break;
            }
        }
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        //切分
        int pivotIndex = partition(arr, startIndex, endIndex);
        sort(arr, startIndex, pivotIndex-1);
        sort(arr, pivotIndex+1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];//取基准值
        int mark = startIndex;//Mark初始化为起始下标

        for(int i=startIndex+1; i<=endIndex; i++){
            if(arr[i]<pivot){
                //小于基准值 则mark+1,并交换位置。
                mark ++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //基准值与mark对应元素调换位置
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

}
