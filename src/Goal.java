import javax.swing.*;
import java.awt.*;

/**
 * Created by Familie on 09.08.2019.
 */
public class Goal extends JPanel
{
    MVector position;
    public final int SIZE = 6;
    public Goal(MVector vector)
    {
        position = vector;
    }

    public Goal(int x, int y)
    {
        position = new MVector(x,y);
    }
    @Override
    public void update(Graphics g)
    {
        paintComponent(g);
    }

    public void paintComponent(Graphics graphics)
    {
        graphics.setColor(Color.GREEN);
        graphics.fillRect((int)position.x,(int)position.y,SIZE,SIZE);
    }
}
