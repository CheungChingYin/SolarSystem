package top.CheungChingYin.Util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
* ��Ϸ�����г��õĹ�����(����:����ͼƬ�ȷ���)
* @author admin
*
*/
public class GameUtil {
    
	private GameUtil () {} //������ͨ�������췽��˽��

	public static Image getImage(String path) {
//        URL u = GameUtil.class.getClassLoader().getResource(path);
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(u);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        return img;  //BufferedImage��Image���࣬Ҳ����ȷ����
	return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}