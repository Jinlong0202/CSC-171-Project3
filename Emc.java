//Jinlong Ruan 31320658 CSC 171 HW1 Lab TR 9:40-10:55//
import java.util.Scanner;
public class Emc 
{
	public static void main(String[] args)
	{	
		double E;
		double m1;
		double m2;
		double c;
		c=300000000;
		Scanner M = new Scanner (System.in);
		System.out.println("please enter the mass (grams) of the object: ");
		m1 = M.nextDouble();
		m2 = m1/1000.0;
		E  = m2*(c*c);
		System.out.println(E + "Joules.");
	}
}
//I did not collaborate with anyone on this assignment.//