package test;
import java.io.*;
import java.util.Date;

import base.*;
import blog.*;

public class TestBlog {
	public String getInput()
	{
		String line="";
		System.out.print("Enter the prompt:");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			line=br.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return line;
	}
	public static void main(String[] args)
	{
		TestBlog testBlog=new TestBlog();
		User user=new User(1,"COMP3021","COMP3021@cse.ust.hk");
		Blog myblog=new Blog(user);
		String prompt=null;
		while(!(prompt=testBlog.getInput()).equals("exit"))
		{
			if(prompt.startsWith("list"))
				myblog.list();
			else if(prompt.startsWith("post"))
			{
				Date date=new Date();
				String content=prompt.substring(5);
				Post post=new Post(date,content);
				myblog.post(post);
			}
			else if(prompt.startsWith("delete"))
			{
				String tmp=prompt.substring(7);
				int index=Integer.parseInt(tmp);
				myblog.delete(index);
			}
			
			
		}
	}

}
