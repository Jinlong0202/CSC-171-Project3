//Jinlong Ruan 31320658 CSC 171 HW1 Lab TR 9:40-10:55//
import java.util.Scanner;
public class FtoK 
{
	public static void main (String[] args)
	{
		double f;
		double k;
		Scanner F = new Scanner (System.in);
		System.out.println("Please enter a Fahrenheit temperature: ");
		f = F.nextDouble();
		k = 5.0/9.0*(f-32.0)+273;
		System.out.println(f + " degrees Fahrenheit is " + k + " Kelvin.");
	}

}
//I did not collaborate with anyone on this assignment.//