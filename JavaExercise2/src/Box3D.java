/**
 * This class create 3D Box, it can get it's ,change it's values and comapre between Boxes
 *
 * @author (Avi Tuchband)
 * @version (03-27-19)
 */
public class Box3D
{
    // instance variables - replace the example below with your own
    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;
    private final int  DEFAULT_VAL = 0;
    private final int INITIATE_VAL = 1;    
    //Constructors
    
   
    /**
     * Default Constructor for objects of class Box3D
     */
    public Box3D() 
    {
        _base = new Point3D();
        _length = INITIATE_VAL;
        _width = INITIATE_VAL;
        _height = INITIATE_VAL;  
    }
    /**
     * Cunstructor to initiate obejcts with given values
     * @param length Represent the Lenght 
     * @param width Represent the Width
     * @param height Represent the Height
     */
    public Box3D(Point3D p1, int length/* X */, int width/* Y */, int height/* Z */)
    {
        _base = new Point3D(p1);
        _length = (length > DEFAULT_VAL) ? length : INITIATE_VAL;
        _width = (width > DEFAULT_VAL) ? width : INITIATE_VAL;
        _height = (height > DEFAULT_VAL) ? height : INITIATE_VAL;
    }    
    /**
     * Copy Cunstructor
     * @param other Bese point to be copied
     * @param length Lenght  to be copied
     * @param width Width to be copied
     * @param height Height to be copied
     */
        public Box3D(Box3D other) 
    {
        
        _base = new Point3D(other.getBase());
        _length = other._length;
        _width = other._width;
        _height = other._height;
    }
    
    //Methods 
    /**
     * Get the Base Point Method.
     *
     * @param base The Base Point coordinates 
     * @return the values that represent the base point coordinate
     */   
    public Point3D getBase() 
    {
        return new Point3D(_base);
    }
    /**
     * Get the Length Method.
     *
     * @param length represent the Length  
     * @return the values that represent the length
     */       
        public int getLength()
    {
        return _length;
    }
    /**
     * Get the Width Method.
     *
     * @param width represent the Width  
     * @return the values that represent the width
     */    
        public int getWidth()
    {
        return _width;
    }
    /**
     * Get the Height Method.
     *
     * @param length represent the Height  
     * @return the values that represent the height
     */    
        public int getHeight()
    {
        return _height;
    }
    /**
     * Set The Base Point Method.
     */
    public void setBase(Point3D p)
    {
        _base = new Point3D(p);
    }
    /**
     * Set The Length Method.
     */    
    public void setLength(int num)
    {
        
        _length = (num > DEFAULT_VAL) ? num : INITIATE_VAL;
    }
    /**
     * Set The Width Method.
     */
    public void setWidth(int num)
    {
       
        _width =  (num > DEFAULT_VAL) ? num : INITIATE_VAL;
    }
    /**
     * Set The Height Method.
     */
    public void setHeight(int num)
    {   
        _height = (num > DEFAULT_VAL) ? num : INITIATE_VAL;
    }
    /**
     * Returns a string representation of this Box
     * @return String representation of this Box
     */    
    public String toString()
    {
        return "The base point is "  + _base.toString() + ", length = " + _length + ", width = " + _width + ", height = " + _height; 
        
    }
    /**
     * Returns if the two compared Boxes are equals
     * @param other to be compared 
     * @return True if boxes are equals or false if not equals.
     */
    public boolean equals (Box3D other)
    {
        return ((other._base.equals(_base)) && (other._length == _length) && (other._width == _width) && (other._height == _height));
    }
    /**
     * sums the old values of a point  with the new values and returns a new Box with the new point.
     * @param dx to be added to X
     * @param dy to be added to Y
     * @param dz to be added to Z
     * @return new Box with the new point.
     */
    public Box3D move (double dx, double dy, double dz)
    {
        Point3D newPoint = new Point3D(_base);
        newPoint.move(dx,dy,dz);
        return new Box3D(newPoint,_length,_width,_height);
    }
    /**
     * calcualte the up right back point and returns it as an Point3D object
     * @return The up right back point 
     * @return the up right back point of the Box
     */    
    public Point3D getUpRightBackPoint()
    {
        //  -x, +y, +z
        return new Point3D(_base.getX() - _length,_base.getY() + _width, _base.getZ() + _height); 
    }
    /**
     * Returns the center point values of the Box
     * @param center the center point to be returned
     * @param newLen to be calculated with
     * @param newWid to be calculated with
     * @param newHei to be calculated with
     * @return the center point of the Box
     */
    public Point3D getCenter()
    {
        Point3D center = new Point3D(this._base);
        double newLen = _length;
        double newWid = _width;
        double newHei = _height;
        center.setX(_base.getX() - (newLen/2));
        center.setY(center.getY() + (newWid/2));
        center.setZ(center.getZ() + (newHei/2));
        return center;
    }
     /**
     * calculates by using a distance method (of Point3D class and returns its value.
     * @return the distance between the two different center points.
     */
    public double distance (Box3D other)
    {
        return (other.getCenter().distance(this.getCenter()));
    }
    /**
     * Calculates and returns the valuse of the Surface area of a Box.
     * @return the surface area of the Box.
     */
    public int getSurfaceArea()
    {
        return (2*(_length*_width + _length*_height + _width*_height));
    }
    /**
     * Calculates and returns the Volume of a Box.
     * @return the volume of the Box.
     */
    public int getVolume()
    {
        return (_length*_width*_height);
        
    }
    /**
     * Checks if the Box has larger capacity then the other Box returns boolean value respectivly.
     * @return true if it has larger capacity and false if it doesn't.
     */
    public boolean isLargerCapacity(Box3D other)
    {
        return (other.getVolume() < this.getVolume());
    }
    /**
     * Checks if the Box can contain the other Box buy checking if the measurements of the Boxes.
     * @param other to be checked if can be contained.
     * @return true if can contain "other", false if it doesn't.
     */
    public boolean contains (Box3D other)
    {
       return ((other._length < _length) && (other._width < _width) && (other._height < _height));
    }
    /**
     * Checks if the Box is above the other Box and return boolean value respectivly.
     * @param other to be checked if below the Box
     * @param p1 to store the up right back point values
     * return true if above "other", false if it doesn't.
     */    
    public boolean isAbove (Box3D other)
    {
        Point3D p1 = new Point3D(other.getUpRightBackPoint());        
        return (_base.isAbove(p1));
    }
    
}// end of class
