package top.CheungChingYin.Util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
	
	/*
	 * ���ش���
	 */
	private double x=100.0;//����Ч��ʱ�ı���
	private double y=100.0;
	private double degree=Math.PI/3;
	private double speed=10;
	public void launchFrame(){
		
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		new PaintThread().start();//�����ػ��߳�
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//�ر������
			}
			
		});
		
	}
	
	private Image offScreenImage=null;//˫���弼��
	public void update(Graphics g){//����˫���弼��������˸
		if(offScreenImage==null){
			offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		}
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	/*����һ���ػ����ڵ��߳��࣬��һ���ڲ���*/
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();//������ѭ���ػ�����
				try {
					Thread.sleep(40);//��Ϣ40���룬��Ȼ̫����cpu����Լһ������25��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
