import java.util.Random;

/**
 * Created by Familie on 09.08.2019.
 */
public class Main
{
    public static void main(String args[])
    {
        Window window = new Window();

        Population population = new Population(1000);

        Obstacle obstacle = new Obstacle(0,200,450,20);
        Obstacle obstacle2 = new Obstacle(350,400,450,20);
        Obstacle obstacle3 = new Obstacle(400,300,20,20);

        window.add(obstacle);
        window.add(obstacle2);
        window.add(obstacle3);

        window.show();

        while (true) {
            for(int i= 0;i<population.dots.length;i++)
            {
                window.add(population.dots[i]);
            }

            while(!window.contents.isEmpty())
            {
                window.update();
                try
                {
                    Thread.sleep(5);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }
            System.out.println("All dots dead or successful");

            population.naturalsSelection();
            population.mutate();
            System.out.println("Starting generation " + population.generation);
            window.frame.removeAll();
        }
        //System.exit(0);
    }
}
