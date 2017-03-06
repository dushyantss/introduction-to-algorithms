import java.util.Arrays;

public class Solution24d{

    // just remember low, mid and high are actual indexes so last element has to be at high
    public static int merge(int[] arr, int low, int mid, int high){
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

        int j, k, result = 0;
        j = k = 0;
        for(int i = low; i <= high; i++){
            if(l[j] <= r[k]){
                arr[i] = l[j];
                j++;
            } else{
                arr[i] = r[k];
                result += n1 - j;
                k++;
            }
        } 

        return result; 
    }

    public static int sort(int[] arr, int low, int high){
        if(arr == null){
            return 0;
        }
        int sum = 0;
        if(low < high){
            int mid = (low + high)/2;
            int left = sort(arr, low, mid);
            int right = sort(arr, mid + 1, high);
            sum = merge(arr, low, mid, high) + left + right;
        }
        return sum;
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
        int[] t6 = new int[]{9, 8, 7, 6, 5, 4, 5, 8, 1};

        System.out.println(sort(t1, 0, 1));
        System.out.println(sort(t2, 0, t2.length - 1));
        System.out.println(sort(t3, 0, t3.length - 1));
        System.out.println(sort(t4, 0, t4.length - 1));
        System.out.println(sort(t5, 0, t5.length - 1));
        System.out.println(sort(t6, 0, t6.length - 1));
    }
}