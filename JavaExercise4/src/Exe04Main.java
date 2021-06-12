/**
 * This program has few functions of EX14. every function will be explained in the
 * API DOC.
 *
 * @author Avi Tuchband
 * @version (30/05/2019)
 */

public class Exe04Main
{

    public static void main(String[] args)
    {

        int[] heights = {2, 1, 1, 4, 1, 1, 2, 3};
        System.out.println("max water trapping capcity :" + waterVolume(heights));
       System.out.println(solutions(3));

        int arr[] = {3,1,1,3,2,2,1};
        System.out.println(arr.length);
        int n = arr.length;
        System.out.println(what(arr));

        int mat[][] =  { {2,41,3,14},
                        {2,1,24,7},
                        {2,15,10,54},
                        {63,22,2,4}};
        int path[][] = {{0},{0}};
        System.out.print(findSum(mat,4,path));



    }

    /**
     * Question No 1
     * A function that calculate how many units of water a tool(array) can trap.
     * <p>
     * Time Complexity = O(n)
     * Auxiliary Space = O(n)
     *
     * @param heights the array the to trap the rain.
     * @return number of units of water that it can trap.
     */
    public static int waterVolume(int[] heights) {
        int result = 0, leftMax = 0, rightMax = 0;
        int from = 0, to = heights.length - 1;

        while (from <= to) {
            if (heights[from] < heights[to]) {
                if (heights[from] > leftMax) {
                    leftMax = heights[from++];
                } else {
                    result += leftMax - heights[from++];
                }
            } else {
                if (heights[to] > rightMax) {
                    rightMax = heights[to--];
                } else {
                    result += rightMax - heights[to--];
                }
            }

        }

        return result;
    }

    /**
     * Question No 3
     * this function give all possbile 3 variables equations of a given number and returns how many equations
     * @param num - represent the number to check
     * @return number of possbile equations
     */
    public static int solutions(int num)
    {
        // check if numbers in the available limits
        if (num < 3 || num > 30)
            return 0 ;

        return solutions(num, 1, 1, 1);
    }

    /**
     * this fun sum the 3 variable together and compare to the given number, if equals count as a possible equation
     * if not , increment the variable one by one.
     * @param num - represent the number to check
     * @param x1 - variable number 1
     * @param x2 - variable number 2
     * @param x3 - variable number 3
     * @return number of possbile equations
     */
    private static int solutions(int num, int x1, int x2, int x3)
    {
        int counter = 0;

        //check of sum is equal to the given number
        if (x1 + x2 + x3 == num)
        {
            System.out.println(x1 + " + " + x2 + " + " + x3);
            counter++;
        }
        //after increment all the variable we need to make sure that it wont exceed from the limits.
        // these are 3 "if" for.

        if (x1 > 0 && x1 < 10 )
            return counter + solutions(num, x1 + 1, x2, x3);

         else
            x1 = 1;
        if (x2 > 0 && x2 < 10 )
            return counter + solutions(num, x1 , x2+1, x3);
        else
        {
            x1 = x2 = 1;
        }
        if (x3 > 0 && x3 < 10 )
            return counter + solutions(num , x1 , x2 , x3+1);

        return counter;
    }

    /**
     * Question No 2
     * Old what function :
     * Time Complexity = O(n^3)
     * Auxiliary Space = O(n)
     *
     * New what function :
     * this fun checks the longest even sum sub array and returns its length.
     * Time Complexity = O(n)
     *  Auxiliary Space = O(n)
     * @param a - the array to check
     * @return legnth of the biggest even sum sub array
     */
    public static int what(int a[])
    {
        int sum = 0, length = 0;

        // check if the whole array is even to begin with
        for (int i = 0; i < a.length; i++)
            sum += a[i];

        //if already even - returns the array length.
        if (sum % 2 == 0)
            return a.length;

        // find  the longest [start of sub-array]odd to [end of sub-array]odd numbers, odd + odd = even.
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] % 2 == 1)
            {
                length = Math.max(length, Math.max(a.length - i - 1, i));
            }
        }

        return length;
    }

    /**
     * This function get Matrix and find possbile path with a given sum of num,
     * then it print the numbers of pathes and return true if found a path or false if didn't.
     *
     * @param mat - the matrix with to check
     * @param sum - sum to find
     * @param path - a matrix to mark the cells that are components of a road.
     * @return true if found at least 1 path, false if it didn't find at all.
     */
    public static boolean findSum(int[][] mat ,int sum, int[][] path)
    {
        //calling the overloading function with 2 initiated indexes.
        return findSum(mat, sum , path, 0, 0);
    }
    private static boolean findSum(int[][] mat, int sum, int[][] path, int i, int j)
    {
        //check if in arrays limits (stop condition)
        if (i < 0 || i > mat.length)
            return false;
        //mat is nxn so , the length is fixed. checks if not the last cell in the row.
        if (j < mat[0].length - 1)
            return findSum(mat, sum, path, i, j + 1);
            // the last cell in the row
        else
            return findSum(mat, sum, path, i + 1, 0);
    }

    /**
     *this function check if the allowed directions in the array limits and
     * then compare to the given sum.
     * @param mat - the matrix with to check
     * @param sum - sum to find
     * @param path - a matrix to mark the cells that are components of a road.
     * @param i - index of rows
     * @param j - index of columns
     * @return true if find a good path.
     */
    private static boolean checkSum(int[][] mat, int sum, int[][] path, int i , int j)
    {
        boolean up, down , left, right;
        // stop contidion
        if (sum == 0)
            return true;
        //check if in arrays limits or if it allready has been marked with 1.
        if(i < 0 || i > mat.length || j < 0 || j > mat.length || path[i][j] == 1)
            return false;

        // initiate to 1
        path[i][j] = 1;
        up = down = left = right = false;

        // move the cursor in the allowed directions
        if (i > 0)
            up = checkSum(mat,sum-mat[i][j],path,i-1,j);
        if(i < mat.length)
            down = checkSum(mat, sum-mat[i][j], path,i+1,j);
        if (j > 0)
            left = checkSum(mat, sum-mat[i][j], path,i,j-1);
        if (j < mat.length)
            right = checkSum(mat, sum-mat[i][j], path,i,j+1);


        if (up && down && left  && right )
            return true;
        else
        {
            path[i][j] = 0;
            return false;
        }
    }
}
