import java.util.*;
/*
Question: Given two int arrays containing coordinates of stores and houses, find the shortest distance store from each house.
Example:
stores = {1,5,11,17,20}
houses = {5,12,19}
Should return {5,11,20}
*/



public class HouseStore {
    public static int[] solution(int[] stores, int[] houses) {
        if (stores == null || houses == null || stores.length == 0 || houses.length == 0) {
            return new int[]{};
        }
        int houseLen = houses.length;
        Arrays.sort(stores);
        int[] result = new int[houseLen];
        for (int i = 0; i < houseLen; i++) {
            int target = houses[i];
            result[i] = findCloset(stores, target);
        }
        return result;
    }

    private static int findCloset(int[] stores, int target) {
        if (target <= stores[0]) {
            return stores[0];
        }
        if (target >= stores[stores.length - 1]) {
            return stores[stores.length - 1];
        }
        int left = 0, right = stores.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (stores[mid] ==  target) {
                return stores[mid];
            } else if (stores[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int leftDistance = Math.abs(stores[left] - target);
        int rightDistance = Math.abs(stores[right] - target);
        if (leftDistance <= rightDistance) {
            return stores[left];
        } else {
            return stores[right];
        }
    }

    public static void main (String[] args) {
//        int[] stores = new int[]{1,5,11,17,20};
        int[] stores = new int[]{7,5,5,1000,100,7,8,20};
        int[] houses = new int[]{5,12,19};
        System.out.println(Arrays.toString(solution(stores, houses)));
    }
}
