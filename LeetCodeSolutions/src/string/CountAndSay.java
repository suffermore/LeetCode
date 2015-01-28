package string;

public class CountAndSay {
	public String countAndSay(int n) {
        String src = "1";
        while (--n > 0) {
            char[] array = src.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                int count = 1;
                while (i + 1 < array.length && array[i] == array[i + 1]) {
                    i++;
                    count++;
                }
                sb.append(String.valueOf(count) + String.valueOf(array[i]));
            }
            src = sb.toString();
        }
        return src;
    }
}
