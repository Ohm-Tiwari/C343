import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lab9 {

    /** RADIX SORT
     *
     * This is NOT a recursive algorithm in the normal sense
     * This is to iterate through the digits of each number
     *
     * This method simply iterates through the number of digits in the max
     * element and calls radixHelper
     *
     * @param arr array to be sorted
     */
    static void radixSort(int[] arr) {
        //TODO
        int max = max(arr);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10) {
            radixHelper(arr, place);
        }
    }

    /* RADIX HELPER

             * Words do not do it justice. For a visualization see:
            * https://www.cs.usfca.edu/~galles/visualization/RadixSort.html
            *
            * @param arr array to be sorted
     * @param place the placement of the digit you are on
     */
    static void radixHelper(int[] arr, int place) {
        //TODO
        if(arr.length == 0) return;

        int size = arr.length;
        int[] output = new int[size+1];
        int max = max(arr);

        int[] count = new int[10];

        for (int i = 0; i < 10; ++i) {
            count[i] = 0;
        }

        for (int i = 0; i < size; i++) {
            count[(arr[i] / place) % 10]++;
        }

        //get total count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        //place elements in the correct order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = output[i];
        }
    }

    /** BUCKET SORT
     *
     * you are allowed to use Collections.Sort ONLY for sorting the individual buckets
     *
     * bucket sort is a scatter and gather sorting algorithm where you split all the
     * elements into "buckets" that correspond with which range the number lies in.
     *
     * You must first get the maximum and minimum elements and then calculate the ranges
     * the buckets will use.
     *
     * hint: (max - min) / number of buckets
     *
     * You must then disperse the elements into their corresponding buckets
     *
     * Then sort the buckets. (This is where you may use Collections.Sort or copy code
     * from the previous lab idc)
     *
     * Lastly "dump" the buckets back into the arr and you are done!
     *
     * @param arr array to be sorted
     * @param noOfBuckets the number of buckets to be used
     */
    static void bucketSort(int[] arr, int noOfBuckets)
    {
        //TODO
        if (noOfBuckets <= 0){
            return;
        }
        int maxVal = max(arr);
        int minVal = min(arr);
        int bucketRange = (maxVal - minVal) / noOfBuckets;

        if (maxVal > minVal + bucketRange * (noOfBuckets - 1)) {
            maxVal = minVal + bucketRange * (noOfBuckets - 1);
        }


        List<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < noOfBuckets; i++) {
            buckets.add(new LinkedList<Integer>());
        }


        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - minVal) / bucketRange;
            if(bucketIndex >= buckets.size()) bucketIndex--;
            buckets.get(bucketIndex).add(arr[i]);
        }


        for (LinkedList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
            for (int element : bucket) {
                arr[index++] = element;
            }
        }
    }

    /** MAX
     * useful for bucket sort and radix sort
     *
     * iterate through the array and return the largest element
     *
     * @param arr array of integers
     * @return the maximum element of the array
     */
    public static int max(int[] arr) {
        //TODO
        if(arr.length == 0) return 0;
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    /** MIN
     * useful for bucketsort
     *
     * iterate through the array and return the smallest element
     *
     * @param arr array of integers
     * @return the minimum element of the array
     */
    public static int min(int[] arr) {
        //TODO
        if (arr.length == 0){return 0;}
        int min = arr[0];
        for (int i = 0; i < arr.length ; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

}
