import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Window
{
    JFrame frame;
    ArrayList<Dot> contents;
    ArrayList<Obstacle> obstacles;
    Goal goal;
    public Window()
    {
        //Initializing frame
        frame = new JFrame("Game Shit");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        contents = new ArrayList<Dot>();
        obstacles = new ArrayList<>();


        goal = new Goal(400,50);
        frame.getContentPane().add(goal);
    }

    public void add(Dot comp)
    {
        frame.getContentPane().add(comp);
        contents.add(comp);
    }

    public void add(Obstacle obstacle)
    {
        frame.getContentPane().add(obstacle);
        obstacles.add(obstacle);
    }

    public void clear()
    {
        frame.getGraphics().clearRect(4,0,frame.getWidth()-8,50);
        frame.getGraphics().clearRect(4,60,frame.getWidth()-8,frame.getHeight()-54);
        frame.getGraphics().clearRect(4,50,(frame.getWidth()/2)-4,20);
        frame.getGraphics().clearRect((frame.getWidth()/2)+4,50,(frame.getWidth()/2)-4,20);
    }

    public void update()
    {
        clear();
        ArrayList<Dot> toDelete = new ArrayList();
        goal.update(frame.getGraphics());
        if (!obstacles.isEmpty())
        {
            for(Obstacle obstacle : obstacles)
            {
                obstacle.update(frame.getGraphics());
            }
        }
        if (!contents.isEmpty())
        {
            for(Dot dot : contents)
            {

                if (dot != null)
                {
                    dot.stepsMade++;
                    dot.update(frame.getGraphics());
                    if(dot.position.x >= frame.getWidth()-4 || dot.position.x <= 4 || dot.position.y >= frame.getHeight()-24 || dot.position.y <= 24 )
                    {
                        dot.die();
                    }
                    else if(dot.position.distance(goal.position) < 4)
                    {
                        dot.reachGoal();
                    }
                    if (!obstacles.isEmpty())
                    {
                        for(Obstacle obstacle : obstacles)
                        {
                            if(obstacle.hit(dot) && dot.alive)
                            {
                                dot.die();
                                //System.out.println("Dot died to Obstacle");
                            }
                        }
                    }
                    if(!dot.alive || dot.reachedTheGoal)
                    {
                        toDelete.add(dot);
                    }
                }
            }
            contents.removeAll(toDelete);
        }
    }

    public void show()
    {
        frame.setVisible(true);
    }

    public void hide()
    {
        frame.setVisible(false);
    }
}
