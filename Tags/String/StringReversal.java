


public class StringReversal {
    // Method1: iterative reverse. (two pointer)
    public String reverseI(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] strArray = input.toCharArray();
        for (int left = 0, right = strArray.length - 1; left < right; left++, right--) {
            swap(strArray, left, right);
        }
        return new String(strArray);
    }
    
    // Method2: recursive.
    public String reverseII(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        
        char[] strArray = input.toCharArray();
        reverse(strArray, 0, input.length() - 1);
        return new String(strArray);
    }
    
    private void reverse(char[] inputArray, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(inputArray, left, right);
        reverse(inputArray, left + 1, right - 1);
    }
    
    private void swap(char[] inputArray, int left, int right) {
        char temp = inputArray[left];
        inputArray[left] = inputArray[right];
        inputArray[right] = temp;
    }
        
    public void test() {
        String input = "hello";
        String result1 = reverseI(input);
        System.out.println("Method 1 Result: " + result1);
        String result2 = reverseII(input);
        System.out.println("Method 2 Result: " + result2);
    }
    
    public static void main(String[] args) {
        StringReversal solution = new StringReversal();
        solution.test();
    }
    
}







