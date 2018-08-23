package lottery;
  
   
  
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;  
  
import java.awt.Container;  
  
import java.awt.Font;  
  
import java.awt.event.ActionEvent;  
  
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;  
  
   
  
   
  
public class PrizeDraw
{  
	protected static Thread thread;
	protected static String name[] = new String[100]; // 存待抽奖人员姓名
	protected static int number; // 参与抽奖人员人数
	protected static boolean condition = false; // 循环条件控制线程
	protected static AudioClip start = Applet.newAudioClip(PrizeDraw.class.getResource("6666.wav"));
	protected static AudioClip stop = Applet.newAudioClip(PrizeDraw.class.getResource("2855.wav"));
	

	public static void lottery() throws IOException{

    final MyFrame form = new MyFrame();    //自定义框架类
 
    form.setLocation(400,200);  //设置框架位置坐标
  
  form.setSize(705, 495);   //设置长度和宽度
  
    form.setVisible(true);  
    
  	URL url = MyFrame.class.getResource("1.jpg");  
	Icon icon = new ImageIcon(url);  

   //将图片放入label中  
   JLabel label=new JLabel();  
    label.setIcon(icon); 
   //设置label的大小  
   label.setBounds(0,0,705,495);  
   
     
   //获取窗口的第二层，将label放入  
   form.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));  
         
   //获取frame的顶层容器,并设置为透明  
   JPanel j=(JPanel)form.getContentPane();  
   j.setOpaque(false);  

   JPanel panel=new JPanel();  

   //必须设置为透明的。否则看不到图片  
   panel.setOpaque(false);  
  form.add(panel);  

 
    //开始按钮
    JButton startButton = new JButton("开始");  
    //startButton.setBackground(Color.BLACK);

	
	//startButton.setBorderPainted(true);  //去掉边框
	startButton.setFont(new Font("微软雅黑", Font.PLAIN, 50));  
    startButton.setBackground(Color.ORANGE);  
    startButton.setBounds(252, 250, 170, 70); 
    form.getContentPane(	).add(startButton);  
    startButton.addActionListener(new ActionListener(){
    		
    	public void actionPerformed(ActionEvent e) {
    		condition = true;
    		new Thread(thread).start();
    		/*	//播放音乐
			try {
			File f = new File("6666.wav");
			URI uri = f.toURI();
			URL url1 = PrizeDraw.class.getResource("6666.wav");
			AudioClip aau = Applet.newAudioClip(url1);
			aau.play();
			}catch (Exception e1)
			{
				e1.printStackTrace();
			}*/
    		//start = Applet.newAudioClip(PrizeDraw.class.getResource("6666.wav"));
    		stop.stop();
		start.play();	
    		}
    });
    
	JButton stopButton = new JButton("停止");
	stopButton.setBackground(Color.ORANGE);
	stopButton.setFont(new Font("微软雅黑", Font.PLAIN, 50));  
	
	
	//stopButton.setBorderPainted(true); 
	stopButton.setBounds(252, 330, 170, 70);
    form.getContentPane().add(stopButton); 
    
    stopButton.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			condition = false;
			//stop = Applet.newAudioClip(PrizeDraw.class.getResource("2855.wav"));
			start.stop();
			stop.play();
			String st = form.getTextField().getText();  
			st = st + "获得百元大奖！！！！";  
			new JOptionPane().showMessageDialog(null, st);  
			  
          }
    });
    
	JButton fileButton = new JButton("文件");
	fileButton.setBounds(252, 170, 170, 70);
	fileButton.setFont(new Font("微软雅黑", Font.PLAIN, 50));  
	fileButton.setBackground(Color.ORANGE);

	//fileButton.setBorderPainted(true);
	
	fileButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			String path; // 文件路径
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Open file");	
			fileChooser.showOpenDialog(form);
			path = fileChooser.getSelectedFile().toString();
			
			/*读入待抽奖人员的信息 */
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(path);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} 
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			number = 0;
			try {
				while ((name[number] = bufferedReader.readLine()) != null) {
					number++;
				} 
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		}
	});
	form.getContentPane().add(fileButton);
	
	thread = new Thread(new Runnable() {
		Random random = new Random();
		public void run() {
			while(condition) {
				int number1 = random.nextInt(number) % (number + 1); //获取一个随机数用来实时显示
				form.getTextField().setText(name[number1]);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}
	});
	
}
	public static void main(String []args) throws IOException {
		lottery();
    }  
}  