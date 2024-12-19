package bencode;

import com.google.gson.Gson;

public class DeBencoder {
    private static final Gson gson = new Gson();

    public static String decode(String bencode) {
        Character firstChar = bencode.charAt(0);
        if (firstChar.equals('i')) {
            return  gson.toJson(decodeInteger(bencode));
        } else if (Character.isDigit(firstChar)) {
            return gson.toJson(decodeString(bencode));
        } else {
            throw new IllegalArgumentException("Invalid bencode");
        }
    }

    private static Long decodeInteger(String input) {
        try {
            input = input.trim().substring(1, input.length() - 1);
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid integer: " + input);
        }
    }

    private static String decodeString(String input) {
        int index = 0;
        while (input.charAt(index) != ':') {
            index++;
        }
        int length = Integer.parseInt(input.substring(0, index));
        return input.substring(index + 1, index + length + 1);
    }
}
