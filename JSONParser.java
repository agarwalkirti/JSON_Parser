package jsonparser;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.IOException;

public class JSONParser {

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("src/jsonparser/file.txt");
		int i;
		char c;
        ArrayList<Character> jsonlist= new ArrayList<Character>();
       // while(fr.read()!='\0')   
        while((i=fr.read())!=-1)
        {	
        	c=(char)i;
           if(!Character.isWhitespace(c))
        	jsonlist.add(c);
        }
        System.out.println(jsonlist);
        fr.close();
        try{
        	Start s=new Start();
        	int index=s.matchstart(jsonlist,0);
        	if(index+1==jsonlist.size())
        	System.out.println("Valid JSON");
        	else
        		System.out.println("Invalid Valid JSON");
        }
        catch(ParserException e){
        System.out.println(e.getMessage());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
	}

}
