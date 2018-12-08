public class Lc42_Trapping_Rain_Water {

// solution: min(lmax, rmax) - current
// 两边挡板哪个小哪个就能存水, 然后min - cur即可
// time: O(n)
// space: O(1)

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lmax = 0;
        int rmax = 0;
        int result = 0;
        while (left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);
            if (lmax < rmax) {
                result += lmax - height[left];
                left++;
            } else {
                result += rmax - height[right];
                right--;
            }
        }
        return result;
    }


}

