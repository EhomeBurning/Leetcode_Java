public class Lc658_Find_K_Closest_Elements {

// Binary Search; 找最左边的在[mid, mid + k]区间取中点，只有x > [mid] + [mid + k] / 2, left = mid + 1;
// time: O(logn + k)
// space: O(k)
// 0 1 ... mid ...|... mid + k ... n - k


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // binary search find left index
        int start = 0, end = arr.length - k;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (x > arr[mid]) {
                if (x - arr[mid] > arr[mid + k] - x) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                end = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        int index = start;
        while (k > 0) {
            result.add(arr[index++]);
            k--;
        }
        return result;
    }
}