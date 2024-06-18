import java.util.Arrays;

public class Solution213{

    public static int search(int v, int[] arr) {
        int result = -1;
        if(arr == null || arr.length <= 0){
            return result;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == v){
                result = i;
                break;
            }
        }

        return result;
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

        System.out.println(search(4, t1));
        System.out.println(search(4, t2));
        System.out.println(search(4, t3));
        System.out.println(search(4, t4));
        System.out.println(search(4, t5));
    }
}
