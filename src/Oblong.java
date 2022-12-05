import java.awt.*;

public class Oblong {
    public int x, y, rWidth, rHeight;
    public Color colour;
    public Oblong(int x, int y, int rWidth, int rHeight, Color colour){
        this.x=x;
        this.y=y;
        this.rWidth=rWidth;
        this.rHeight=rHeight;
        this.colour=colour;
    }

    public void draw(Graphics2D g1){
        g1.setColor(colour);
        g1.fillRect(x,y,rWidth,rHeight);
    }
}
