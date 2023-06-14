import javax.swing.*;
import java.awt.*;

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
    }
    static class MyComp extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Image image = new ImageIcon("src/str.jpg").getImage();
            int x=0,y=0;
            while (true) {
                g2.drawImage(image, x, y, null);
                if(x<=1000&&y<=1000) {
                    x++;
                    y++;
                }else{
                    x=0;
                    y=0;
                }
            }
        }
    }

}
