package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	public List<String> fullJustify(String[] words, int L) {
        List<String> rst = new ArrayList<String>();
        
        if (words.length == 0) {
        	String s = "";
        	while (L>0) {
        		s += " ";
        		L--;
        	}
        	rst.add(s);
        	return rst;
        }
        
        int curLen = words[0].length();
        String s = words[0];
        int i,j;
        for (i = 1, j = 0; i < words.length; i++) {
        	
        	if (curLen + 1 + words[i].length() > L) {
        		//not include words[i]
        		rst.add(createString(words, j, i - 1, L - curLen));
        		
        		//a new line starts from i
        		j = i;
        		curLen = words[i].length();
        	} else {
        		curLen = curLen + 1 + words[i].length();
        	}
        }
        
        //deal with last string
        rst.add(createString(words, j, i - 1, L - curLen));
        
        return rst;
    }
	
	private String createString(String[] words, int start, int end, int spaces) {
        String s = words[start];
        int spaceNum = spaces / (end - start + 1);
        int reminder = spaces % (end - start + 1);
        
        if (words.length > 1) {
			for (int i = start + 1; i <= end; i++) {
				s += " ";
				for (int j = spaceNum; j > 0; j--) {
					s += " ";
				}
				if (reminder > 0) {
					s += " ";
					reminder--;
				}
				s += words[i];
			}
        } else {
        	for (int j = spaceNum; j > 0; j--) {
        		s += " ";
        	}
        }
		
		return s;
	}
	
	public static void main(String[] args) {

        TextJustification t = new TextJustification();
        List<String> rst = new ArrayList<String>();
        
        String[] words = {"Listen","to","many,","speak","to","a","few."};
        rst = t.fullJustify(words, 6);

//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        rst = t.fullJustify(words, 16);
        
        System.out.println(rst.toString());
	}
}
