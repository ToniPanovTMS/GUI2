/*import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
public class GUI2 {
    public static void main(String[] Args){
        JFrame jFrame =new JFrame();//окно
        jFrame.setVisible(true);//делаем видимым
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// даём возможность закрыть приложение
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension =toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2-500,dimension.height/2-500,1000,1000);//так можно отцентровать по середине
        jFrame.setTitle("GUI lisson 2");
        jFrame.add(new MyComp());
        jFrame.setVisible(true);
    }
    static class MyComp extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            try {
                URLConnection openConnection = new URL("https://img-winapps.lisisoft.com/imgmic/6/0/2006-1-spider-exterminator-e1cbd0ff42b8.png").openConnection();
                openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
                BufferedImage image = ImageIO.read(openConnection.getInputStream());
                int imageWidth = image.getWidth(), imageHeight=image.getHeight();
                int y = 0, x = 0;
                while (true) {//двигаемся по диагонали, с очисткой области через паузу
                    if (x>1000||y>1000) {//если вышли за пределы окна то все заново
                        y = 0;
                        x = 0;
                    }
                    g2.drawImage(image, x, y, this);
                    TimeUnit.MILLISECONDS.sleep(30);
                    g2.clearRect(x, y, imageWidth, imageHeight);
                    x+=3;
                    y+=3;
                }
            } catch (IOException | InterruptedException e) {
                g.drawString("Ошибка", 10,10);
            }
        }
    }

}

 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GUI2 extends Canvas {
    static int width = 1000, height=1000;//размеры окна

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //преобразуем Graphics в Graphics2D (для сглаживания)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/str.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int imageWidth = image.getWidth(), imageHeight=image.getHeight();
            int y = 0, x = 0;
            while (true) {
                if (x>width||y>height) {
                    y = 0;
                    x = 0;
                }
                g2.drawImage(image, x, y, this);
                try {
                    TimeUnit.MILLISECONDS.sleep(40);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                g2.clearRect(x, y, imageWidth, imageHeight);
                x+=3;
                y+=3;
            }
        }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Паучок");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2-width/2,dim.height/2-height/2, width,height);
        GUI2 m=new GUI2();
        frame.add(m);
        frame.setVisible(true);
    }
}