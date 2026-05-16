public class classactivity {
public static void main(String[] args) {
int x = 5;
int y = ++x + x++ + --x + x--;
System.out.println("Value of y: " + y);
System.out.println("Value of x after operations: " + x);
}
}