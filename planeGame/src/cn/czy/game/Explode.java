package cn.czy.game;

import java.awt.Graphics;
import java.awt.Image;

import cn.czy.util.Constant;
import cn.czy.util.GameUtil;

public class Explode extends Objects{
	static Image[] imgs = new Image[16];
	static {
		for(int i=0;i<16;i++){
			imgs[i] = GameUtil.getImage(Constant.BOOM_PATH+(i+1)+".gif");
			imgs[i].getWidth(null);
		}
	}
	
    public Explode(int x, int y) {
    	object_x = x;
    	object_y = y;
    }
    
    
    int count = 0;
	public void draw(Graphics g){
		if(count<=15){
			g.drawImage(imgs[count], object_x, object_y, null);
			count++;
		}
	}
}
