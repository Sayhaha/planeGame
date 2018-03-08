package cn.czy.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import cn.czy.util.Constant;
import cn.czy.util.GameUtil;
import cn.czy.util.MyFrame;

public class GameFrame extends MyFrame{
	Image bg_img = GameUtil.getImage(Constant.BG_PATH);
	Plane p = new Plane();
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	Bullet bb;
	boolean boom;
	Explode e;
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg_img, 0, 0, null);
		p.draw(g);
		for(int i = 0; i < bullets.size(); i++) {
			bb = (Bullet) bullets.get(i);
			bb.draw(g);
			boom = bb.getRect().intersects(p.getRect());
			if(boom) {
				p.setLive(false);  //飞机死掉！
				if(e == null){
					e = new Explode(p.object_x,p.object_y);
				}
				e.draw(g);
				
				break;
			}
		}
		if(!p.isLive())
			printInfo(g, "GAME OVER", 50,100,200,Color.yellow);
	}

	class keyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			//System.out.println(e.getKeyCode());
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			p.minusDirection(e);
		}
		
	}
	
	public void launchFrame(){
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new keyMonitor());
		
		Bullet b;
		double degree = Math.PI * 2 / Constant.BULLET_COUNT;
		for(int i = 1; i <= Constant.BULLET_COUNT; i++) {
			b = new Bullet(degree * i);
			bullets.add(b);
		}
		
	}


	/**
	 * 打印游戏结束的提示消息
	 * @param g
	 * @param str
	 * @param size
	 * @param x
	 * @param y
	 * @param color
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str,x,y);
		g.setColor(c);

	}

	public static void main(String[] args) {
		new GameFrame().launchFrame();
	}
}
