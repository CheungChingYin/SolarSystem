package top.CheungChingYin.Util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
	
	/*
	 * 加载窗口
	 */
	private double x=100.0;//动画效果时的变量
	private double y=100.0;
	private double degree=Math.PI/3;
	private double speed=10;
	public void launchFrame(){
		
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		new PaintThread().start();//启动重画线程
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//关闭虚拟机
			}
			
		});
		
	}
	
	private Image offScreenImage=null;//双缓冲技术
	public void update(Graphics g){//利用双缓冲技术消除闪烁
		if(offScreenImage==null){
			offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		}
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	/*定义一个重画窗口的线程类，是一个内部类*/
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();//利用死循环重画窗口
				try {
					Thread.sleep(40);//休息40毫秒，不然太消耗cpu，大约一秒运行25次
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
