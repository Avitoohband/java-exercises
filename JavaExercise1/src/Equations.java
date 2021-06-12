/**
 * This program solves system of two equations
 *
 * @author Avi Tuchband
 *
 */
import java.util.Scanner;
public class Equations
{
    public static void main(String [] args)
   {
       int a11,a12,a21,a22,b1,b2; // to store the coefficients
       final int MAX = 1000; // to round the numbers
       double x1,x2 ;   // to store the solutions
       Scanner scan = new Scanner(System.in);
       
       System.out.println("Enter the coefficinets a11 a12 a21 a22 b1 b2");
       
       a11 = scan.nextInt(); 
       a12 = scan.nextInt();
       a21 = scan.nextInt();
       a22 = scan.nextInt();
       b1 = scan.nextInt();
       b2 = scan.nextInt();
       
       System.out.printf("%d %d %d %d %d %d \n",a11, a12,a21,a22,b1,b2);
       
       System.out.printf("Eq1: %d*x1+%d*x2=%d\nEq1: %d*x1+%d*x2=%d\n",a11,a12,b1,a21,a22,b2);
       
       if ((a11*a22)-(a12*a21) != 0) // checks if there is only one solution
        {   
            x1 = (double)((b1*a22 - b2*a12)/(double)(a11*a22 - a12*a21));
            x2 = (double)((b2*a11 - b1*a21)/(double)(a11*a22 - a12*a21));
            double afterRounding1 = Math.round (x1 * MAX) / (MAX * 1.0);
            double afterRounding2 = Math.round (x2 * MAX) / (MAX * 1.0);
            System.out.println("Single solution:("+afterRounding1 + ","+afterRounding2 + ")");
        }
        else if (((a11 == 0) && (a12 == 0) && (b1 != 0) ) || ((a21 == 0) && (a22 == 0) && (b2 != 0)))
        System.out.println("No solution");
        
        else if ((b2*a11-b1*a21 == 0) && (b1*a22-b2*a12 == 0))
        {
            System.out.println("Many solutions");
        }
        
    }
}
