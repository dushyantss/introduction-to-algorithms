/**
* In place ascending insertion sort.
* In this sorting what we do is that we ensure that a sub array is always sorted.
* Then we add a new element into that array in each step by moving everything
* larger one step forward and finally when the current element is larger or
* when we cannot go further we stop and put the element in that place.
*
* So basically, we start from a key at index 1 and go back while the element is smaller
* or index >= 0 and put the value when we cannot go back anymore. then we increment
* the key index and repeat.
*
* The loop invariant in this case is that arr[0] to arr[j - 1] is always sorted
*
* @author Dushyant Singh Shekhawat dushyant225@gmail.com
*/
public class InsertionSort{

    /**
    *
    * @param arr The array to be sorted
    * @return the array sorted in ascending order
    */
    public static int[] sort(int[] arr){

        for(int j = 1; j < arr.length; j++){
            int key = arr[j];

            int i = j - 1;
            while(i >= 0 && arr[i] > key){
                arr[i + 1] = arr[i];
                i--;
            }

            arr[i + 1] = key;
        }

    }
}