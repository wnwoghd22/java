import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int count = 5;
			int sum = 0;

			System.out.print("count: ");
			int temp = sc.nextInt();
			if(1 <= temp && temp <= 5)
				count = temp;
			else {
				System.out.println("count should be integer between 1 and 5");
				return;
			}

			for(int i = 0; i < count; ++i) {
				System.out.print((i + 1) + " point : ");
				temp = sc.nextInt();
				if(0 <= temp && temp <= 100)
					sum += temp;
				else {
					System.out.println("point should be integer between 0 and 100");
					return;
				}
					
			}
			
			int mean = sum / count;
			
			System.out.print("mean: " + mean + "\ngrade: ");
			switch(mean / 10) {
				case 4 : case 5 :
					System.out.println("D");
					break;
				case 6 :
					System.out.println("C");
					break;
				case 7 : case 8 :
					System.out.println("B");
					break;
				case 9 :
					System.out.println("A");
					break;
				default:
					if(mean == 100) System.out.println("A");
					else System.out.println("Fail");
					break;
			}
	}
}