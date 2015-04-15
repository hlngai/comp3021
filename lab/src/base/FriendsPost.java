package base;
import java.util.Date;

public class FriendsPost extends Post{
	private User friend;
	

	public FriendsPost(Date date,String content,User friend)
	{
		/**
		 * as in superclass: Post, there don't constructor which need no parameter
		 * but as default, a non para constructor will be called in a subclass constructor
		 * therefore, without creating a non parameter constructor, super(para) should be declared explictly
		 * 
		 */
		super(date,content);
		this.friend=friend;			
	}
	public String toString()
	{
		return friend.toString()+"\n"+super.toString();
	}

}
