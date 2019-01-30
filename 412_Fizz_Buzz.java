

// class Solution {
//     public List<String> fizzBuzz(int n) {
//         List<String> result = new ArrayList<>();
//         for (int i = 1; i <= n; i++) {
//             if (i % 3 == 0 && i % 5 == 0) {
//                 result.add("FizzBuzz");
//             } else if (i % 3 == 0) {
//                 result.add("Fizz");
//             } else if (i % 5 == 0) {
//                 result.add("Buzz");
//             } else {
//                 result.add(String.valueOf(i));
//             }
//         }
//         return result;
//     }
// }

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                result.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                result.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                result.add("Buzz");
                buzz = 0;
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
    
}
