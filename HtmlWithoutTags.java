import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class HtmlWithoutTags {
	 String nextLine;
	 StringBuffer sb = new StringBuffer();
	 String htmlText;
     
       
       public String getText(String str)
       {
    	   try{
    		   
    		   URL url  = new URL(str);
    		   URLConnection urlConn = url.openConnection();
    		   InputStreamReader inStream = new InputStreamReader( 
                           urlConn.getInputStream(), "UTF8");
    		   BufferedReader buff  = new BufferedReader(inStream);

    		   while (true){
    			   nextLine =buff.readLine();  
    			   if (nextLine !=null){
    				   sb.append(" ");
    				   sb.append(nextLine);
    			   }
    			   else{
    				   break;
    			   } 
    		   }
    		   
    		   url = null;
    		   inStream.close();
			   buff.close();
    		   
 
    	   } catch(MalformedURLException e){
    		   System.out.println("Please check the URL:" + 
                                           e.toString() );
    	   } catch(IOException  e1){
    		   System.out.println("Can't read  from the Internet: "+ 
                                          e1.toString() ); 
    	   } 
    	   
    	   String htmlText = sb.toString();
    	   sb.setLength(0);

		   htmlText = htmlText.replaceAll("<script.*?</script>", " ");
		   htmlText = htmlText.replaceAll("<style.*?</style>", " ");
		   htmlText = htmlText.replaceAll("</?[a-z][a-z0-9]*[^<>]*>", " ");
		   htmlText = htmlText.replaceAll("<!--(.|\\s)*?-->", " ");
		   htmlText = htmlText.replaceAll("<!(.|\\s)*?>", " ");
		   htmlText = htmlText.replaceAll("[\t]", " ");
		   htmlText = htmlText.replaceAll("[\r\n]{2,}", "\r\n");
		   htmlText = htmlText.replaceAll("&nbsp;", " ");
		   htmlText = htmlText.replaceAll("[ ]{2,}", " ");
		   
		   
		   return htmlText;
       }
}



