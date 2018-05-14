import java.util.HashMap;
import java.util.Random;
/**
 * Tag: Hash Table, Math
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * ps: HashMap, StringBuilder.setLength(0)
 */

public class Lc535_Encode_And_Decode_TinyURL {
    HashMap<String, String> UrlToHash = new HashMap<>();
    HashMap<String, String> HashToUrl = new HashMap<>();

    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    String baseUrl = "http://www.tinyurl.com/";
    Random random = new Random();


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (UrlToHash.containsKey(longUrl)) {
            return baseUrl + UrlToHash.get(longUrl);
        }

        StringBuilder randomString = new StringBuilder();
        do {
            randomString.setLength(0);
            for (int i = 0; i < 6; i++) {
                randomString.append(chars.charAt(random.nextInt(chars.length())));
            }
        } while (HashToUrl.containsKey(randomString.toString()));

        UrlToHash.put(longUrl, randomString.toString());
        HashToUrl.put(randomString.toString(), longUrl);

        return baseUrl + randomString;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return HashToUrl.get(shortUrl.substring(baseUrl.length()));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));