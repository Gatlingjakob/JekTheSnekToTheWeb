package snake;

import javax.swing.*;
import java.awt.*;


/**
 * Created by jakob on 12/02/2017.
 */

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {

    public static Color beige = new Color(0x675933);


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(beige);
        g.fillRect(0, 0, 800, 700);
        Snake snake = Snake.snake;
        g.setColor(Color.BLACK);
        for (Point point : snake.snakeParts){
            g.fillRect(point.x * Snake.SCALE, point.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
        }

        g.fillRect(snake.head.x * Snake.SCALE, snake.head.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
        g.setColor(Color.MAGENTA);
        g.fillRect(snake.cherry.x * Snake.SCALE, snake.cherry.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
        String string = "Score: " + snake.score + " Length: "
                + snake.tailLength + " Time: " + snake.time / 20;
        g.setColor(Color.white);
        g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);
        String string2 = "Move: W, A ,S ,D   Pause/Restart: SPACE";
        g.drawString(string2, (int) (getWidth() / 2 - string.length() * 4.0f), 25);


        string = "You have been rekt by Jek the Snek - topkek!";

        if (snake.over)
        {
            g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
        }

        string = "Paused!";

        if (snake.paused && !snake.over)
        {
            g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
        }
    }
}
