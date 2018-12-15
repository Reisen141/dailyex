public class 交换排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 3, 1, 5, 4, 5, 6, 57, 67, 65, 765, 7, 654, 5, 468, 7, 687, 57, 45, 4, 54, 58, 7, 87, 654, 5, 4, 567, 687, 564};
        int looper = 0;
        for (int x = 0; x <= arr.length - 1; x++) {
            for (int y = x + 1; y <= arr.length - 1; y++) {
                looper++;
                if (arr[x] >= arr[y])
                //判定[x]与[x+1]的大小
                {

                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                    //完成交换
                }


            }
        }
        printArray(arr);
        System.out.println(looper);
        //打印结论

    }



    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            if (x != arr.length - 1)
                System.out.print(arr[x] + ", ");
            else
                System.out.println(arr[x] + "]");
        }
    }
}
