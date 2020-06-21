import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
	
	String []args;
	String cmd;
	String redirectingFile;
	
	public Parser()
	{
		redirectingFile="";
		args=new String[2];
		args[0]="";
		args[1]="";
	}
	
	public boolean parse(String input)
	{
		boolean isParsed=false;
		int index=-1;
		ArrayList<String> parsedInput=new ArrayList<String>();
		ArrayList<String> copyCommands=new ArrayList<String>(Arrays.asList("clear","cd", "ls", "cp", "mv", "rm",
			"mkdir", "rmdir", "cat", "more", "pwd","date","help","args","exit"));
		String word="";
		for(int i=0;i<input.length();i++)
		{
			
			if(input.charAt(i)!=' ' && i<input.length()-1)
				word+=input.charAt(i);
			else if(i==input.length()-1)
			{
				word+=input.charAt(i);
				parsedInput.add(word);
			}
			else
			{
				parsedInput.add(word);
				word="";
			}
		}
		
		for(int i=0;i<parsedInput.size();i++)
		{
			if(i==0 && copyCommands.contains(parsedInput.get(i)))
			{
				cmd=parsedInput.get(i);
				isParsed=true;
			}
			else if(i==0)
			{
				return false;
			}
			else if(parsedInput.get(i).equals(">>"))
			{
				redirectingFile=parsedInput.get(i+1);
			}
			else if(index<args.length-1)
			{
				args[++index]=parsedInput.get(i);
			}
		}
		
		return isParsed;
	}
	
}
