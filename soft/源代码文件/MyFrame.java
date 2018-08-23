package lottery;  
 /*①基本要求：设计用于摇号抽奖的软件程序，
  * 在一个文本文件中放入参加抽奖人的姓名或是学号或是手机号码。
  * 按下开始按钮，抽奖开始，在软件中可以将这些抽奖人信息快速地滚动显示在界面上，
  * 当按下停止按钮时，滚动显示停止，显示出一个中奖人的信息。抽奖过程可以重复进行。
  * ②提高要求：抽奖人的信息滚动可以具备随机性以保障公平；
  * 可以同时显示抽奖人的照片（抽奖人照片可以事先存放在文件中）；
  * 抽奖软件可以实现合适的提示音以及背景音乐；
  * 实现具有操作方便并且有创新性的软件交互界面。
  */
import javax.swing.JFrame;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;  
  
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;  
  
import java.awt.FlowLayout;  
  
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.awt.event.ActionEvent;  
  
   
  
import javax.swing.JTextField;  
  
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;  
  
import javax.swing.SwingConstants;  
  
   
  
public class MyFrame extends JFrame  
  
{  
  
   public JTextField txtEdit;  
  
   public MyFrame()  
  
   {  
   super("抽奖系统");
   
   getContentPane().setBackground(Color.BLACK);  
  
   getContentPane().setForeground(Color.MAGENTA);  
  
   getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 30));  
  
   getContentPane().setLayout(null);  
   
   


   	//解决窗体的显示问题
 	Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
 	Dimension screenSize = kit.getScreenSize(); // 获取屏幕尺寸
 	int screenWidth = screenSize.width / 2; // 获取屏幕的宽度
 	int screenHeight = screenSize.height / 2; //获取屏幕的高度
 	int height = super.getHeight();
 	int width = super.getWidth();
 	super.setLocation(screenWidth - width / 2, screenHeight - height / 2);
 	 
 	


 	
 	
  //文本框
   txtEdit = new JTextField();  
  
   txtEdit.setFont(new Font("微软雅黑", Font.PLAIN, 40));  
  
   txtEdit.setBounds(120,49,450,100);   //x,y 长度，宽度
   txtEdit.setEditable(false);//设置选项不可用
   txtEdit.setHorizontalAlignment(SwingConstants.CENTER);
   getContentPane().add(txtEdit);  
   txtEdit.setColumns(10);
   addWindowListener(new WindowAdapter(){
	   public void WindowClosing(WindowEvent e) {
		   System.exit(0);
	   }
   });
  
   }  
  
   public JTextField getTextField()  
  
   {  
  
	   return txtEdit;     
  
   }  
  
}  