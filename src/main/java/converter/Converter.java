package converter;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    private Map<String, String> alphaToNumberMatchingMap = new HashMap<String, String>() {
        {
            put("A", "10");
            put("B", "11");
            put("C", "12");
            put("D", "13");
            put("E", "14");
            put("F", "15");
            put("G", "16");
            put("H", "17");
            put("I", "18");
            put("J", "19");
            put("K", "20");
            put("L", "21");
            put("M", "22");
            put("N", "23");
            put("O", "24");
            put("P", "25");
            put("Q", "26");
            put("R", "27");
            put("S", "28");
            put("T", "29");
            put("U", "30");
            put("V", "31");
            put("W", "32");
            put("X", "33");
            put("Y", "34");
            put("Z", "35");
        }
    };

    private boolean numberDetector(String s) {
        return s.matches("\\d?");
    }

    private boolean literalDetector(String s) {
        return s.matches("[a-zA-Z&&[^iloILO]]?");
    }

    public String convertAlphaNumericCodeToNumber(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String chString;
            if (numberDetector(String.valueOf(ch))) {
                sb.append(ch);
            } else if (literalDetector(chString = String.valueOf(ch))) {
                sb.append(alphaToNumberMatchingMap.get(chString));
            }
        }

        return String.valueOf(Long.valueOf(sb.toString()) - 600_000_000);
    }

}
