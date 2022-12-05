public class Ball {
    public Oblong oblong;
    public Oblong leftPaddle, rightPaddle;
    //velocity of x and y
    public double vy = 175.0;
    public double vx = -175.0;

    public Ball(Oblong oblong, Oblong leftPaddle, Oblong rightPaddle) {
        this.oblong = oblong;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    public void update(double dt) {
        if (vx < 0) {
            if (this.oblong.x <= this.leftPaddle.x + this.leftPaddle.rWidth && this.oblong.x >= this.leftPaddle.x &&
                    this.oblong.y >= this.leftPaddle.y && this.oblong.y <= this.leftPaddle.y + this.leftPaddle.rHeight)
            {
                this.vx *= -1;
                this.vy *= -1;
            } else if (this.oblong.x + this.oblong.rWidth < this.leftPaddle.x)
            {
                System.out.println("you lost a point");
            }} else if (vx > 0)
            {
                if (this.oblong.x + this.oblong.rWidth >= this.rightPaddle.x && this.oblong.x <= this.rightPaddle.x + this.rightPaddle.rWidth && this.oblong.y >= this.rightPaddle.y && this.oblong.y <= this.rightPaddle.y + this.rightPaddle.rHeight)
                {
                    this.vx *= -1;
                    this.vy *= -1;
                } else if (this.oblong.x + this.oblong.rWidth > this.rightPaddle.x + this.rightPaddle.rWidth)
                {
                    System.out.println("AI lost a point");
                }

        }
            if (vy > 0) {
                if (this.oblong.y + this.oblong.rHeight > Constants.screenheight) {
                    this.vy *= -1;
                }
            } else if (vy<0){
                if(this.oblong.y<0){
                    this.vy*=-1;
                }
            }




                //position=position+ velocity
                //velocity= velocity += vy*dt


            this.oblong.x += vx * dt;
            this.oblong.y += vy * dt;
        }
    }

