
class Zillion
{
    private int[] array;
    public Zillion(int size)
    {
        array = new int[size];
    }

    public void increment()
    {
        int i = array.length - 1;
        while(true)
        {
            if(array[i] < 9)
            {
                array[i]++;
                break;
            }
            else if(array[i] == 9)
            {
                array[i] = 0;
                i--;
                if(i < 0)
                {
                    break;
                }
            }
        }
    }

    public String toString()
    {
        String output = new String();
        for(int n : array)
        {
            output+=n;
        }
        return output;
    }
}
