package cn.czy.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import cn.czy.util.Constant;
import cn.czy.util.GameUtil;

public class Plane extends Objects{
	private boolean right, left, up, down;
	private boolean live;
	
	public Plane() {
		object_x = Constant.PLANE_INIT_X;
		object_y = Constant.PLANE_INIT_Y;
		speed = Constant.PLANE_SPEED;
		width = Constant.PLANE_WIDTH;
		height = Constant.PLANE_HEIGHT;
		live = true;
		img = GameUtil.getImage(Constant.PLANE_PATH);
	}
	
	public int getX() {
		return object_x;
	}
	
	public int getY() {
		return object_y;
	}
	
	public void draw(Graphics g) {
		if(live) {
		    g.drawImage(img, object_x, object_y, null);
		    move();
		}
	}
	
	public boolean isLive() {
		return this.live;
	}
	
	public void setLive(boolean live) {
		this.live = live;
	}
	
	private void move() {
		if(right && object_x <= Constant.GAME_WIDTH - Constant.PLANE_WIDTH)
			object_x += speed;
		if(down && object_y <= Constant.GAME_HEIGHT - Constant.PLANE_HEIGHT)
			object_y += speed;
		if(left && object_x >= 15)
			object_x -= speed;
		if(up && object_y >= 30)
			object_y -= speed;
	}
	
	public void addDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		default: break;
		}
	}
	
	public void minusDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		default: break;
		}
	}
	
	
	
}
