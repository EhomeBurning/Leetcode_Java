package leetcode_1To300;

/**
 * 本代码来自 Cspiration，由 @Cspiration 提供
 * 题目来源：http://leetcode.com
 * - Cspiration 致力于在 CS 领域内帮助中国人找到工作，让更多海外国人受益
 * - 现有课程：Leetcode Java 版本视频讲解（1-900题）（上）（中）（下）三部
 * - 算法基础知识（上）（下）两部；题型技巧讲解（上）（下）两部
 * - 节省刷题时间，效率提高2-3倍，初学者轻松一天10题，入门者轻松一天20题
 * - 讲师：Edward Shi
 * - 官方网站：https://cspiration.com
 * - 版权所有，转发请注明出处
 */
public class _393_UTF8Validation {
    /**
     * 393. UTF-8 Validation
     * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

     For 1-byte character, the first bit is a 0, followed by its unicode code.
     For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
     This is how the UTF-8 encoding would work:

     Char. number range  |        UTF-8 octet sequence
     (hexadecimal)    |              (binary)
     --------------------+---------------------------------------------
     0000 0000-0000 007F | 0xxxxxxx
     0000 0080-0000 07FF | 110xxxxx 10xxxxxx
     0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
     0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

     Note:
     The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.

     Example 1:

     data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.

     Return true.
     It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
     Example 2:

     data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.

     Return false.
     The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
     The next byte is a continuation byte which starts with 10 and that's correct.
     But the second continuation byte does not start with 10, so it is invalid.

     10xxxxxx
     11000000

     10000000


     if((data[i] & 128) == 0) { // 0xxxxxxx, 1 byte, 128(10000000)
        numberOfBytes = 1;
     } else if((data[i] & 224) == 192) { // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
        numberOfBytes = 2;
     } else if((data[i] & 240) == 224) { // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
        numberOfBytes = 3;
     } else if((data[i] & 248) == 240) { // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
        numberOfBytes = 4;
     } else {
        return false;
     }
     if((data[i+j] & 192) != 128) return false; // 192(11000000), 128(10000000)

     time : O(n)
     space : O(1)

     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return false;
        boolean isValid = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 255) return false;
            int numberOfBytes = 0;
            if((data[i] & 128) == 0) { // 0xxxxxxx, 1 byte, 128(10000000)
                numberOfBytes = 1;
            } else if((data[i] & 224) == 192) { // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
                numberOfBytes = 2;
            } else if((data[i] & 240) == 224) { // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
                numberOfBytes = 3;
            } else if((data[i] & 248) == 240) { // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
                numberOfBytes = 4;
            } else {
                return false;
            }
            for (int j = 1; j < numberOfBytes; j++) {
                if (i + j >= data.length) return false;
                if((data[i+j] & 192) != 128) return false; // 192(11000000), 128(10000000)
            }
            i = i + numberOfBytes - 1;
        }
        return isValid;
    }
}
