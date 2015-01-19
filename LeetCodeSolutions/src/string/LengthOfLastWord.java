package string;

public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
		int length = 0;
		String[] array = s.split(" ");
		
		if(array.length == 0) {
			return 0;
		}
		
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] != "") {
				return array[i].length();
			}
		}
		
		return length;
    }
	
	public static void main(String[] args) {
		LengthOfLastWord l = new LengthOfLastWord();
		System.out.println(l.lengthOfLastWord("1"));
	}
}
