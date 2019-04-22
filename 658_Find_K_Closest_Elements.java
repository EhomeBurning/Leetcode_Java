// * Tag: Binary Search - left + 1 < right;
// * Solution:
//     * Step1: Find the left and right range of target;
//     * Step2: Middle out. 中心开花， 谁近移谁;
// * Time: O(logn + k);
// * Space: O(1);



class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        if (arr.length == 1) {
            return new ArrayList<>(Arrays.asList(arr[0]));
        }
        
        int index = largestSmallerEqual(arr, x);
        return addNums(arr, index, k, x);
    }
    
    private int largestSmallerEqual(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (arr[right] <= target) {
            return right;
        }
        if (arr[left] <= target) {
            return left;
        }
        return 0;
    }
    
    private List<Integer> addNums(int[] arr, int index, int k, int x) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 1. right out of bound || left closer -> add(left--);
        // 2. left out of bound || right closer -> add(right++);
        
        int left = index, right = index;
        // for (int i = 0; i < k - 1; i++) {
        //     if (right >= arr.length - 1) {
        //         left--;
        //     } else if (left <= 0) {
        //         right++;
        //     } else if (Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x)) {
        //         left--;
        //     } else {
        //         right++;
        //     }
        // }
        
        for (int i = 0; i < k - 1; i++) {
            if (right >= arr.length - 1 ||
                left > 0 && Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x)) {
                left--;
            } else {
                right++;
            }
        }
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}



