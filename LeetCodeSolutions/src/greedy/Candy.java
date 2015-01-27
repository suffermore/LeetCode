package greedy;

import java.util.Arrays;

public class Candy {

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		
		int[] count = new int[ratings.length];
		Arrays.fill(count, 1);
		
		//1 round: from left to right
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				count[i] = count[i - 1] + 1;
			}
		}
		
		int sum = count[count.length - 1];
		//2 round: from right to left
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				if (count[i] <= count[i + 1]) {
					count[i] = count[i + 1] + 1;
				}
			}
			sum += count[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Candy c = new Candy();
		int[] ratings = {0};
		c.candy(ratings);
	}
}
