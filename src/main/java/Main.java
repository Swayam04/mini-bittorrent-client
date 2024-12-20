import bencode.DeBencoder;

public class Main {

    public static void main(String[] args) throws Exception {
        System.err.println("Logs from your program will appear here!");
        String command = args[0];
        if ("decode".equals(command)) {
              String bencodedValue = args[1];
              String decoded;
              try {
                decoded = DeBencoder.decode(bencodedValue);
              } catch(RuntimeException e) {
                System.out.println(e.getMessage());
                return;
              }
              System.out.println(decoded);
        } else {
            System.out.println("Unknown command: " + command);
        }

    }

}
