class BinaryVsLinear
{

    private static int linearSearch(int key, int[] keys)
    {
        int count = 0;
        for (int i = 0; i < keys.length; i++)
        {
            if(key == keys[i])
            {
                return count+1;
            }
            else
            {
                count++;
            }
        }
        return count;
    }

    private static int binarySearch(int key, int[] keys)
    {
        int left = 0;
        int mid;
        int right = keys.length - 1;
        int count = 0;
        while (true)
        {
            if (left > right)
            {
                mid = -1;
                break;
                // can't write this way cuz java sucks
                // return -1;
            }

            else
            {
                mid = (left + right) / 2;
                if (key < keys[mid])
                {
                    right = mid - 1;
                    count ++;
                }
                else if (key > keys[mid])
                {
                    left = mid + 1;
                    count++;
                }
                else
                {
                    break;
                    // can't write this way cuz java sucks
                    // return mid;
                }
            }
        }
        return count+1;
    }

    public static void main(String[] args)
    {
        for (int length = 1; length <= 30; length += 1)
        {
            int[] array = new int[length];
            for (int index = 0; index < length; index += 1)
            {
                array[index] = index;
            }

            double linearTotal = 0.0;
            double binaryTotal = 0.0;
            for (int element = 0; element < length; element += 1)
            {
                linearTotal += linearSearch(element, array);
                binaryTotal += binarySearch(element, array);
            }

            double linearAverage = linearTotal / length;
            double binaryAverage = binaryTotal / length;
            System.out.println(length + " " + linearAverage + " " + binaryAverage);
        }
    }
}
