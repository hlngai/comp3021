package frame;
import blog.*;
import base.*;

import java.util.Date;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Framework {
	private JFrame mainFrame;
	private JPanel postPanel;	//new
	private JTextArea postTextArea,postContent;		//new
//	private JTextField postContent=new JTextField();
	private JButton refresh=new JButton("refresh");
	private JButton post=new JButton("post");
	private JLabel text1;
	private Blog myBlog=new Blog(new User(1, "A", "a@cse.ust.hk"));

	public Framework()
	{
		
	}
	public void setGUI()
	{
		// construct frame 
		mainFrame=new JFrame("Micro Blog Demo");
		mainFrame.setSize(800,1000);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//label
		text1=new JLabel("You can still input 140 characters");
		
		//postContent
		postContent=new JTextArea("Here is my post");
		postContent.setEditable(false);
		
		
		/*
		 * layout
		 */
		
		postPanel=new JPanel();
		postPanel.setLayout(new GridLayout(2,1));
		postPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//p2
		
		JPanel p2=new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(text1,BorderLayout.NORTH);
		
		postTextArea=new JTextArea(80,80);
		postTextArea.setWrapStyleWord(true);
		postTextArea.setLineWrap(true);
		postTextArea.setEditable(true);
		p2.add(postTextArea,BorderLayout.CENTER);
		System.out.println(postTextArea.getText().length());
		
		//p3
		JPanel p3=new JPanel();
		p3.setLayout(new GridLayout(1,2));
		p3.add(refresh);
		p3.add(post);
		
		//p3 is added to p2
		p2.add(p3,BorderLayout.SOUTH);
		
		postPanel.add(p2);
		postPanel.add(postContent);
		
		mainFrame.add(postPanel);
		mainFrame.pack();
		
		postTextArea.addKeyListener(new lengthListener());
		post.addActionListener(new postListener());
		refresh.addActionListener(new refreshListener());
		
		

	}
	class postListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String content=postTextArea.getText();
			if(content.length()==0)
				postContent.setText("the post cannot be empty");
			else if(content.length()>140)
				postContent.setText("the content of the post should be less or equal to 140");
			else 
			{
				myBlog.post(new Post(new Date(),content));
				String savefilepath="/Users/samngai/"+myBlog.getUser()+".blog";
				myBlog.save(savefilepath);
				postTextArea.setText("");
				postContent.setText(content);
			}
			text1.setText("You can still input 140 characters");
			
		}
	}
	class refreshListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			postTextArea.setText("");
			myBlog.load("/Users/samngai/"+myBlog.getUser()+".blog");
			int size=myBlog.blogSize();
			postContent.setText("");
			for(int i=0;i<size;i++)
			{
				postContent.append(myBlog.getPostContent_Date(i)+"\n");
			}
			text1.setText("You can still input 140 characters");
		}
	}
	class lengthListener implements KeyListener
	{
		public void keyTyped(KeyEvent e)
		{
			
		}
		public void keyPressed(KeyEvent e)
		{
			
		}
		public void keyReleased(KeyEvent e)
		{
			int Length=postTextArea.getText().length();
			String s=new String();
			if(Length<=140 && Length >=0)
				s=String.format("You can still input %d characters",140-Length);
			else if(Length>140)
				s="Your post length has exceeded length 140!!!";
			text1.setText(s);
			
		}
	}
	public static void main(String[] args)
	{
		Framework framework=new Framework();
		framework.setGUI();
	}


}
