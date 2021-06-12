/**
 * This class builds a Matrix from a two-demensional array
 * and can do some sort of actions with it .
 * @author (Avi Tuchband)
 * @version (04-17-19)
 */
public class Matrix
{
    private int[][] _array; // the two-dimesional array
    
    private final int highestValue = 255; // the biggest value that can be.
    /**
     * The Constructor of obejct from the Matrix class 
     * construct in the sizes of the two- dimesional array
     * and copy its content into the Matrix
     */  
    public Matrix(int[][] array) 
    {
        _array = new int[array.length][]; // the new array
        
        for (int i= 0 ; i < array.length ; i++)
        {
            _array[i] = new int[array[i].length];
            for (int j = 0 ; j < _array[i].length ; j++)
                _array[i][j] = array[i][j];
        }              
    }
    /**
     * Consruct a Matrix in the given sizes and fill it with zeroes
     * @param size1 the number of rows
     * @param size2 the number of columns
     */ 
    public Matrix(int size1, int size2)
    {
        _array = new int [size1][size2]; // the new array 
        initiateZeroes();
    }
    /**
     * Initiate the Matrix with zeros
     *
     */
    public void initiateZeroes()
    {
        for (int i = 0 ; i < _array.length ; i++)
            for(int j = 0 ; j < _array[i].length ; j++)
                _array[i][j] = 0;
    }
    /**
     * Returns a String representation of the MATRIX
     * @return String representation of the Matrix
     */
    public String toString()
    {
        String newString = ""; // the string to be retruned.
        for (int i = 0  ; i < _array.length ; i++)
            {
                for (int j = 0 ; j < _array[i].length ; j++)
                     newString += _array[i][j] + "\t";                    
                newString += "\n";     
            }            
        return newString;
    }
    /**
     * Returns new Matrix with the coplement to 255 of each value
     * @return new Matrix witht the complement to 255 of each value
     */
    public Matrix makeNegative()
    {
        Matrix newM = new Matrix(_array); // new Matrix to be returned.
        for (int i = 0 ; i < _array.length ; i++)
             for (int j = 0 ; j< _array[i].length ; j++)
                {
                    newM._array[i][j] = Math.abs(_array[i][j] - highestValue);
                }
        return newM;
    }
    /**
     * Returns new filtered Matrix, calculating the average of the sorrouding neighbors.
     * @return new Matrix with the average of evey values with its sorrouding neighbors.
     */
    public Matrix imageFilterAverage()
    {     
        Matrix newM = new Matrix(_array); // the new Matrix to be returned.        
        for (int i = 0 ; i < _array.length ; i++)
        {          
            for (int j = 0 ; j < _array[i].length ; j++)
            {
               newM._array[i][j] = newAverage(i,j);
            }
        }
        return newM;
    }
    /**
     * Gets cell from an array and returns its average with its sorrouding neighbors
     * @param rows indicatior 
     * @param columns indicator
     * @return the given value's average with its sorrouding neighbors
     */
    public int newAverage(int indexI, int indexJ)
    {
        int sum = 0 , divider = 0;
        for(int i = indexI-1 ; i <= indexI+1 ; i++)
        {
            for(int j = indexJ-1 ; j <=indexJ +1 ; j++)
                {
                    if(isInArrayLimits(i,j))
                        {
                            sum += _array[i][j];
                            divider++;
                        }
                }
        }
        return (sum/divider);
    }  
    /**
     * Checks if the cell exsisting in the array limits
     * @param i in which row 
     * @param j in which col
     * @return true if exist, false if it doesn't
    */
    public boolean isInArrayLimits(int i, int j)
    {
        if (i > -1 && i < _array.length && j > -1 && j < _array[i].length)
            return true;
        return false;
    }
    /**
     * Returns a rotated 90 digrees to the right Matrix,
     * switches its dimensions sizes if needed  
     * @return rotated 90 digrees to the right Matrix
    */
    public Matrix rotateClockwise()
    {
        int newRow = _array[0].length;
        int newCol = _array.length;
        Matrix rotated90Right = new Matrix(newRow,newCol);       
        for (int i = 0 ; i < _array.length ; i++)
            for (int j = 0 ; j < _array[i].length ; j++)
                {
                    rotated90Right._array[j][newCol-1-i] = _array[i][j];
                }
        return rotated90Right;        
    }
    /**
     * Returns a rotated 90 digrees to the left Matrix,
     * switches its dimensions sizes if needed  
     * @return rotated 90 digrees to the left Matrix
    */
    public Matrix rotateCounterClockwise()
    {
        int newRow = _array[0].length;
        int newCol = _array.length; 
        Matrix rotated90Left = new Matrix(newRow,newCol);
        for (int i = 0 ; i < _array.length ; i++)
            for (int j = 0 ; j < _array[i].length ; j++)
                {
                    rotated90Left._array[newRow-1-j][i] = _array[i][j];
                }
        return rotated90Left;
    }

}
