import java.util.Arrays;

public class QuickSort{
    public static void sort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        sortHelper(arr, 0, arr.length - 1);
    }

    public static void sortHelper(int[] arr, int low, int high){
        if(low < high){
            int mid = partition(arr, low, high);
            sortHelper(arr, low, mid - 1);
            sortHelper(arr, mid + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        // test arrays
        testSort();
    }

    private static void testSort(){
        int[] t1 = null;
        int[] t2 = new int[0];
        int[] t3 = new int[]{1};
        int[] t4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] t5 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort(t1);
        sort(t2);
        sort(t3);
        sort(t4);
        sort(t5);

        System.out.println(Arrays.toString(t1));
        System.out.println(Arrays.toString(t2));
        System.out.println(Arrays.toString(t3));
        System.out.println(Arrays.toString(t4));
        System.out.println(Arrays.toString(t5));
    }
}