package com.atguigu.Demo;

import java.util.Arrays;

/**
 * @Auther: zhaomo
 * @Date: 2020/2/16 11:32
 * @Description:
 */
public class ArrayTest2 {

    public static void main(String[] args) {
        int arr[] = new int[]{100,25,88,48,-98,-82,21,35,48,68};

        /*int dest1 = 34;
        dest1 = 11;
        int head = 0;   //初始的首索引
        int end = arr.length-1;     //初始的末索引
        boolean isFlag = true;

        while(head<=end){
            int middle = (head +end)/2;
            if(dest1 ==arr[middle]){
                System.out.println("找到了制定元素,位置:"+middle);
                isFlag =false;
                break;
            }else if (arr[middle] >dest1){
                end =middle-1;
            }else {
                head =middle+1;
            }
        }
        if (isFlag){
            System.out.println("很遗憾,没有找到了");
        }*/
        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = 0; j < arr.length -1 -i ; j++) {
                if (arr[j] > arr[ j+1 ]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] =temp;
                }

            }

        }
        System.out.println(Arrays.toString(arr));



    }


}
