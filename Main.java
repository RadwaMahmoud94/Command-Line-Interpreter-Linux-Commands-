import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		Terminal terminal=new Terminal();
		while(true) {
			System.out.print(terminal.Path+": ");
			String Input=scan.nextLine();
			String Inputs[]=Input.split("\\|");
			for(int j=0;j<Inputs.length;j++) {

			Parser parser=new Parser();
			boolean IsVaild=parser.parse(Inputs[j]);
			String Result="";
			if(IsVaild) {
				
				
				if(parser.cmd.equals("clear")){             	//done
					terminal.clear();
				}
				
				else if(parser.cmd.equals("cd")) {				//done	//edited
					Result=terminal.cd(parser.args[0]);
				}
				
				else if(parser.cmd.equals("ls")) {				//done	//edited
					Result=terminal.ls();
				}
				
				else if(parser.cmd.equals("cp")) {				//failed	done
					Result=terminal.cp(parser.args[0], parser.args[1]);
				}
				
				else if(parser.cmd.equals("mv")) {				//failed 	done
					Result=terminal.mv(parser.args[0], parser.args[1]);
				}
				else if(parser.cmd.equals("rm")) {
					Result=terminal.rm(parser.args[0]);			//done	//edited
				}
				else if(parser.cmd.equals("mkdir")) {		//Done	//Edited
					Result=terminal.mkdir(parser.args[0]);
				}
				else if(parser.cmd.equals("rmdir")) {		//Done	//Edited
					Result=terminal.rmdir(parser.args[0]);
				}
				else if(parser.cmd.equals("cat")) {			//Done	//edited
					Result=terminal.cat(parser.args[0],parser.args[1]);
				}
				else if(parser.cmd.equals("more")) {		//Not Make		//done
					Result=terminal.more(parser.args[0]);
				}
				else if(parser.cmd.equals("pwd")) {	      //done 	//edited
					Result=terminal.pwd();
				}
				else if(parser.cmd.equals("args")) {		//done
					Result=terminal.args();
				}
				else if(parser.cmd.equals("date")) {		//done
					Result=terminal.date();
				}
				else if(parser.cmd.equals("help")) {		//done
					Result=terminal.help();
				}
				else if(parser.cmd.equals("exit")){
					terminal.exit();
				}
				
				if(parser.redirectingFile.equals("")) {
					System.out.println(Result);
				}
				else {
					File file=new File(parser.redirectingFile);
					PrintWriter out=new PrintWriter(file);
					for(int i=0;i<Result.length();i++) {
						if(Result.charAt(i)=='\n') {
							out.println();
						}
						else {
							out.print(Result.charAt(i));
						}
					}
					
					out.close();
					
				}
			}
			else {
				System.out.println("Wrong Input");
			}
		}
		
			
	}
		
	}

}
