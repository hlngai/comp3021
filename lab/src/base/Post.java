package base;
import java.util.Date;
import java.io.*;

public class Post implements Comparable<Post>,Serializable{
	private Date date;
	private String content;
	
/*	public Post()
	{
		
	}
	*/
	public Post(Date date,String content)
	{
		this.date=date;
		this.content=content;
	}
	public String getContent()
	{
		String tmp=this.content;
		return tmp;
	}
	public Date getDate()
	{
		Date tmp=this.date;
		return tmp;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	public void setDate(Date date)
	{
		this.date=date;
	}
@Override
	public String toString()
	{
		String fs="["+date.toString()+"]\n"+content;
		return fs;
	}
@Override
	public boolean equals(Object o)
	{
		if(o!=this)
		{
			Post post=(Post)o;
			
			if(this.date==post.date && this.content==post.content)
				return true;
			else
				return false;
		}
		else
			return false;
		
	}
@Override
	public int hashCode()
	{
		int hashCode=0;
		hashCode=2*date.hashCode()+content.hashCode();
		return hashCode;
	}
	public boolean contains(String keyword)
	{
		int clen=this.content.length();
		int klen=keyword.length();
		int i=0,j=0;
		for(;i<klen && j<clen;j++)
		{
			if(keyword.charAt(i)==this.content.charAt(j))
				i++;
		}
		if(i==klen)
			return true;
		else
			return false;
	}
@Override
	public int compareTo(Post p)
	{
		return this.date.compareTo(p.date);
	}

}
