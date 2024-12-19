package bencode;

public class DeBencoder {

    public static String decode(String bencode) {
        Character firstChar = bencode.charAt(0);
        if (firstChar.equals('i')) {
            return decodeInteger(bencode);
        } else if (Character.isDigit(firstChar)) {
            return decodeString(bencode);
        } else {
            throw new IllegalArgumentException("Invalid bencode");
        }
    }

    private static String decodeInteger(String input) {
        try {
            input = input.trim().substring(1, input.length() - 1);
            return String.valueOf(Long.parseLong(input));
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
