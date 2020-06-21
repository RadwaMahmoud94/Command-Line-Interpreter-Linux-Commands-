
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;



public class Terminal {
	public String Path;
	File file;
	public Terminal() {
		Path=System.getProperty("user.dir");
		file=new File(Path);
	}
	
public String cp(String sourcePath,String destinatuinPath) throws IOException {

	
	int ind=sourcePath.lastIndexOf("\\");
	String filename="";
	
	if(ind==-1) {
		filename=sourcePath;
		sourcePath=Path;
	}
	else {
		filename=sourcePath.substring(ind+1, sourcePath.length());
		sourcePath=sourcePath.substring(0,ind);
	}
	
	String checkPath=sourcePath;
	File checkFile=new File(checkPath);
	if(checkFile.exists() && checkFile.isDirectory()) {
		
		checkFile=new File(sourcePath+"\\"+filename);
		
		if(checkFile.exists() && !checkFile.isDirectory()) {
			int ind2=destinatuinPath.lastIndexOf("\\");
			String filename2="";
			
			if(ind2==-1) {
				filename2=destinatuinPath;
				destinatuinPath=Path;
			}
			else {
				filename2=destinatuinPath.substring(ind2+1, destinatuinPath.length());
				destinatuinPath=destinatuinPath.substring(0,ind2);
			}
		
			String checkPath2=destinatuinPath;
			File checkFile2=new File(checkPath2);
			
			if(checkFile2.exists() && checkFile2.isDirectory()) {
				checkFile2=new File(destinatuinPath+"\\"+filename2);
				if(checkFile2.exists() && !checkFile2.isDirectory()) {
					return "sorry file2 is already exist";
				}
				else {
					if(checkFile2.isDirectory()) {
							checkFile2 = new File(destinatuinPath + "\\" + filename2 +"\\"+filename);
						if(checkFile2.exists()) {
							return "sorry file2 is already exist";
						}
					}
					Files.copy(checkFile.toPath(), checkFile2.toPath());
					return "Copied succedfully";
				}
			}
			else {
				return "This Second Directory is not found";
			}
		}
		else {
			return "This file is not found";
		}
	}
	else {
		return "This Directory is not found";
	}
}


public void exit() {

	System.exit(0);
}

public String mv(String sourcePath,String destinatuinPath) throws IOException {
	int ind=sourcePath.lastIndexOf("\\");
	String filename="";
	
	if(ind==-1) {
		filename=sourcePath;
		sourcePath=Path;
	}
	else {
		filename=sourcePath.substring(ind+1, sourcePath.length());
		sourcePath=sourcePath.substring(0,ind);
	}
	
	String checkPath=sourcePath;
	File checkFile=new File(checkPath);
	if(checkFile.exists() && checkFile.isDirectory()) {
		
		checkFile=new File(sourcePath+"\\"+filename);
		
		if(checkFile.exists() && !checkFile.isDirectory()) {
			int ind2=destinatuinPath.lastIndexOf("\\");
			String filename2="";
			
			if(ind2==-1) {
				filename2=destinatuinPath;
				destinatuinPath=Path;
			}
			else {
				filename2=destinatuinPath.substring(ind2+1, destinatuinPath.length());
				destinatuinPath=destinatuinPath.substring(0,ind2);
			}
		
			String checkPath2=destinatuinPath;
			File checkFile2=new File(checkPath2);
			if(checkFile2.exists() && checkFile2.isDirectory()) {
				checkFile2=new File(destinatuinPath+"\\"+filename2);
				if(checkFile2.exists() && !checkFile2.isDirectory()) {
					return "sorry file2 is already exist";
				}
				else {
					if(checkFile2.isDirectory()) {
						checkFile2=new File(destinatuinPath+"\\"+filename2+"\\"+filename);
						if(checkFile2.exists()) {
							return "sorry file2 is already exist";
						}
					}
					Files.move(checkFile.toPath(), checkFile2.toPath(),StandardCopyOption.REPLACE_EXISTING);
					
					return "Moved succedfully";
				}
			}
			else {
				return "This Second Directory is not found";
			}
		}
		else {
			return "This file is not found";
		}
	}
	else {
		return "This Directory is not found";
	}

}

public String args() {
	String res="";
	ArrayList<String> CommandParameter=new ArrayList<>();
	CommandParameter.add("pwd\t take 0 args");
	CommandParameter.add("ls\t take 0 args");
	CommandParameter.add("cd\t take 1 args: Path");
	CommandParameter.add("mkdir\t take 1 args: Path");
	CommandParameter.add("rmdir\t take 1 args");
	CommandParameter.add("rm\t take 1 args sourcePath");
	CommandParameter.add("mv\t take 2 args: sourcePath , destinatuinPath");
	CommandParameter.add("clear\t take 0 args");
	CommandParameter.add("more\t take 0 args");
	CommandParameter.add("cp\t take 2 args : sourcePath , destinatuinPath");
	CommandParameter.add("cat\t take 1 or 2 args");
	CommandParameter.add("date\t take 0 args");
	CommandParameter.add("args\t take 0 args");
	CommandParameter.add("help\t take 0 args");
	CommandParameter.add("exit\t take 0 args");

	for(int i=0;i<CommandParameter.size();i++) {
		res+=CommandParameter.get(i);
		res+="\n";
	}
	return res;
}

public String help() {
	String res="";
	ArrayList<String> Commads=new ArrayList<>();
	Commads.add("pwd\t print the current working directory");
	Commads.add("ls\t list files' names in the current Directory");
	Commads.add("cd\t change the current ddirectory to another one");
	Commads.add("mkdir\t make new directory in a given path");
	Commads.add("rmdir\t remove a given directory ");
	Commads.add("rm\t remove specific file");
	Commads.add("mv\t Moves one or more files from one directory to another " +" directory");
	Commads.add("clear\t clear the current terminal screen");
	Commads.add("more\t dispaly and scroll down the output");
	Commads.add("cp\t copy item from specific path to other path");
	Commads.add("cat\t in case 1 args it's dispaly the content of the file, in case of 2 args it's concatinate them ");
	Commads.add("date\t display the current date and time ");
	Commads.add("args\t list all parameters on the command line");
	Commads.add("help\t Provides Help information for commands");
	Commads.add("exit\t Quits the CMD.EXE program (command interpreter).");

	for(int i=0;i<Commads.size();i++) {
		res+=Commads.get(i);
		res+="\n";
	}
	return res;
}

public String ls() {
	String res="";
	
	  String list[];
      list=file.list();
      for(int i=0;i<list.length;i++) {
    	  res+=list[i];
    	  res+="\n";
      }
      return res;
}

public String cat(String path1,String path2) {
	File f1=new File(path1);
	File f2=new File(path2);
	
	if(f1.exists()==false)
	{
		f1=new File(Path+"\\"+path1);
		if(f1.exists()==false) {
			return "Faild to concatinate ,wrong path";
		}
	}
	if(f2.exists()==false)
	{
		f2=new File(Path+"\\"+path2);
		if(f2.exists()==false) {
			return "Faild to concatinate ,wrong path";
			
		}
	}

	if(path2==""&&f1.exists()==true) {
		String Orignal="";

	      try (Scanner input = new Scanner(f1)) {

	          while(input.hasNextLine()){
	              Orignal+=input.nextLine();

	          }

	      } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }
	      return Orignal;
	}
	else if(f1.exists()==false || f2.exists()==false || f2.isDirectory()==true||f1.isDirectory()==true)
	{
		return "Faild to concatinate ,wrong path";
	}

