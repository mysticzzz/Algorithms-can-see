package com.company;

import java.util.Arrays;

public class BubbleSort implements IArraySort {
    @Override
    public int []sort(int[] sourceArray) {
        int []arr= Arrays.copyOf(sourceArray,sourceArray.length);
        //总共要进行N轮比较
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                //这里尤其注意i<arr.length，
                // j<arr.length-i-1
               if(arr[j]>arr[j+1]){
                /* int target=arr[j];
                 arr[j]=arr[j+1];
                 arr[j+1]=target;*/
                swap(arr,j,j+1);
               }
            }
        }
        return arr;
    }
    private void swap(int[] arr, int i, int j) {//交换数组index的swap和交换两数的swap函数不同
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
