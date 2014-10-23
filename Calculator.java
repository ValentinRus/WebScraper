import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
	
	public int calcChars(String str)
	{
		String chars= str.replaceAll(" ", "");
		int charsNumbers = chars.length();
		return charsNumbers;
	}
	public int calcWords(String htmlText, String word)
	{
		int count = 0;
		    Pattern p = Pattern.compile("\\b"+word+"\\b", Pattern.UNICODE_CASE|Pattern.CASE_INSENSITIVE);
		    Matcher m = p.matcher(htmlText);
		    while(m.find()) count++;
		return count;
	}
}
