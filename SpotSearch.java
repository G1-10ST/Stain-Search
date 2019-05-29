
public class SpotSearch {

    public static int search(int arr[], int low, int high, int x)
    { 
        if(high >= low) 
        { 
            int mid = low + (high - low)/2; 
            if ((mid == 0 || x > arr[mid-1] )&& arr[mid] ==x) 
                return mid; 
             else if(x > arr[mid]) 
                return search(arr, (mid + 1), high, x); 
            else
                return search(arr, low, (mid -1), x); 
        } 
    return -1; 
    }
}
