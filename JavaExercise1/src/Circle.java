
/**
 * This program will get from the user four number that will represent coordinates
 * of a rectangle and then calcuale the incircle and excircle 
 * radius, area and perimeter.
 *
 * @author Avi Tuchband
 */
import java.util.Scanner;
public class Circle
{
    public static void main(String[] args)
    {
        int leftUpX, leftUpY, rightDownX, rightDownY; // ints to store the coordinates
        double diameter , radius, area, perimeter ; //to make calculations with
        
        Scanner scan = new Scanner (System.in);
        
        System.out.println ("This program calculates the ares " +
        "and the perimeters of the excircle and the incircle " +
        "of a given rectangle");        
        System.out.println("Please enter the coordinates of the "+
        "left-upper point of the rectangle");
        
        // get the first point (upper-left) from the user
       leftUpX = scan.nextInt(); 
       leftUpY = scan.nextInt();
       
       System.out.println("Please enter the coordinates of the "+
        "right-bottom point of the rectangle");
       // get the first point (bottom-right) from the user 
       rightDownX = scan.nextInt();
       rightDownY = scan.nextInt();
       
       // calculations (incircle)
       diameter = leftUpY-rightDownY; 
       
       radius = diameter/2;
       area = Math.PI*radius*radius;
       perimeter = 2*Math.PI*radius;
       
       System.out.println("Incirlce: radius = " +radius +
       ", area = " + area + ", perimeter = " +perimeter);
       
       // calculations (Excircle)
       diameter = Math.sqrt(Math.pow((rightDownX - leftUpX),2) + Math.pow((rightDownY - leftUpY),2));
       
       radius = diameter/2;
       area = Math.PI*radius*radius;
       perimeter = 2*Math.PI*radius;
       
       System.out.println("Excircle: radius = " +radius +
       ", area = " + area + ", perimeter = " +perimeter);
           
    } // end of  method main
} // end of class Cricle