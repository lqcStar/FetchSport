package liuquancai_1809070016;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Test4 extends JFrame implements ActionListener,Runnable{
	JButton btn_start;
	JButton btn_stop;
	Thread th;
	JPanel jp;
	JLabel label;
	boolean a = true;
	
	public Test4(){
		this.setBounds(200,200,400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jp = new JPanel(null);
		//jp.setBounds(0,0,400,400);
		
		th = new Thread(this);
		
		label = new JLabel("刘全才_1809070016",SwingConstants.CENTER);
		label.setFont(new Font("黑体",Font.BOLD,20));
		label.setForeground(Color.red);
		label.setBounds(180,0,200,100);
		jp.add(label);
		
		
		btn_start = new JButton("开始");
		btn_start.setBounds(0,340,60,20);
		btn_stop = new JButton("结束");
		btn_stop.setBounds(70,340,60,20);
		jp.add(btn_start);
		jp.add(btn_stop);
		btn_start.addActionListener(this);
		btn_stop.addActionListener(this);
		
		this.add(jp);
		this.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			for(int i = 180; i > 0; i -= 10){	
				label.setLocation(i,180 - i);
				try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						break;
						}
				}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_start){
			if(!th.isAlive()){
				th = new Thread(this);
				th.start();
				//a = true;
			}
		}
		else if(e.getSource() == btn_stop){
			th.interrupt();
			//a = false;
		}
	}
	
	public static void main(String[] args){
		new Test4();
	}

}
