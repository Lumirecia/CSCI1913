class Polygon 
{ 
  private int[] sideLengths; 
 
  public Polygon(int sides, int ... lengths) 
  { 
    int index = 0; 
    sideLengths = new int[sides]; 
    for (int length: lengths) 
    { 
      sideLengths[index] = length; 
      index += 1; 
    } 
  } 
     
  public int side(int number) 
  { 
    return sideLengths[number]; 
  } 
     
  public int perimeter() 
  { 
    int total = 0; 
    for (int index = 0; index < sideLengths.length; index += 1) 
    { 
      total += side(index); 
    } 
    return total; 
  } 
}

class Rectangle extends Polygon
{
    private int[] sideLengths;
    
    public Rectangle(int a, int b)
    {
        super(4, a, b, a, b);
    }
    public int area()
    {
        return super.side(0) * super.side(1);
    }
}

class Square extends Rectangle
{
    private int[] sideLengths;
    public Square(int a)
    {
        super(a, a);
    }
}