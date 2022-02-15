package ayuan.datastructure.practice.sort.selectionSort;


//import static com.sun.tools.javac.jvm.ByteCodes.swap;

//O（n^2），数据规模越小越好，不占用额外的内存空间
// 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
//再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
//重复第二步，直到所有元素均排序完毕。
public class SelectionSortDemo {

    public static void main(String[] args) {
        int[] arr1 = (new int[]{2, 1, 3, 1, 3, 1, 3, 2, 1, 5, 5, 5});
    }

    public static void BubbleSort(int[] arr) {
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
    }

    public static void BubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
