package top.CheungChingYin.Solar;

import java.awt.Graphics;
import java.awt.Image;

import top.CheungChingYin.Util.GameUtil;

public class Star {
	Image img;
	double x,y;
	double width,height;
	
	public void draw(Graphics g){//画出图片
		g.drawImage(img, (int)x,(int) y, null);
	}
	
	public Star(String imgpath ,double x,double y) {
		this(GameUtil.getImage(imgpath), x, y);
		//通过this调用另外一个构造器，调用了public Star(Image img,double x,double y)
	}
	
	public Star(Image img,double x,double y) {
		this(img);
		this.x=x;
		this.y=y;
		//以图片（太阳）的中心为圆心
		
	}
	
	public Star(Image img){
		this.img=img;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	
	public Star(){
	}
}
