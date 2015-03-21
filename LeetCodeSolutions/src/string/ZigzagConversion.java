package string;

public class ZigzagConversion {
	public String convert(String s, int nRows) {
        int len = s.length();
        //try best to make it easy;
        if (len <= nRows || nRows == 1) {
        	return s;
        }
        
        char[] chars = new char[len];
        int index = 0;
        int size = 2 * nRows - 2;
        
        for (int i = 0; i < nRows; i++) {
        	
            //fill char array row by row
            for (int j = i; j < len; j+= size) {
                chars[index++] = s.charAt(j);
                
                if (i != 0 && i != nRows - 1) {
                	//chars[j + size - 2*i] is the one between chars[j] and chars[j + size]
                    int tmp = j + size - 2 * i;
                    if (tmp < len) {
                        chars[index++] = s.charAt(tmp);
                    }
                }
            }
        }
        return new String(chars);
    }
	
	public String convertII(String s, int nRows) {
        int length = s.length();
        //try best to make it easy;
        if (length <= nRows || nRows == 1) {
        	return s;
        }
        
        char[] chars = new char[length];
        int step = 2 * (nRows - 1);
        int count = 0;
	    for (int i = 0; i < nRows; i++){
    		int interval = step - 2 * i;
    		for (int j = i; j < length; j += step){
    		   	chars[count] = s.charAt(j);
    			count++;
    			if (interval < step && interval > 0 && j + interval < length && count <  length){
    				chars[count] = s.charAt(j + interval);
    				count++;
    			}
    		}
    	}
        return new String(chars);
    }
}
