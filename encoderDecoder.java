import java.util.Map;
import java.util.HashMap;
import java.util.Random;

class encoderDecoder {
    private static Map<Integer, Character> indexRefHM;
    static {
        indexRefHM = new HashMap<Integer, Character>();
        indexRefHM.put(0, 'A');
        indexRefHM.put(1, 'B');
        indexRefHM.put(2, 'C');
        indexRefHM.put(3, 'D');
        indexRefHM.put(4, 'E');
        indexRefHM.put(5, 'F');
        indexRefHM.put(6, 'G');
        indexRefHM.put(7, 'H');
        indexRefHM.put(8, 'I');
        indexRefHM.put(9, 'J');
        indexRefHM.put(10, 'K');
        indexRefHM.put(11, 'L');
        indexRefHM.put(12, 'M');
        indexRefHM.put(13, 'N');
        indexRefHM.put(14, 'O');
        indexRefHM.put(15, 'P');
        indexRefHM.put(16, 'Q');
        indexRefHM.put(17, 'R');
        indexRefHM.put(18, 'S');
        indexRefHM.put(19, 'T');
        indexRefHM.put(20, 'U');
        indexRefHM.put(21, 'V');
        indexRefHM.put(22, 'W');
        indexRefHM.put(23, 'X');
        indexRefHM.put(24, 'Y');
        indexRefHM.put(25, 'Z');
        indexRefHM.put(26, '0');
        indexRefHM.put(27, '1');
        indexRefHM.put(28, '2');
        indexRefHM.put(29, '3');
        indexRefHM.put(30, '4');
        indexRefHM.put(31, '5');
        indexRefHM.put(32, '6');
        indexRefHM.put(33, '7');
        indexRefHM.put(34, '8');
        indexRefHM.put(35, '9');
        indexRefHM.put(36, '(');
        indexRefHM.put(37, ')');
        indexRefHM.put(38, '*');
        indexRefHM.put(39, '+');
        indexRefHM.put(40, ',');
        indexRefHM.put(41, '-');
        indexRefHM.put(42, '.');
        indexRefHM.put(43, '/');
    }

    private static Map<Character, Integer> refIndexHM;
    static{
        refIndexHM = new HashMap<Character, Integer>();
        
        for (int i = 0; i < indexRefHM.size(); i++){
            char c = indexRefHM.get(i);
            refIndexHM.put(c, i);
        }
    }

    public String encode(String plainText){
        Random rand = new Random();
        int offset = rand.nextInt(44);
        String encodedChar = indexRefHM.get(offset).toString();

        for (int i = 0; i < plainText.length(); i++){
            char c = plainText.charAt(i);

            if (refIndexHM.containsKey(c)){
                int idx = refIndexHM.get(c) - offset;
                
                if (idx < 0){
                    idx += 44;
                }
                
                encodedChar += indexRefHM.get(idx);
            } else {
                encodedChar += c;
            }
        }
        return encodedChar;
    }

    public String decode(String encodedText){
        char c = encodedText.charAt(0);
        int offset = refIndexHM.get(c);
        String plainText = "";

        for (int i = 1; i < encodedText.length(); i++){
            c = encodedText.charAt(i);
            
            if (refIndexHM.containsKey(c)){
                int idx = refIndexHM.get(c) + offset;
                
                if (idx > 43){
                    idx -= 44;
                }
                
                plainText += indexRefHM.get(idx);
            } else {
                plainText += c;
            }
        }
        return plainText;
    }
}