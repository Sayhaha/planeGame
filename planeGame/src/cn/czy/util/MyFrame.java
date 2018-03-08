package cn.czy.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame{
	
	/**
	 * ���ش���
	 */
	public void launchFrame() {
		setTitle(Constant.GAME_TITLE);
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(Constant.GAME_X, Constant.GAME_Y);
		setVisible(true);
		
        new PaintThread().start();  //�����ػ��߳�
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
		
	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
	 *
	 */
	class PaintThread extends Thread {
		@Override
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(Constant.THREAD_SLEEP); //1s = 1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}   
			}
		}	
	}
	
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage == null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();

		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
