public class Lc347_Top_K_Freq_Elements {

// HashMap<num, #freq>
// List<Integer>[]; index = freq num [0,1,2,3,4,5], 每一个freq下面对应着List，装着该freq下面出现的num
// time: O(n)
// space: O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqArray = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (freqArray[freq] == null) {
                freqArray[freq] = new ArrayList<>();
            }
            freqArray[freq].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = freqArray.length - 1; i >= 0 && result.size() < k; i--) {
            if (freqArray[i] != null) {
                result.addAll(freqArray[i]);
            }
        }
        return result;
    }
}
