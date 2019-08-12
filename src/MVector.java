public class MVector
{
    public int limit;
    MVector np;

    float x,y;
    public MVector(MVector parent)
    {
        this.x = parent.x;
        this.y = parent.y;
    }

    public MVector(float x,float y)
    {
        this.x = x;
        this.y = y;
    }

    public MVector revert()
    {
        MVector reverse = new MVector(-x,-y);

        return reverse;
    }

    public void set(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void set(MVector vector)
    {
        this.x = vector.x;
        this.y = vector.y;
    }

    public void limit(int limit)
    {
        this.limit = limit;
    }

    public float length()
    {
        float length = Math.abs((float) Math.sqrt((x*x)+(y*y)));

        return length;
    }

    public float distance(MVector vector)
    {
        float distance = Math.abs((float) Math.sqrt(((this.x-vector.x)*(this.x-vector.x))+((this.y-vector.y)*(this.y-vector.y))));

        return distance;
    }


    public void add(MVector vector)
    {
        this.x += vector.x;
        this.y += vector.y;

        /**if(length() > limit)
        {
            double nx,ny;
            if(x < 0)
            {
                nx = 10;
            }
            else
            {
                nx = -10;
            }
            if(y < 0)
            {
                ny = 10;
            }
            else
            {
                ny = -10;
            }
            np = new MVector(nx,ny);
            this.add(np);
        }*/
    }
}
