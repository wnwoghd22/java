import java.util.Scanner;

public class Main{
	public static int base;
	public static int StrToDecimal(String s) {
		int result = 0;
		boolean flag = false; //sign of value

		for(int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if(i == 0 && c == '-') {
				flag = true;
				continue;
			}		
			int digit;
			switch(c) {
			case '0': case '1': case '2': case '3': case '4':
			case '5': case '6': case '7': case '8': case '9':
				digit = c - '0'; break;
			case 'a': case 'A': digit = 10; break;
			case 'b': case 'B': digit = 11; break;
			case 'c': case 'C': digit = 12; break;
			case 'd': case 'D': digit = 13; break;
			case 'e': case 'E': digit = 14; break;
			case 'f': case 'F': digit = 15; break;
			default:
				System.out.println("invalid value in operand!");
				throw new RuntimeException();
			}
			if (digit >= base) {
				System.out.println(s + "is not allowed in base " + base + ".");
				throw new RuntimeException();
			}
		
			result = base * result + digit;	
		}
		if(flag) result *= -1;
		
		return result;
	}
	public static String Convert(int n) {
		String result = "";
		boolean flag = false;
		if(n < 0) {
			flag = true;
			n *= -1;
		}

		while(n >= base) {
			switch(n % base) {
				case 10: result = 'A' + result; break;
				case 11: result = 'B' + result; break;
				case 12: result = 'C' + result; break;
				case 13: result = 'D' + result; break;
				case 14: result = 'E' + result; break;
				case 15: result = 'F' + result; break;
				default: result = (n % base) + result; break;
			}
			n /= base;
		}

		switch(n) {
				case 10: result = 'A' + result; break;
				case 11: result = 'B' + result; break;
				case 12: result = 'C' + result; break;
				case 13: result = 'D' + result; break;
				case 14: result = 'E' + result; break;
				case 15: result = 'F' + result; break;
				default: result = n + result; break;
			}
		if(flag) result = '-' + result;
	
		return result;
	}	

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Base : "); 
		base = sc.nextInt();

		if(base < 2 || base > 16) {
			System.out.println("out of range!");
			return;
		}
		
		System.out.print("2 operands : ");
		String a = sc.next(), b = sc.next();

		char _operator;
		System.out.print("1 operator (+ or -) : ");
		_operator = sc.next().charAt(0);

		int result;

		try {
			switch(_operator) {
			case '+': 
				result = StrToDecimal(a) + StrToDecimal(b);
				break;
			case '-':
				result = StrToDecimal(a) - StrToDecimal(b);
				break;
			default:
				System.out.println("invalid operator!");
				throw new RuntimeException();
			}
			
		System.out.printf("%s %c %s = %s (Base %d) = %d (Base 10)\n",
				a, _operator, b, Convert(result), base, result);

		} catch(Exception e) {

		}
	}
}