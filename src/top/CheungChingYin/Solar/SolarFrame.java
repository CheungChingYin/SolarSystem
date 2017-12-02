package top.CheungChingYin.Solar;

import java.awt.Graphics;
import java.awt.Image;

import top.CheungChingYin.Util.Constant;
import top.CheungChingYin.Util.GameUtil;
import top.CheungChingYin.Util.MyFrame;

/**��ѧ��EP.84-87
 * ̫��ϵ������
 * @author Administrator
 *
 */
public class SolarFrame extends MyFrame {
	Image bg=GameUtil.getImage("images/timg.jpg");
	Star sun=new Star("images/sun.jpg", Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);//ʵ�ַ�װһ������ʹ��
	Planet earth=new Planet("images/����.jpg", 150, 100, 0.1, sun);
	Planet mars=new Planet("images/����.jpg", 200, 130, 0.2, sun);
	Planet wood=new Planet("images/ľ��.jpg", 250, 180, 0.05, sun);
	
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
