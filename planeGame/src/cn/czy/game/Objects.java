package cn.czy.game;

import java.awt.Image;
import java.awt.Rectangle;

public class Objects {
    protected int object_x, object_y;
    protected int speed;
    protected int width, height;
    protected Image img;
    
    public Objects() {}

	public Rectangle getRect(){
		return  new Rectangle(object_x,object_y, width, height);
	}
    
}
