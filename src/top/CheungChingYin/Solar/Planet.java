package top.CheungChingYin.Solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import top.CheungChingYin.Util.GameUtil;

public class Planet extends Star {
//	除了图片，坐标。行星沿着某个椭圆运行；椭圆有长轴，短轴，速度，角度，绕着某个Star飞
	double longAxis;//椭圆的长轴
	double shortAxis;//椭圆的短轴
	double speed;//飞行速度
	Star centre;//围绕的中心
	double degree;//飞行角度
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
		//沿着椭圆角度飞行
		x=(centre.x+centre.width/2)+longAxis*Math.cos(degree);
		y=(centre.y+centre.height/2)+shortAxis*Math.sin(degree);
		//由于速度不一样，所以增量不一样
		degree+=speed;
	}
	
	public Planet(String imgpath,  double longAxis, double shortAxis, double speed, Star centre) {
		/*
		 * 当父类Star没有定义一个普通的无参构造器的时候会报错，因为方法会有一个隐式构造器super（）指向父类无参构造器
		 * Implicit super constructor Star() is undefined. Must explicitly invoke another constructor
		 * 解决方法：在父类定义一个无参构造器
		 */
		super(GameUtil.getImage(imgpath));//调用父类构造器，载入行星地址
		this.longAxis = longAxis;
		this.x=centre.x+longAxis;//行星的X轴起点，由于行星的起点是在同一条X轴上，故需要太阳+长轴
		this.y=centre.y;//行星的y轴起点
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
	
	public Planet(Image img, double x, double y) {//调用父类构造器
		super(img, x, y);
	}
	
	public Planet(String imgpath, double x, double y) {//调用父类构造器
		super(imgpath, x, y);
	}
	
}
