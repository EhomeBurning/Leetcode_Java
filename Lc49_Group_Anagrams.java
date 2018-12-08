public class Lc49_Group_Anagrams {

/**
 * Tag: String, Hash Table, Count Sort
 * Time: O(N * K), N is the length of input strs, K is the maximum length of a string in strs
 * Space: O(N * K)
 * Solution: 建一个HashMap，key放1a1e1t，value放符合这个组合的list；建立一个a-z的count，对于每一个都initial一次
 * Note: Arrays.fill(arr, num) 将一个array里面全部填为num，只适用于一维
 */

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);

            for (char ch : str.toCharArray()) {  // count the chars
                count[ch - 'a']++;
            }

            String key = "";
            for (int i = 0; i < count.length; i++) {  // initial the key
                if (count[i] != 0) {
                    key += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
                }
            }

            if (map.containsKey(key)) {
                List<String> value = map.get(key);
                value.add(str);
            } else {
                List<String> value = new ArrayList<>();
                value.add(str);
                map.put(key, value);
            }

        }
        return new ArrayList<>(map.values());

    }
}