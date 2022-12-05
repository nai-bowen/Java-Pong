import java.awt.*;

public class Text {
    public String string;
    public Font font;
    public double x,y;

    public Text (String string, Font font, double x, double y){
        this.string=string;
        this.font=font;
        this.x=x;
        this.y=y;

    }
    public void draw(Graphics2D g1){
        g1.setColor(Color.darkGray);
        g1.setFont(font);
        g1.drawString("text", (float)x, (float)y);
    }
}
