/**
 * This class represent 3D Point in the Cartesian system.
 * @param x The X coordinate 
 * @param y The Y coordinate
 * @param z The Z coordinate
 * @author (Avi Tuchband)
 * @version (03-27-19)
 */
public class Point3D
{
    // instance variables - represent the (x,y,z) coordinations
    private double _x;
    private double _y;
    private double _z;

    //Constructors
    /**
     * Defaul Constructor for objects of class Point3D
     */
    public Point3D()
    {// initialise instance variables to 0.0
    }// end of Default Constructor
    /**
     * Initiative Cunstructor that gets 3 params and set the x,y,z coordinates
     */
    public Point3D (double x,double y,double z)
    {
        _x = x;
        _y = y;
        _z = z;
    }// end of Initiative Constructor
    /**
     * Copy Constructor
     * @param other to be copied
     */
    public Point3D (Point3D other)
    {
        _x = other._x;
        _y = other._y;
        _z = other._z;
    }
       
    //Methods    
    /**
     * Get the X Method.
     *
     * @param x The X coordinate 
     * @return the values that represent the X coordinate
     */
    public double getX()
    {
        // get the X coordinate
        return _x;
    }// end of getX
     /**
     * Get The Y Method.
     *
     * @param y The Y coordinate 
     * @return the values that represent the Y coordinate
     */
    public double getY()
    {
        // get the Y coordinate
        return _y;
    }// end of getY
     /**
     * Get The Z Method.
     *
     * @param z The Z coordinate 
     * @return the values that represent the Z coordinate
     */
    public double getZ()
    {
        // get the Z coordinate
        return _z;
    }// end of getZ
    /**
     * Set The X Method.
     */
    public void setX(double num)
    {
        // set the X coordinate
        _x = num;
    }// end of setX
      /**
     * Set The Y Method.
     */
    public void setY(double num)
    {
        // set the Y coordinate
        _y = num;
    }// end of setY
      /**
     * Set The Z Method.
     */
    public void setZ(double num)
    {
        // set the Z coordinate
        _z = num;
    }// end of setZ
    /**
     * Returns a string representation of this Point
     * @return String representation of this Point
     */
    public String toString()
    {
        return "(" + _x + "," + _y + "," + _z + ")";
    }
    /**
     * Compare between two obejects and return a booleab value respectively
     * @param other to compare with
     * @return true if equals and false if not equals
     */
    public boolean equals (Point3D other)
    {
        return (other._x == _x && other._y == _y && other._z == _z);
    }
    /**
     * Check if higher then a given point
     * @param y the Y coordinate (represent the height)
     * @return true if higher, false if lower
     */
    public boolean isAbove(Point3D other)
    {  
        return other._z < _z;
    }
    /**
     * Check if lower then a given point
     * @param y the Y coordinate (represent the height)
     * @return true if lower, false if higher
     */
    public boolean isUnder(Point3D other)
    { 
        return other.isAbove(this);
    }
    /**
     * Check if is left to a given point
     * @param x the X coordinate
     * @return true if left to, false if right to
     */
    public boolean isLeft(Point3D other)
    {
        return other._x > _x;
    }
    /**
     * Check if is right to a given point
     * @param x the X coordinate
     * @return true if right to, false if left to
     */    
    public boolean isRight(Point3D other)
    {
        return other.isLeft(this);
    }
    public boolean isBehind(Point3D other)
    {
        return other._z > _z;
    }
    public boolean isInFrontOf(Point3D other)
    {
        return other.isBehind(this);
    }
    /**
     * Move the x,y,z coordinates by dx,dy,dz
     * @param dx added to the X coordinate
     * @param dy added to the Y coordinate
     * @param dz added to the Z coordinate
     */
    public void move(double dx, double dy, double dz)
    {
        setX(_x+dx);
        setY(_y+dy);
        setZ(_z+dz);
    }
    /**
     * Checks the distance between  this point and p 
     * @param p to check the distance between this point to p
     * @return the distance between this point and p 
     */
    public double distance (Point3D p) 
    {
        return Math.sqrt(Math.pow(_x - p._x,2)+Math.pow(_y - p._y,2)+Math.pow(_z - p._z,2));
    }
}// end of class
