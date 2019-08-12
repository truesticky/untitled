import javax.swing.*;
import java.awt.*;

public class Obstacle extends JPanel
{

    int x,y,width,height;
    MVector position;
    public Obstacle(int x, int y, int width, int heigth)
    {
        this.position = new MVector(x,y);
        this.height = heigth;
        this.width = width;
    }

    public boolean hit(Dot dot)
    {
        if((dot.position.x >= this.position.x && dot.position.x <= this.position.x+width)&&(dot.position.y >= this.position.y && dot.position.y <= this.position.y+height))
        {
            return true;
        }
        return false;
    }

    @Override
    public void update(Graphics g)
    {
        paintComponent(g);
    }

    public void paintComponent(Graphics graphics)
    {
        graphics.setColor(Color.BLUE);
        graphics.fillRect((int)position.x,(int)position.y,width,height);
    }
}
