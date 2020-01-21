//
//  SIEVE. The Sieve of Eratosthenes.
//
//    James B. Moen
//    08 Oct 19
//
//  Test the SIEVE class, for 30 points total.
//

class Sieve
{
    boolean[] numbers;
    public Sieve(int max)
    {
        if(max < 2)
        {
            throw new IllegalArgumentException("Max is less than 2.");
        }
        numbers = new boolean[max];
        for(int i = 0; i < 2; i++)
        {
            numbers[i] = false;
        }
        for(int i = 2; i < numbers.length; i++)
        {
            numbers[i] = true;
        }
    }

    public void findPrimes()
    {
        for(int i = 2; i < numbers.length; i++)
        {
            for(int j = i+1; j < numbers.length; j++)
            {
                if(j % i == 0)
                {
                    numbers[j] = false;
                }
            }
        }
    }

    public String toString()
    {
        String boop = "";
        for(int i = 0; i < numbers.length; i++)
        {
            if(numbers[i])
            {
                boop = boop + " " + i;
            }
            else
            {
                continue;
            }
        }
        return boop;
    }
}

//  TOSS THE KNEES. Run SIEVE on some examples.

class TossTheKnees
{

//  MAIN. Find some primes.

  public static void main(String [] args)
  {
    Sieve sieve = null;  //  We must initialize SIEVE or Java will cry.

//  5 points. This must print "Sieve size must be at least 2." but without the
//  quotes.

    try
    {
      sieve = new Sieve(0);
    }
    catch (IllegalArgumentException oops)
    {
      System.out.println("Sieve size must be at least 2.");
    }

//  5 points. This must print nothing.

    try
    {
      sieve = new Sieve(100);
    }
    catch (IllegalArgumentException oops)
    {
      System.out.println("Sieve size must be at least 2.");
    }

//  10 points. This must print integers from 2 to 99, separated by blanks.

    System.out.println(sieve);

//  10 points. This must print the prime numbers between 2 and 99, separated by
//  blanks. They are:
//
//  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

    sieve.findPrimes();
    System.out.println(sieve);
  }
}
