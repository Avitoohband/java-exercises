import java.util.Scanner;

public class IntListTwo
{
    final static int READ_LIST_STOP_INT = -9999;

    private IntNodeTwo _head, _tail;

    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }

    public IntListTwo(IntNodeTwo h, IntNodeTwo t)
    {
        _head = h;
        _tail = t;
    }

    /**
     * Create node with the given num  and put it in its place in the list(sorted list)
     * @param num The number to be the value of the node
     */
    public void addNumber(int num)
    {
        IntNodeTwo nodeToAdd = new IntNodeTwo(num);

        IntNodeTwo curr;
        for(curr = _head ; curr != null && num >= curr.getNum(); curr = curr.getNext()) {

        }

        if(curr == null)
        {
            addToTail(nodeToAdd);
        } else { // num < curr.getNum()
            addBefore(curr, nodeToAdd);
        }
    }

    public boolean isEmpty()
    {
        return _head == null;
    }

    /**
     * Find and remove node from the list with the given number
     * @param num The value of the node to be removed
     */
    public void removeNumber(int num)
    {
        IntNodeTwo nodeToRemove;
        nodeToRemove = getNodeWithValue(num);

        if (nodeToRemove != null) {
            removeNumber(nodeToRemove);
        }
    }

    /**
     * Gets values and create sorted list.
     */
    public void readToList()
    {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        while (num != READ_LIST_STOP_INT)
        {
            addNumber(num);
            num = scanner.nextInt();
        }
    }

    @Override
    /**
     * Returns string that represent the list
     * @return String representation of the list
     */
    public String toString()
    {
        String stringToReturn = "{";
        IntNodeTwo node;

        for(node = _head ; node != null ; node = node.getNext())
        {
            stringToReturn += node.getNum();
            if (node.getNext() != null)
            {
                stringToReturn += ", ";
            }

        }
        stringToReturn += "}";

        return stringToReturn;
    }

    /**
     * Returns the length of the list
     * @return The length of the list
     */
    public int length()
    {
        int counter = 0;
        IntNodeTwo node;
        for(node = _head ; node != null ; node = node.getNext())
        {
            counter++;
        }
        return counter;
    }

    /**
     * Returns the sum of the valuse of the list
     * @return The sum of the valuse of the list.
     */
    public int sum()
    {
        int sum = 0;
        IntNodeTwo node;
        for(node = _head ; node != null ; node = node.getNext())
        {
            sum += node.getNum();
        }
        return sum;
    }

    /**
     * Returns the length of the longest even-sum sub- array in the list.
     * Time Complexity O(n)
     * Auxiliary space O(1)
     * @return the length of the longest even-sum sub- array in the list.
     */
    public int maxLength() {
        int sum = 0;
        int maxLength = 0;
        IntNodeTwo lo, hi;
        int loIndex, hiIndex;

        //calculate the sum of the whole ist
        for(hiIndex = 0, lo = _head; lo != null; lo = lo.getNext(), hiIndex++) {
            sum += lo.getNum();
        }
        // check if the whole list is even
        if(sum % 2 == 0)
        {
            maxLength = hiIndex;
        }
        else
            {
            loIndex = 0;
            lo = _head;
            hi = _tail;
            hiIndex--;
            boolean maxLengthFound = false;
            // looking for the ood numbers that makes the list odd.
            while(!maxLengthFound)
            {
                if (hi.getNum() % 2 == 1 || lo.getNum() % 2 == 1)
                {
                    maxLength = hiIndex;
                    maxLengthFound = true;
                } else {
                    loIndex++;
                    lo = lo.getNext();
                    hiIndex--;
                    hi = hi.getPrev();
                }
            }
        }

        return maxLength;
    }

    /**
     * Gets nubmer and checks if there is sub array that its average equal the given number.
     * Time Complexity O(n)
     * Auxiliary space O(1)
     * @param num  The number to be compared to the averages.
     * @return true found equaled average. false if didn't.
     */
    public boolean isAverage(double num)
    {
        if(isEmpty()) // there is no sub-arrays
        {
            return false;
        }
        int listLength = length();
        int loIndex, hiIndex;
        IntNodeTwo lo, hi;

        // run to middle of list
        for(loIndex = 0, hiIndex = 0, lo = _head, hi = _head; loIndex < listLength / 2; loIndex++, hiIndex++, lo = lo.getNext(), hi = hi.getNext()) {

        }

        double sum = lo.getNum();
        double average = sum;
        boolean keepChecking = true;

        while(keepChecking) {
            if(average == num) {
                keepChecking = false;
            } else if(average > num){
                if(loIndex > 0) {
                    loIndex--;
                    lo = lo.getPrev();
                    sum += lo.getNum();
                } else if(hiIndex > 0) {
                    sum -= hi.getNum();
                    hiIndex--;
                    hi = hi.getPrev();
                } else {
                    keepChecking = false;
                }
            } else { // average < num
                if(hiIndex < listLength - 1) {
                    hiIndex++;
                    hi = hi.getNext();
                    sum += hi.getNum();
                } else if(loIndex < listLength - 1) {
                    sum -= lo.getNum();
                    loIndex++;
                    lo = lo.getNext();
                } else {
                    keepChecking = false;
                }
            }

            average = sum / (hiIndex - loIndex + 1);
        }

        return average == num;
    }

    /**
     * Add node with value to the list from the right side.
     * @param node To add before this node.
     * @param nodeToAdd The node to be added .
     */
    private void addBefore(IntNodeTwo node, IntNodeTwo nodeToAdd)
    {
        if(node == _head)
        {
            addToHead(nodeToAdd);
        }
        else
            {
            // add in middle of list
            nodeToAdd.setNext(node);
            nodeToAdd.setPrev(node.getPrev());
            node.getPrev().setNext(nodeToAdd);
            node.setPrev(nodeToAdd);
        }
    }

    /**
     * Add node with value to be the new head of the list.
     * @param nodeToAdd The node to be added.
     */
    private void addToHead(IntNodeTwo nodeToAdd)
    {
        if(isEmpty())
        {
            addToEmptyList(nodeToAdd);
        }
        else
            {
                // list is not empty
            _head.setPrev(nodeToAdd);
            nodeToAdd.setPrev(null);
            nodeToAdd.setNext(_head);
            _head = nodeToAdd;
        }
    }

    /**
     * Add node with value to be the new tail of the list.
     * @param nodeToAdd To node to be added.
     */
    private void addToTail(IntNodeTwo nodeToAdd) {
        if(isEmpty()) {
            addToEmptyList(nodeToAdd);
        } else { // list is not empty
            _tail.setNext(nodeToAdd);
            nodeToAdd.setPrev(_tail);
            nodeToAdd.setNext(null);
            _tail = nodeToAdd;
        }
    }

    /**
     * Add node with value to an empty list
     * @param nodeToAdd The node to be added.
     */
    private void addToEmptyList(IntNodeTwo nodeToAdd) {
        _head = _tail = nodeToAdd;
        nodeToAdd.setNext(null);
        nodeToAdd.setPrev(null);
    }

    /**
     * Find node in the list
     * @param num The value to be compare if there is one in the list.
     * @return The asked node if there is one.
     */
    private IntNodeTwo getNodeWithValue(int num)
    {
        IntNodeTwo node;

        for(node = _head ; node != null && node.getNum() != num ; node = node.getNext())
        {
        }

        return node;
    }

    /**
     * Remove ndoe from the list(assuming that the node is already exiting in the current list).
     * @param nodeToRemove The node to be removed.
     */
    private void removeNumber(IntNodeTwo nodeToRemove)
    {
        if(nodeToRemove.getPrev() != null)
        {
            nodeToRemove.getPrev().setNext((nodeToRemove.getNext()));
        } else
            {
            _head = nodeToRemove.getNext();
        }

        if(nodeToRemove.getNext() != null)
        {
            nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
        } else
            {
            _tail = nodeToRemove.getPrev();
        }
    }
}