	String Orignal="";
	try (Scanner input = new Scanner(f1)) {

        while(input.hasNextLine()){
            Orignal+=input.nextLine();

        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

	try (Scanner input = new Scanner(f2)) {

        while(input.hasNextLine()){
            Orignal+=input.nextLine();

        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
	return Orignal;

}

public String mkdir(String sourcePath) {
	
	int ind=sourcePath.lastIndexOf("\\");
	String filename="";
	
	if(ind==-1) {
		filename=sourcePath;
		sourcePath=Path;
	}
	else {
		filename=sourcePath.substring(ind+1, sourcePath.length());
		sourcePath=sourcePath.substring(0,ind);
	}
	
	String checkPath=sourcePath;
	File checkFile=new File(checkPath);
	if(checkFile.exists() && checkFile.isDirectory()) {
		checkFile=new File(sourcePath+"\\"+filename);
		if(checkFile.exists()) {
			return "This Directory is already exist";
		}
		else {
			checkFile.mkdir();
			return "This Directory is added";
		}
	}
	else {
		return "This Directory is not found to create directory in it";
	}
	
}

public String rm(String sourcePath) {
	File checkFile=new File(sourcePath);

	if(checkFile.exists()==false || checkFile.isDirectory()==true)
	{
		checkFile=new File(Path+"\\"+sourcePath);
		if(checkFile.exists()==false || checkFile.isDirectory()==true)
		{
		return "Faild to delete the file ,wrong path";
		}
	}
	checkFile.delete();
	return "File deleted successfully ";
}

public void clear () {
	for (int y = 0; y < 1000; y++)
		System.out.println("\n");

}

public String cd(String sourcePath) {
	
	if(sourcePath.equals("")) {

    	Path=System.getProperty("user.dir") ;
    	file=new File(Path);
    	return "Directory changed to deafult Directory";
    }
	
	
	String checkPath=sourcePath;
	File check=new File(sourcePath);
	
	if(check.exists()==false) {
		check=new File(Path+"\\"+sourcePath);
	}
	
	if(check.exists() && check.isDirectory())
	{
		Path=checkPath;
		file=new File(Path);
		Path=""+file.getAbsoluteFile();
		return "Directory changed to "+file.getAbsolutePath();
	}
	else if(check.exists()) {
		
		return "Failed to change because its file not directory";
	}
    
	return "Failed to change Directory";
}

public String pwd() {
/*
      String Working_Directory = null;
	try {
		Working_Directory = new java.io.File( "." ).getCanonicalPath();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
*/
      return "The current working Directory "+Path;

}

public String date() {

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	return dateFormat.format(cal.getTime());

}

public String rmdir(String SourcePath) {

	File check=new File(SourcePath);
	if(check.exists()==false)
	{
		check=new File(Path+"\\"+SourcePath);
		if(check.exists()==false) {
	
	         return "The system cannot find the path specified.";
		}
	}

	    	if(check.isDirectory()==true){

	    		if(check.list().length==0){

	    		   check.delete();
	    		   return "Directory is deleted successfully";
	    		}
	    		else {
	    			return "Faild to delete the directory not empty";
	    		}
	    	}
	    	else {
	    		return "Faild to delete because it is file not directory";
	    	}
	    }


public String more (String SourcePath) {
	File check=new File(SourcePath);
	if(check.exists()==false)
	{
		check=new File(Path+"\\"+SourcePath);
		if(check.exists()==false) {
	         return "The system cannot find the path specified.";
		}
	}
	if(check.isDirectory()) {
        return "Faild to get the file beacuse it is directory";
	}
	
	ArrayList<String> Lines=new ArrayList<>();

    try (Scanner input = new Scanner(check)) {

        while(input.hasNextLine()){
            Lines.add(input.nextLine());
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    
    Scanner input=new Scanner(System.in);
    String res="";
	for(int i=0;i<Lines.size();i++) {
		if((i+1)%6==0) {
			System.out.println("if you want to print next 5 lines please enter y or enter n to stop print ");
			if(input.next().equals("y")) {
				continue;
			}
			else {
				return res;
			}
		}
		res+=Lines.get(i);
		//input.close();
	}
	return res;
}
}