//Jinlong Ruan 31320658 CSC 171 HW1 Lab TR 9:40-10:55//
import java.util.Scanner;
public class DecimalCalculator 
{
	public static void main(String[] args)
	{
		double x;
		double y;
		Scanner N = new Scanner (System.in);
		System.out.println("Please enter two decimal numbers: ");
		x = N.nextDouble();
		y = N.nextDouble();
		System.out.println(x + "+" + y + "==" + (x+y));
		System.out.println(x + "-" + y + "==" + (x-y));
		System.out.println(x + "*" + y + "==" + (x*y));
		System.out.println(x + "/" + y + "==" + (x/y));
	}
}
//I did not collaborate with anyone on this assignment.//