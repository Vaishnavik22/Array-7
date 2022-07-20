// TC: O(n)
public class Main {
    
    public static int binarySearch(String arr[], String target) {
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid].equals("")) {
                int left = mid - 1;
                int right = mid + 1;
                
                while (true) {
                    if (left < low && right > high) {
                        return -1;
                    }
                    
                    if (left >= low && arr[left] != "") {
                        mid = left;
                        break;
                    }
                    
                    if (right <= high && arr[right] != "") {
                        mid = right;
                        break;
                    }
                    --left;
                    ++right;
                }
            }
            if (arr[mid].equals(target)) {
                return mid;
            } else if (target.compareTo(arr[mid]) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        // This array is sorted lexicographically
        String arr[] = new String[]{"for", "","","","","geeks","","","","","","iron","","","","","zooms"};
        String target = "xerox";
        
        System.out.println(binarySearch(arr, target));
    }
}