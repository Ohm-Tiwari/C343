public class Lab8Th {

    /** This method simply swaps 2 elements in an array.
     *  This is used for insertion sort
     *
     * @param arr array that contains the elements that need swapped
     * @param i index of the first element
     * @param j index of the second element
     */
    void swap(int[] arr, int i, int j) throws IllegalArgumentException
    {
        //TODO
        if (arr == null){
            throw new IllegalArgumentException("Array can't be null");
        }
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /** INSERTION SORT
     *
     *  do NOT use Collections.sort that will result in a 0 for this method
     *
     *  This is an insertion sort where you must sort the elements in the array
     *  For an in depth explanation of insertion sort see:
     *  https://www.geeksforgeeks.org/insertion-sort/
     *
     * @param arr array to be sorted
     * @return the sorted array
     */
    public int[] insertionSort(int[] arr) {
        //TODO
        if (arr == null){
            return null;
        }
        for (int i = 1 ; i < arr.length ; i++){
            int k = i;
            while (k > 0 && arr[k] < arr[k - 1]){
                swap(arr,k,k - 1);
                k--;
            }
        }
        return arr;
    }

    /** MERGE
     *
     * This merges 2 subarrays of an array arr.
     * These sub arrays are organized:
     *  leftArr = [left...middle]
     *  rightArr = [middle + 1...right]
     *
     * Make 2 arrays that contain the elements of the subarrays
     * and then insert them into arr in a sorted order such that merging:
     * leftArr = [1, 2, 5]
     * rightArr = [3, 4, 6, 7]
     *
     * into arr becomes:
     * arr = [1, 2, 3, 4, 5, 6, 7]
     *
     * @param arr array that contains both subarrays
     * @param left the index of the left
     * @param middle the index of the middle
     * @param right the index of the right
     */
    void merge(int arr[], int left, int middle, int right)
    {
        //TODO
        if (arr == null){
            throw new IllegalArgumentException();
        }
        int temp = middle+1;
        for(int i = left; i<temp; i++) {
            for (int j = temp; j < right; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    i = left;
                }
            }
        }
        for(int i = left; i<temp;i++){
            if(arr[i+1] < arr[i]){
                swap(arr,i+1,i);
                if(i+1 == temp)break;
            }
        }
        for(int i = temp; i<right; i++){
            if(arr[i+1] < arr[i]){
                swap(arr, i+1, i);
                if(i+1 == right)break;
            }
        }

    }

    /** MERGESORT
     *
     * do NOT use Collections.sort that will result in a 0 for this method
     *
     * A recursive implementation of mergeSort where in every recursive call,
     * you check if the left index is greater thatn the right index.
     * if so, you must find the index directly in the middle between those 2
     * and then recursively call mergeSort on the 2 sections of the array.
     * After the recusive calls you should merge the 2 subarrays that were
     * just defined by left, right, and the middle indices.
     *
     * @param arr array to be sorted
     * @param left left index
     * @param right right index
     */
    void mergeSort(int arr[], int left, int right)
    {
        //TODO
        if (arr == null){
            throw new IllegalArgumentException();
        }
        if (left < right){
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

}