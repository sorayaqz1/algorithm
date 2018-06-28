import java.util.*;

public class CompareAddition {
	public static void main(String[] args) {
		int n = 10;
		HashMap map = new HashMap();
		for (int a=0; a<=n; a++) {
			for (int b=0; b<=n; b++) {
				int[] pair = {a, b};
				map.put(a+b, pair);
			}
		}
	}


}