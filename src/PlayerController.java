import java.awt.event.KeyEvent;

public class PlayerController {
    public Oblong oblong;
    public KeyEvents keyListener;
    public PlayerController (Oblong oblong, KeyEvents keyListener){
        this.oblong=oblong;
        this.keyListener= keyListener;
    }

    public PlayerController(Oblong oblong){
        this.oblong = oblong;
        this.keyListener= null;
    }
    public void update(double dt) {
        if (keyListener != null) {
            if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
                keyDown(dt);
            } else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
                keyUp(dt);
            }
        }
    }

    public void keyUp (double dt){
        if (oblong.y-1100*dt>0)
            this.oblong.y=(int)(this.oblong.y-Constants.playerSpeed*dt);
    }

    public void keyDown (double dt){
        if ((oblong.y-5*dt)+oblong.rHeight<Constants.screenheight)
            this.oblong.y=(int)(this.oblong.y+Constants.playerSpeed*dt);
    }
}
