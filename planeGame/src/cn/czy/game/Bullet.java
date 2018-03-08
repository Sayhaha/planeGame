package cn.czy.game;

import java.awt.Color;
import java.awt.Graphics;

import cn.czy.util.Constant;

public class Bullet extends Objects{
    private double degree;
    
    public Bullet() {}
    
    public Bullet(double degree) {
    	this.degree = degree;
    	object_x = Constant.BULLET_X;
    	object_y = Constant.BULLET_Y;
    	speed = Constant.BULLET_SPEED;
    	width = Constant.BULLET_WIDTH;
    	height = Constant.BULLET_HEIGHT;
    }
    
    public void draw(Graphics g) {
    	Color c = g.getColor();
    	g.setColor(Color.yellow);
    	g.fillOval(object_x, object_y, Constant.BULLET_WIDTH, Constant.BULLET_HEIGHT);
    	g.setColor(c);
    	move();
    }
    
    private void move() {
    	object_x += (int) (speed * Math.cos(degree));
    	object_y += (int) (speed * Math.sin(degree));
    	if((object_x < 5) || (object_x > Constant.GAME_WIDTH - Constant.BULLET_WIDTH))
    		degree = Math.PI - degree;
    	if((object_y < 30) || (object_y > Constant.GAME_HEIGHT - Constant.BULLET_HEIGHT))
    		degree = -degree;
    }
    
}
