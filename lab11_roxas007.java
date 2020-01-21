
//  OBSERVATION DEQUE. Test the class DEQUE. 40 points total.

class ObservationDeque
{

    //  MAIN. Test the DEQUE on various example arguments.

    public static void main(String [] args)
    {
        Deque<String> deque = new Deque<String>();

        System.out.println(deque.isEmpty());       // true                2 points.

        try
        {
            System.out.println(deque.dequeueFront());
        }
        catch (IllegalStateException ignore)
        {
            System.out.println("No dequeueFront.");  //  No dequeueFront.   2 points.
        }

        try
        {
            System.out.println(deque.dequeueRear());
        }
        catch (IllegalStateException ignore)
        {
            System.out.println("No dequeueRear.");   //  No dequeueRear.    2 points.
        }

        //  Enqueueing to the rear and dequeueing from the rear makes the DEQUE act
        //  like a stack.

        deque.enqueueRear("A");
        deque.enqueueRear("B");
        deque.enqueueRear("C");

        System.out.println(deque.isEmpty());       //  false              2 points.

        System.out.println(deque.dequeueRear());   //  C                  2 points.
        System.out.println(deque.dequeueRear());   //  B                  2 points.
        System.out.println(deque.dequeueRear());   //  A                  2 points.

        System.out.println(deque.isEmpty());       //  true               2 points.

        //  Enqueueing to the rear and dequeueing from the front makes the DEQUE act
        //  like a queue.

        deque.enqueueRear("A");
        deque.enqueueRear("B");
        deque.enqueueRear("C");

        System.out.println(deque.dequeueFront());  //  A                  2 points.
        System.out.println(deque.dequeueFront());  //  B                  2 points.
        System.out.println(deque.dequeueFront());  //  C                  2 points.

        System.out.println(deque.isEmpty());       //  true               2 points.

        //  Enqueueing to the front and dequeueing from the front makes the DEQUE act
        //  like a stack.

        deque.enqueueFront("A");
        deque.enqueueFront("B");
        deque.enqueueFront("C");

        System.out.println(deque.dequeueFront());  //  C                  2 points.
        System.out.println(deque.dequeueFront());  //  B                  2 points.
        System.out.println(deque.dequeueFront());  //  A                  2 points.

        System.out.println(deque.isEmpty());       //  true               2 points.

        //  Enqueueing to the front and dequeueing from the rear makes the DEQUE act
        //  like a queue.

        deque.enqueueFront("A");
        deque.enqueueFront("B");
        deque.enqueueFront("C");

        System.out.println(deque.dequeueRear());   //  A                  2 points.
        System.out.println(deque.dequeueRear());   //  B                  2 points.
        System.out.println(deque.dequeueRear());   //  C                  2 points.

        System.out.println(deque.isEmpty());       //  true               2 points.
    }
}

class Deque<Base>
{
    class Node 
    {
        private Base object;
        private Node left;
        private Node right;

        private Node(Base object, Node left, Node right)
        {
            this.object = object;
            this.left = left;
            this.right = right;
        }
    }
    private Node head;
    
    public Deque() 
    {
        head = new Node(null, null, null);
        head.left = head;
        head.right = head;
    }

    public void enqueueFront(Base object) // add to front of deque. object of new node
    // points to param object
    {
        Node currentFront = head.left;
        currentFront.right = new Node(object, currentFront, head);
        currentFront.right.right.left = currentFront.right;
    }

    public void enqueueRear(Base object) 
    {
        Node currentRear = head.right;
        currentRear.left = new Node(object, head, currentRear);
        currentRear.left.left.right = currentRear.left;
    }

    public Base dequeueFront() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Deque is Empty.");
        } 
        else 
        {
            Node currentFront = head.left;
            Base temp = currentFront.object;
            currentFront.left.right = head;
            currentFront.right.left = currentFront.left;
            return temp;
        }
    }

    public Base dequeueRear() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Deque is Empty.");
        } 
        else 
        {
            Node currentRear = head.right;
            Base temp = currentRear.object;
            currentRear.right.left = head;
            currentRear.left.right = currentRear.right;
            return temp;
        }
    }

    public boolean isEmpty() 
    {
        return (head.right == head && head.left == head);
    }
}


/* output
 true
No dequeueFront.
No dequeueRear.
false
C
B
A
true
A
B
C
true
C
B
A
true
A
B
C
true
*/