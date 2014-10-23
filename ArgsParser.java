import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


public class ArgsParser {
	
	public ArrayList<String> urlList = new ArrayList<String>();
	public ArrayList<String> words = new ArrayList<String>();
	
	

	public void parse(String[] args)
	{
		if ( args.length > 0)
		{
			File file= new File(args[0]);
			if(file.exists())
			{
				try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));)
				{
				while(true)
				{
					String nextLine = br.readLine();
					if(nextLine != null)
					{
						urlList.add(nextLine);
					}
					else { break; }
				}
				}
				catch (IOException e) {
					System.out.println(e);
				}
			}
			else
			{
				urlList.add(args[0]);
			}
					
			
			if (args.length > 1)
			{
			  String str = "";
				for(int i = 0; i < args[1].length(); i++)
				{
					if(args[1].charAt(i) == ',' )
					{
						words.add(str);
						str = "";
					}
					else
					{
						str = str + args[1].charAt(i);
					}
					if(i == args[1].length() - 1)
					{
						words.add(str);
					}
				}
	          
			}
		}
	}
}
