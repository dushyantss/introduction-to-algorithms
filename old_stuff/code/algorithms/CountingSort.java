import java.util.Arrays;

public class CountingSort{

    public static int[] sort(int[] arr){
        if(arr == null || arr.length <= 1){
            return arr;
        }
        return sortHelper(arr);
    }

    public static int[] sortHelper(int[] arr){
        int max = findMax(arr);
        int[] count = new int[max + 1];
        int[] arr2 = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }
        for(int i = 1; i < count.length; i++){
            count[i] += count[i - 1];
        }
        for(int i = 0; i < arr.length; i++){
            arr2[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        return arr2;
    }

    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
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