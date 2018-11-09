public class Lc349_Intersection_of_Two_sorted_Array {
// solution: 两个HashSet， set1一个储存nums1, 另一个只要在set1中找到了nums2的元素，就放到set2内
// time : O(n)
// space: O(n)
// UNIQUE!!!! 所以不需要用count那个方法

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        int size = resultSet.size();
        int[] result = new int[size];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        return result;
    }
}
