package top.CheungChingYin.Solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import top.CheungChingYin.Util.GameUtil;

public class Planet extends Star {
//	����ͼƬ�����ꡣ��������ĳ����Բ���У���Բ�г��ᣬ���ᣬ�ٶȣ��Ƕȣ�����ĳ��Star��
	double longAxis;//��Բ�ĳ���
	double shortAxis;//��Բ�Ķ���
	double speed;//�����ٶ�
	Star centre;//Χ�Ƶ�����
	double degree;//���нǶ�
	boolean satellite;
	
	public void draw(Graphics g){
		super.draw(g);
		if(!satellite){
			drawTrace(g);	
		}
		move();
	}
	
	public void drawTrace(Graphics g){
		double ovalX,ovalY,ovalWidth,ovalHeight;
		ovalWidth=longAxis*2;
		ovalHeight=shortAxis*2;
		ovalX=(centre.x+centre.width/2)-longAxis;
		ovalY=(centre.y+centre.height/2)-shortAxis;
		Color c=g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
	
	public void move(){
		//������Բ�Ƕȷ���
		x=(centre.x+centre.width/2)+longAxis*Math.cos(degree);
		y=(centre.y+centre.height/2)+shortAxis*Math.sin(degree);
		//�����ٶȲ�һ��������������һ��
		degree+=speed;
	}
	
	public Planet(String imgpath,  double longAxis, double shortAxis, double speed, Star centre) {
		/*
		 * ������Starû�ж���һ����ͨ���޲ι�������ʱ��ᱨ����Ϊ��������һ����ʽ������super����ָ�����޲ι�����
		 * Implicit super constructor Star() is undefined. Must explicitly invoke another constructor
		 * ����������ڸ��ඨ��һ���޲ι�����
		 */
		super(GameUtil.getImage(imgpath));//���ø��๹�������������ǵ�ַ
		this.longAxis = longAxis;
		this.x=centre.x+longAxis;//���ǵ�X����㣬�������ǵ��������ͬһ��X���ϣ�����Ҫ̫��+����
		this.y=centre.y;//���ǵ�y�����
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.centre = centre;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	
	public Planet(String imgpath,  double longAxis, double shortAxis, double speed, Star centre,boolean satellite) {
		this(imgpath, longAxis, shortAxis, speed, centre);
		this.satellite=satellite;
	}
	
	public Planet(Image img, double x, double y) {//���ø��๹����
		super(img, x, y);
	}
	
	public Planet(String imgpath, double x, double y) {//���ø��๹����
		super(imgpath, x, y);
	}
	
}
