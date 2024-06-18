import java.util.Arrays;

public class MergeSort{

    // just remember low, mid and high are actual indexes so last element has to be at high
    public static void merge(int[] arr, int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] l = new int[n1 + 1];
        int[] r = new int[n2 + 1];
        for(int i = 0; i < n1; i++){
            l[i] = arr[low + i];
        }
        for(int i = 0; i < n2; i++){
            r[i] = arr[mid + 1 + i];
        }
        l[n1] = Integer.MAX_VALUE;
        r[n2] = Integer.MAX_VALUE;

        int j, k;
        j = k = 0;
        for(int i = low; i <= high; i++){
            if(l[j] < r[k]){
                arr[i] = l[j];
                j++;
            } else{
                arr[i] = r[k];
                k++;
            }
        }  
    }

    public static int[] sort(int[] arr, int low, int high){
        if(arr == null){
            return arr;
        }
        if(low < high){
            int mid = (low + high)/2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
        return arr;
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

        System.out.println(Arrays.toString(sort(t1, 0, 1)));
        System.out.println(Arrays.toString(sort(t2, 0, t2.length - 1)));
        System.out.println(Arrays.toString(sort(t3, 0, t3.length - 1)));
        System.out.println(Arrays.toString(sort(t4, 0, t4.length - 1)));
        System.out.println(Arrays.toString(sort(t5, 0, t5.length - 1)));
    }
}