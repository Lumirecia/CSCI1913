class RunnyStack<Base>
{
    private class Run
    {
        private Base base;
        private Run next;
        private int length;
        
        public Run(Base base, Run next, int length)
        {
            this.base = base;
            this.next = next;
            this.length = length;
        }
        
    }
    private Run top;
    private int runs;
    private int length;
    public RunnyStack()
    {
        top = null;
        length = 0;
        runs = 0;
    }

    public int depth()
    {
        return length;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public Base peek()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is empty.");
        }
        else
        {
            return top.base;
        }
    }

    public void pop()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("Stack is empty.");
        }
        else
        {
            if(top.length > 1)
            {
                top.length--;
            }
            else
            {
                top = top.next;
                runs--;
            }
            length--;
        }   
    }
    public boolean isEqual(Base left, Base right)
    {
        if(left == null || right == null)
        {
            return left == right;
        }
        else
        {
            return left.equals(right);
        }
    }
    public void push(Base base)
    {
        if(top != null && isEqual(base, top.base))
        {
            top.length++;
        }
        else
        {
            top = new Run(base, top, 1);
            runs++;
        }
        length++;
    }
    public int runs()
    {
        return runs;
    }
}