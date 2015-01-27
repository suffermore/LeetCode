package dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {
    	List<String> rst = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
        	return rst;
        }
        helper(rst, s, new ArrayList<String>(), 0);
        
        System.out.println(rst.toString());
        return rst;
    }

	private void helper(List<String> result, String s, ArrayList<String> path, int pos) {
		if (path.size() == 4) {
			//when path do not contain all the numbers in the string
			if (pos != s.length()) {
				return;
			}
			//add to result
			String temp = "";
			for (String item: path) {
				temp = temp + "." + item;
			}
			result.add(temp.substring(1));
			return;
		}
		
		for (int i = pos; i < s.length() && i < pos + 4; i ++) {
			String temp = s.substring(pos, i + 1);
			if (isValid(temp)) {
				path.add(temp);
				helper(result, s, path, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}

	private boolean isValid(String s) {
		//notice the use of '' or ""
		if (s.charAt(0) == '0') {
			return s.equals("0");
		} else {
			int tar = Integer.valueOf(s);
			return tar <= 255 && tar >= 1;
		}
	}

	public static void main(String[] args) {
		
		RestoreIPAddress r = new RestoreIPAddress();
		r.restoreIpAddresses("2551023");
		
	}
}
