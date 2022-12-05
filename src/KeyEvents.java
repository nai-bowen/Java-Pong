import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEvents implements KeyListener {
    //128 is the number of ASCII characters in the array
    //tells the system what to do should any key be pressed
    //range of key events
    private boolean keyPress[]= new boolean[128];
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        //telling the system that a key has been pressed
        keyPress[keyEvent.getKeyCode()]= true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //if the key is released then get keycode is false
        keyPress[keyEvent.getKeyCode()]=false;
    }

    //for us to see if a key has been pressed in terminal to know if code is running correctly

    public boolean isKeyPressed (int keyCode){
        return keyPress[keyCode];
    }
}
