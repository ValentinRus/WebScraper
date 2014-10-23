import java.util.ArrayList;


public class Scraper {

	public static void main(String[] args) {

		
		ArgsParser argsParser = new ArgsParser();
		HtmlWithoutTags hwt = new HtmlWithoutTags();
		argsParser.parse(args);
		int[][] resultW = new int[argsParser.urlList.size()][argsParser.words.size()];
		int[] resultC = new int[argsParser.urlList.size()];
		int[] resultForAllW = new int[argsParser.words.size()];
		int resultForAllC = 0;
		Calculator calc = new Calculator();
		
		for(int i=0; i < argsParser.urlList.size(); i++)
		{
			for(int j=0; j < argsParser.words.size(); j++)
			{	
				
				if(args[2].equals("–w") || args[3].equals("–w") || args[4].equals("–w") || args[5].equals("–w"))
				{
					resultW[i][j] = calc.calcWords(hwt.getText(argsParser.urlList.get(i)), argsParser.words.get(j));
					resultForAllW[j] = resultForAllW[j] + resultW[i][j];
				}

			}
			if(args[2].equals("–c") || args[3].equals("–c") || args[4].equals("–c") || args[5].equals("–c"))
			{
			resultC[i] = calc.calcChars(hwt.getText(argsParser.urlList.get(i)));
			resultForAllC = resultForAllC + resultC[i];
			}
		}
		
		
		for(int i=0; i < argsParser.urlList.size(); i++)
		{
			System.out.println(argsParser.urlList.get(i)+" : ");
		
			for(int j=0; j < argsParser.words.size(); j++)
			{
				if(args[2].equals("–w") || args[3].equals("–w") || args[4].equals("–w") || args[5].equals("–w"))
				{
				System.out.println(argsParser.words.get(j)+"  -----  "+resultW[i][j]+" times.");
				}
			}
			if(args[2].equals("–c") || args[3].equals("–c") || args[4].equals("–c") || args[5].equals("–c"))
			{
			System.out.println("Character  -----  "+resultC[i]+"\n");
			}
		}
		
		System.out.println("for all URLs:");
		
		for(int i=0; i < argsParser.words.size(); i++)
		{
			if(args[2].equals("–w") || args[3].equals("–w") || args[4].equals("–w") || args[5].equals("–w"))
			{
			System.out.println(argsParser.words.get(i)+"  -----  "+resultForAllW[i]);
			}
		}
		
		if(args[2].equals("–c") || args[3].equals("–c") || args[4].equals("–c") || args[5].equals("–c"))
		{
		System.out.println("Character  -----  "+resultForAllC);
		}
	}
}

