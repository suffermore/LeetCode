package string;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        //split by space
        String[] words = s.split(" ");
        
        //reverse
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1 ; i >= 0; i--) {
        	if (!words[i].equals("")) {
        		sb.append(words[i]).append(" ");
        	}
        }
        
        if (sb.length() == 0) {
        	return "";
        } else {
            System.out.println(sb.substring(0, sb.length() - 1));
            return sb.substring(0, sb.length() - 1);
        }
    }

	public String reverseWordsII(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        //split by space
        String[] words = s.split(" ");
        
        //reverse
        String str = "";
        for (int i = words.length - 1 ; i >= 0; i--) {
        	if (!words[i].equals("")) {
        		str = str + words[i] + " ";
        	}
        }
        
        if (str.length() == 0) {
        	return "";
        } else {
            System.out.println(str.substring(0, str.length() - 1));
            return str.substring(0, str.length() - 1);
        }
    }
	
	public static void main(String[] args) {
		ReverseWordsInAString r = new ReverseWordsInAString();
//		String s = " 1";
		String s = "the sky is blue";
		r.reverseWords(s);
	}
}
