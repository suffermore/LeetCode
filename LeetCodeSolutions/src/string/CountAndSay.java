package string;

public class CountAndSay {
	public String countAndSayI(int n) {
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
	
	public String countAndSay(int n) {
        String src = "1";
        
        while (--n > 0) {
            char[] arr = src.toCharArray();
            StringBuffer sb = new StringBuffer();
            
            int count = 1;
            char cur = arr[0];
            for (int i = 1; i < arr.length; i++) {
            	
                if (arr[i] == arr[i - 1]) {
                    count++;
                } else {
                    sb.append(String.valueOf(count) + String.valueOf(cur));
                    cur = arr[i];
                    count = 1;
                }
            }
            sb.append(String.valueOf(count) + String.valueOf(cur));
            
            src = sb.toString();
        }
        return src;
    }
	
	public static void main(String[] args) {
		
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay(4));
		
		
	}
}
