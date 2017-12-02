package top.CheungChingYin.Util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
* 游戏开发中常用的工具类(比如:加载图片等方法)
* @author admin
*
*/
public class GameUtil {
    
	private GameUtil () {} //工具类通常将构造方法私有

	public static Image getImage(String path) {
//        URL u = GameUtil.class.getClassLoader().getResource(path);
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(u);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        return img;  //BufferedImage是Image子类，也算正确返回
	return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}