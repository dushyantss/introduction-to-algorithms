import java.util.Arrays;

public class Solution222{

    public static int[] sort(int[] arr) {
        if(arr == null || arr.length <= 1){
            return arr;
        }

        int minIndex;
        for(int i = 0; i < arr.length; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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

        System.out.println(Arrays.toString(sort(t1)));
        System.out.println(Arrays.toString(sort(t2)));
        System.out.println(Arrays.toString(sort(t3)));
        System.out.println(Arrays.toString(sort(t4)));
        System.out.println(Arrays.toString(sort(t5)));
    }
}
