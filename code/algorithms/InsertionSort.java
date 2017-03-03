import java.util.Arrays;

public class InsertionSort{

    public static int[] sort(int[] arr) {
        if(arr == null || arr.length <= 1){
            return arr;
        }

        int key, i;
        for(int j = 1; j < arr.length; j++){
            key = arr[j];
            i = j - 1;

            while(i >= 0 && arr[i] > key){
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args){
        // test arrays
        int[] t1 = null;
        int[] t2 = new int[0];
        int[] t3 = new int[]{1};
        int[] t4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] t5 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(sort(t1)));
        System.out.println(Arrays.toString(sort(t2)));
        System.out.println(Arrays.toString(sort(t3)));
        System.out.println(Arrays.toString(sort(t4)));
        System.out.println(Arrays.toString(sort(t5)));
    }
}
