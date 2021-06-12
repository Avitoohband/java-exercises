/**
 * This class has array of 3d boxes.
 * it can add boxes and get information about them.
 *
 * @author (Avi Tuchband)
 * @version (04-13-19)
 */
public class Collection
{
   private Box3D[] _boxes; // boxes array
   private int _noOfBoxes; // number of boxes
   private final int MAX_NUM_BOXES = 100; // max cells per array
   /**
    * Default Constructor for the object of class Collection
   */
   public Collection()
   {
        _boxes = new Box3D[MAX_NUM_BOXES]; 
        _noOfBoxes = 0;
   }
   /**
    * Create and 3D box and add it into the array in the right order(volume-wise)
    * and return true. if there is no space to insert the box, return false
    * @param base The base point of a box
    * @param length represent the length
    * @param width represent the width
    * @param height represent the height
    * @return true if succeed to insert the box, false if doesn't.
    * 
   */
   public boolean addBox(Point3D base, int length, int width, int height)
   {      
       if(_noOfBoxes == _boxes.length)
           return false;
             
       if(_noOfBoxes == 0)
       {
           _boxes[_noOfBoxes++] = new Box3D(base,length,width,height);        
       }
       else
       {
           Box3D newBox = new Box3D(base,length,width,height); // the new box to be added
           for (int i = 0 ; i < _boxes.length ; i++)
           {
               if (_boxes[i] != null)
               {
                   if (_boxes[i].getVolume() < newBox.getVolume())
                    {
                         insertBox(newBox,i);
                         _noOfBoxes++;
                         break;
                    }
                }
               else 
               {
                   _boxes[i] = newBox;
                   _noOfBoxes++;
                   break;
               }
               
           }
       }
       return true;
   }
   /**
    * Insert the box into the array and shift right all the existing boxes.
    * @param newBox the box to be inserted into the array
    * @param index the place in the array to store the new box
   */
   public void insertBox(Box3D newBox, int index)
   {
     Box3D temp; // to temporary store a box
     for (int i = index ; i < _boxes.length ; i++)
     {
         temp = _boxes[i];
         _boxes[i] = newBox;
         newBox = temp;       
     }
   }
   /**
    * Return new box with the highest base corner in the array
    * @return new box with the most upper base corner from the array.
   */
   public Box3D mostUpperBaseCorner()
   { 
       int i; // what box to be returned
       if (_boxes == null)
       return null;
       else
       {
           i = checkUpperBaseCorner();
       }
       return new Box3D(_boxes[i]);
   }
   /**
    * Compare all the boxes to each other and return the cell number that
    * has the box with the most upper base corener
    * @return I - indicator of the cell that contain the box with the highest base corner
   */
   public int checkUpperBaseCorner()
   {
       int i = 0, j = i+1;
       while (j < _noOfBoxes)
       {
           if (_boxes[j].getBase().isAbove(_boxes[i].getBase()))
               i = j++;                 
           else
               j++;             
       }
       return i;
   }
   /**
    * Returns the total surface area of the all the boxes in the array
    * @return the sum of the total surface area from all the boxses in the array
   */
   public int totalSurfaceArea ()
   {
       int sumTotalSurfaceArea = 0 ;
       for (int i = 0 ; i < _noOfBoxes ; i++)
       {
           sumTotalSurfaceArea += _boxes[i].getSurfaceArea();
       }
       return sumTotalSurfaceArea;
   }
   /**
    * Return the longest distance between two center points from dfifferent boxes in the array
    * @return the longest distance between two center points in the array. 
    * if there is only 2 boxes, return 0  
   */
   public double longestDistance() 
   {
       int i,j ; // indexes for the for loup.
       double longestDis = 0 ; // to store the longest distace.
       if (_noOfBoxes < 2)
       return longestDis;
       else       
       {       
           for (i = 0 ; i < (_noOfBoxes -1) ; i++)
                for(j = i+1 ; j < _noOfBoxes ; j++)
                {
                   if (_boxes[i].getCenter().distance(_boxes[j].getCenter()) > longestDis)
                   longestDis = _boxes[i].getCenter().distance(_boxes[j].getCenter());            
                }
       }
       return longestDis;
   }
   /**
    * Gets a box and returns how many boxes in the array can contain it.
    * @param box the box to be checked if can be contained
    * @return the number of how many boxes can contain the given box
   */
   public int howManyContains(Box3D box)
   {
       int counter = 0;
       for (int i = 0 ; i < _noOfBoxes ; i++)
       {
           if (_boxes[i].contains(box)) 
           counter++;
       }
       return counter;
   }
   /**
    * Gets portion from an array and checks what is the smallest possible box that can contain
    * all of it boxes, than returns its volume.
    * @param indexI one side of the given portion
    * @param indexJ the other side of the given portion
    * @return the volume of the smallest possible box.
    * reutrn 0 if out of array limits. 
   */
   public int volumeOfSmallestBox(int indexI, int indexJ)
   {
       int length = 0, width = 0, height = 0;
       if (!(indexI>= 0 && indexI<_boxes.length && indexJ >0 && indexJ<=_boxes.length))
       return 0;
       int smallerIndex = (indexI < indexJ) ? indexI : indexJ; // the smaller index
       int biggerIndex = (indexI > indexJ) ? indexI : indexJ; // the bigger index
       {
           for (int i = smallerIndex; i <= biggerIndex ; i++)
           {
               if(_boxes[i] == null)
               {
                   return 0;
               }
               
                   if(_boxes[i].getLength() > length)
                   length = _boxes[i].getLength();
                   if(_boxes[i].getWidth() > width)
                   width = _boxes[i].getWidth(); 
                   if(_boxes[i].getHeight() > height)
                   height = _boxes[i].getHeight();
            }
        }
       return ((length+1)*(width+1)*(height+1));
   }
   /**
    * Returns an array in size of the actual boxes in the given array and copy its content
    * @return new array in size of the actual boxes in the given array and copy its content 
   */
   public Box3D[] getBoxes()
   {
       Box3D[] newArr = new Box3D[_noOfBoxes];
       int whereToInsert = 0;
       for (int i = 0 ; i < _boxes.length ; i++)
            if(_boxes[i] != null)
            {
            newArr[whereToInsert++] = new Box3D(_boxes[i]);            
            }
            
       return newArr;
   }
   /**
    * returns the number of boxes in the array
    * @return the number of boxes in the array
   */
   public int getNumOfBoxes()
   {
       return _noOfBoxes;
   }
    /**
     * Returns a string representation of this Box
     * @return String representation of this array.
     */ 
   public String toString()
   {
       String data = ""; // to be returned
       for (int i = 0 ; i < _boxes.length ; i++)
       {
           if (_boxes[i] != null)
           data += "Box no. " +i + ": " +_boxes[i] + "\n";
        }
       return data;
   }
   }