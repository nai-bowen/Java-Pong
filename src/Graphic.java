import javax.swing.JFrame;
import java.awt.*;

// this class opens up the window and uses Jframe to implement methods of the gui
public class Graphic extends JFrame implements Runnable {
    public Graphics2D g1;
    public KeyEvents keyListener= new KeyEvents() ;

    public Oblong player1;
    public Oblong ai;
    public Oblong ballOblong;
    public PlayerController playerController;
    public Ball ball;
    public aiController aiController;
    public Graphic() {
        // this class handles everything to do with windows and graphics
        this.setSize((Constants.screenwidth), (Constants.screenheight));
        this.setTitle(Constants.title);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g1 = (Graphics2D) this.getGraphics();

        player1 = new Oblong(10,100,Constants.playerWidth,Constants.playerHeight,Constants.playerColor);
        playerController= new PlayerController(player1,keyListener);

        ai= new Oblong(Constants.screenwidth-30,100,Constants.playerWidth,Constants.playerHeight,Constants.playerColor);
        ballOblong= new Oblong(Constants.screenwidth/2,Constants.screenheight/2+100,Constants.ballDimension,Constants.ballDimension,Constants.ballColor);
        ball= new Ball(ballOblong, player1, ai);

        aiController= new aiController(new PlayerController(ai),  ballOblong);
    }

    public void update(double dt) {
       Image dbImage= createImage(getWidth(),getHeight());
       Graphics dbg= dbImage.getGraphics();
       this.draw(dbg);
       g1.drawImage(dbImage,0,0,this);
       playerController.update(dt);
       aiController.update(dt);
       ball.update(dt);

        /* Testing if the rectangle draws correctly
        Oblong oblong= new Oblong(50,100, 20, 80, Color.pink);
        oblong.draw(g1);*/

       /* Testing if the keyPress is working
       if (keyListener.isKeyPressed(KeyEvent.VK_UP)){
            System.out.println("The user is pressing up");
        } else if (keyListener.isKeyPressed((KeyEvent.VK_DOWN))) {
            System.out.println("The user is pressing down");
        }*/
    }
    public void draw(Graphics g){
        Graphics2D g1= (Graphics2D)g;
        g1.setColor(Color.white);
        g1.fillRect(0, 0, Constants.screenwidth, Constants.screenheight);
        ai.draw(g1);
        player1.draw(g1);
        ballOblong.draw(g1);
        Font font= new Font("Times New Roman", Font.PLAIN, 14);
        Text text= new Text("Test",font , 100,100);
        text.draw(g1);

    }
    public void run() {
        double lastFrameTime = 0.0;
        while (true) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);

            try {
                Thread.sleep(30);
            } catch (Exception e) {
            }
        }
    }
}
