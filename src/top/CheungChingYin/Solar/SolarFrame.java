package top.CheungChingYin.Solar;

import java.awt.Graphics;
import java.awt.Image;

import top.CheungChingYin.Util.Constant;
import top.CheungChingYin.Util.GameUtil;
import top.CheungChingYin.Util.MyFrame;

/**尚学堂EP.84-87
 * 太阳系主窗口
 * @author Administrator
 *
 */
public class SolarFrame extends MyFrame {
	Image bg=GameUtil.getImage("images/timg.jpg");
	Star sun=new Star("images/sun.jpg", Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);//实现封装一个方法使用
	Planet earth=new Planet("images/地球.jpg", 150, 100, 0.1, sun);
	Planet mars=new Planet("images/火星.jpg", 200, 130, 0.2, sun);
	Planet wood=new Planet("images/木星.jpg", 250, 180, 0.05, sun);
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		earth.draw(g);
		mars.draw(g);
		wood.draw(g);
	}
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
