public class RandomisedSelect{

    public static int select(int[] arr, int i){
        if(arr == null || i <= 0 || i > arr.length){
            return -1;
        }
        return selectHelper(arr, 0, arr.length - 1, i);
    }

    public static int selectHelper(int[] arr, int low, int high, int i){
        if(low == high){
            return arr[low];
        }
        int mid = randomisedPartition(arr, low, high);
        int val = mid - low + 1;
        if(val == i){
            return arr[mid];
        } else if(val > i){
            return selectHelper(arr, low, mid - 1, i);
        } else{
            return selectHelper(arr, mid + 1, high, i - val);
        }
    }

    public static int randomisedPartition(int[] arr, int low, int high){
        int p = (int)(Math.random() * (high - low)) + low;
        swap(arr, high, p);
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, j , i);
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
        testArrays();
    }

    public static void testArrays(){
        int[] t1 = null;
        int[] t2 = new int[0];
        int[] t3 = new int[]{1};
        int[] t4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] t5 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(select(t1, 2));
        System.out.println(select(t2, 2));
        System.out.println(select(t3, 2));
        System.out.println(select(t4, 2));
        System.out.println(select(t5, 2));
    }
}