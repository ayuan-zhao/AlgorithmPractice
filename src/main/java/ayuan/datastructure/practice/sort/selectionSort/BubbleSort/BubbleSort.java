package ayuan.datastructure.practice.sort.selectionSort.BubbleSort;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 1, 3, 1, 3, 1, 3, 2, 1, 5, 5, 5};
        bubbleSort1(arr1);
        bubbleSort2(arr1);

    }

    public static int[] bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            //每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;

            }


        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        return arr;

    }

    public static void bubbleSort2(int[] arr) {
        // 对 arr 进行拷贝，不改变参数内容
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        for (int ii = 0; ii < arr.length; ii++) {
            System.out.print(arr[ii]);
        }
    }
}


