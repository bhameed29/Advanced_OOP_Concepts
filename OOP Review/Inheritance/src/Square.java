import java.util.Objects;
public class Square extends Shape
{
    private double side;

    public Square(double side, String name)
    {
        super(name);
        this.side = side;
    }

    @Override
    public double getArea() {return side * side;}

    @Override
    public double getPerimeter() {return side * 4;}

    @Override
    public boolean equals(Object object)
    {
        if (object == null && !(object instanceof Square))
            return false;
        Square obj = (Square) object;
        if(this.side == obj.side && this.name.equals(obj.name))
            return true;
        return false;
    }

    @Override
    public String toString() {return this.name + ":" + this.side;}
}