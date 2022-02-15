package ayuan.datastructure;

public class PrintOddTimesNum {

    public static void main(String[] args) {

        //交换两个数的值
        swapTwoNumber(13, 25);
        //交换两个相同值的数
        swapTwoNumberSameNumber(28, 28);
        //一个整型数组中，只有一个数出现了奇数次，其他数出现了偶数次，怎么找出出现了奇数次的数
        printOddtimesNum1(new int[]{2, 1, 3, 1, 3, 1, 3, 2, 1});
        //一个整型数组中，有两个数出现了奇数次，其他数出现了偶数次，找出出现了奇数次的数
        printOddtimesNum2(new int[]{2, 1, 3, 1, 3, 1, 3, 2, 1, 5, 5, 5});


    }

    /**
     * 同一批数去异或^，和先后顺序无关，出现偶数次的数，异或完成
     */
    public static void printOddtimesNum1(int[] arr) {
        int eor = 0;
        for (int ele : arr) {
            eor ^= ele;
        }
        System.out.println("The odd time number is : " + eor);

    }

    /**
     * 异或（xor） 异或相当于无进位相加 0 ^ n = n n ^ n = 0
     */
    public static void swapTwoNumber(int a, int b) {
        System.out.println("a is: " + a + "," + "b is:" + b);
        a = a ^ b;// a= 13 ^ 25
        b = a ^ b;//b = 13 ^ 25 ^ 25; b = 13; a = 13 ^ 25;
        a = a ^ b;//a = 13 ^ 25 ^ 13 ; a = 25
        System.out.println("new a: " + a + "," + "new b :" + b);


    }

    /**
     * 前提是a 和 b 在内存里是两块独立的区域 即使a 和 b 的数字一样，交换完还是28 如果内存地址一样，就会被洗成0
     */
    public static void swapTwoNumberSameNumber(int a, int b) {
        System.out.println("a is: " + a + "," + "b is:" + b);
        a = a ^ b;// a= 28a ^ 28b
        b = a ^ b;//b = 28a ^ 28b ^ 28b; b = 28a; a = 28a ^ 28b;
        a = a ^ b;//a = 28a ^ 28b ^ 28a; a = 28b
        System.out.println("new a: " + a + "," + "new b :" + b);

    }

    /**
     * 出现奇数次的数为a，b 可知a 不等于b，所以 a ^ b 不等于0 用异或，到最后所有偶数的数都会被消掉，就剩下a ^ b eor: 1010111100 ～eor: 0101000011 ~eor+1:
     * 0101000100 eor & (~eor+1): 0000000100//提取出最右的1,剩下的位置都变0
     */

    public static void printOddtimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int eor1 = eor & (~eor + 1);

        int theOne = 0;
        for (int i = 0; i < arr.length; i++) {
            //只要倒数第三位不为1，结果都为0）
            if ((arr[i] & eor1) == 0) {//把某一位上等于1的给晒出去，其他数因为都是偶数会自动被消除，最后剩的值就是a或b

                theOne ^= arr[i];
            }
        }
        int theOtherOne = theOne ^ eor;

        System.out.println(theOtherOne + "," + theOne);
    }
}
