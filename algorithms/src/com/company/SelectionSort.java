package com.company;

import java.util.Arrays;

public class SelectionSort implements IArraySort{
    @Override
    public int []sort(int[] sourceArray){
        int []arr= Arrays.copyOf(sourceArray,sourceArray.length);
        //总共要进行N-1轮比较(注意和冒泡算法是有区别的，这里只能是N-1轮)
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){//这里尤其注意，一个是i<arr.length-1，一个是j<arr.length
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(i!=min){
                int target=arr[i];
                arr[i]=arr[min];
                arr[min]=target;
            }
        }
        return arr;
    }
}
