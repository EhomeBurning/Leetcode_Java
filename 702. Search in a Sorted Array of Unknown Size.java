// > Tag: Binary Search -> Big Array;
// > Time: O(logn);
// > Space: O(1);


class Solution {
    public int search(ArrayReader reader, int target) {
        int index = 1;
        while (reader.get(index - 1) < target) {
            index *= 2;
        }
        
        int left = index / 2;
        int right = index;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}






