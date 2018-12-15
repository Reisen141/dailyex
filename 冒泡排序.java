import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 3, 1, 5, 4, 5, 6, 57, 67, 65, 765, 7, 654, 5, 468, 7, 687, 57, 45, 4, 54, 58, 7, 87, 654, 5, 4, 567, 687, 564};
        int looper=0;
        for (int y = 0; y <= arr.length-1;y++)
        {
            for (int x = 0; x <= arr.length - 2; x++)
            {
                if (arr[x] > arr[x + 1]) {
                    int temp = arr[x];
                    arr[x] = arr[x + 1];
                    arr[x + 1] = temp;
                    //完成交换
                }
            looper++;
            }
        }
        printArray(arr);
        System.out.println("looper="+looper);
            //打印结论

        }
    public static void printArray(int[] arr)
    {
        System.out.print("[");
        for(int x=0; x<arr.length; x++)
        {
            if(x!=arr.length-1)
                System.out.print(arr[x]+", ");
            else
                System.out.println(arr[x]+"]");
        }

    }

    }

