// *Tags*: Two Pointers; <br>

// *Solution* : <br>
// Two Pointers(Different direction); 和正好就返回，和大了就right变小，和小了就left变大<br>
// *Time*: O(n) <br>
// *Space*: O(1) <br>
// *Tips*: <br>
// 1. new int[]{-1, -1};
// 2. avoid oveflow. numbers[left] == target - numbers[right]

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{-1, -1};
        }
        
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] == target - numbers[right]) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] > target - numbers[right]) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}

// class Solution{
//     public int[] twoSum(int[] numbers, int target) {
//         if (numbers == null || numbers.length < 2) {
//             return new int[]{-1, -1};
//         }

//         int left = 0, right = numbers.length - 1;
//         while (left < right) {
//             int sum = numbers[left] + numbers[right];
//             if (sum == target) {
//                 return new int[]{left + 1, right + 1}
//             } else if (sum > target) {
//                 right--;
//             } else {
//                 left++;
//             }
//         }
//         return new int[]{-1, -1};
//     }
// }





