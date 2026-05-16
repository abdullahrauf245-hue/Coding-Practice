public class classactivity {
    
// public static void main(String[] args) {
// int x = 5;
// int y = ++x + x++ + --x + x--;
// System.out.println("Value of y: " + y);
// System.out.println("Value of x after operations: " + x);
// }

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		modifyArray(arr);
		System.out.println(arr[2]);
	}

	static void modifyArray(int[] arr) {
		arr[2] = 10;
		arr = new int[]{6, 7, 8, 9, 10};
		arr[2] = 99;
	}


}

