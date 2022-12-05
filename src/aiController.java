public class aiController {
    public PlayerController playerController;
    public Oblong ball;

    public aiController(PlayerController playerController, Oblong ball){
        this.playerController= playerController;
        this.ball=ball;
    }
    public void update (double dt){
        playerController.update(dt);
        if(ball.y<playerController.oblong.y+10){
            playerController.keyUp(dt);
        } else if (ball.y + ball.rHeight> playerController.oblong.y +playerController.oblong.rHeight+15){
            playerController.keyDown(dt);
        }
    }
}
