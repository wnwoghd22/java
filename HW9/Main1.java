import java.util.*;

public class Main1 {
	public static int Encrypt(int r, int x) { return (r * x) % 10; }
	public static int Decrypt(int r, int y) {
		int result = 0;
		for(int i = 0; i < 10; ++i) {
			if((r * i) % 10 == y) {
				result = i;
				break;
			}
		}
		return result;
	}
	public static int StrToInt(String s, int r) {
		int result = 0;
		for(int i = 0; i < s.length(); ++i) {
			result = result * 10 + Decrypt(r, s.charAt(i) - '0');
		}
		return result;
	}
	public static String IntToStr(int x, int r) {
		String result = "";
		do{
			int temp = x % 10; x /= 10;
			result = Encrypt(r, temp) + result;
		} while(x > 10);
		result = Encrypt(r, x) + result;
		return result;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Encryption key and numbers y1, y2 in that key : ");
		int r = sc.nextInt();
		String y1 = sc.next(), y2 = sc.next();
		int num1 = StrToInt(y1, r), num2 = StrToInt(y2, r);
		int result = num1 * num2;
		String y3 = IntToStr(result, r);
		
		System.out.printf("%s(%d) * %s(%d) = %d * %d = %d = %s(%d)\n",
			y1, r, y2, r, num1, num2, result, y3, r);
	}
}