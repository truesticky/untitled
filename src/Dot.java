import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Familie on 09.08.2019.
 */
public class Dot extends JPanel
{
    MVector position;
    MVector velocity;
    MVector acceleration;

    Brain brain = new Brain(400);

    boolean alive = true;
    boolean reachedTheGoal = false;
    double fitness = 0;
    int stepsMade = 0;
    int generation = 0;

    public final int SIZE = 2;
    public Dot()
    {
        brain.setDot(this);
        position = new MVector(400,550);
        velocity = new MVector(0,0);
        acceleration = new MVector(0,0);
    }

    public void paintComponent(Graphics graphics)
    {
        graphics.fillRect((int)position.x,(int)position.y,SIZE,SIZE);
    }

    public void move()
    {
        acceleration = brain.next();
        velocity.add(acceleration);
        position.add(velocity);
    }

    public void reachGoal()
    {
        reachedTheGoal = true;
        //System.out.println("Dot reached the Goal");
    }

    public void die()
    {
        //System.out.println("Dot died");
        alive = false;
    }

    @Override
    public void update(Graphics g)
    {
        if(alive)
        {
            move();
            paintComponent(g);
        }
    }

    public float calculateFitness()
    {
        MVector goal = new MVector(400,50);
        float distanceToGoal = position.distance(goal);
        float fit;
        //System.out.println(generation);

        fit = (float) (1/(((distanceToGoal*distanceToGoal)+(stepsMade))/2));
       // if( generation > 15 && !reachedTheGoal) fit = 0;


        this.fitness = fit;

        return fit;
    }

    public Dot cloneParent()
    {
        Dot babie = new Dot();
        babie.brain = this.brain.cloneBrain();
        babie.brain.setDot(babie);

        return babie;
    }


}
