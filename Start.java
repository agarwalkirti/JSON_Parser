package jsonparser;
//Start->{}| {Element}
//Start -> {} | {Element}
import java.util.ArrayList;
public class Start {
	public int matchstart(ArrayList<Character> jsonString,int index) throws ParserException{
		if(jsonString.get(index)!='{')
			throw new ParserException("Missing {"+index);
		index++;
		if(jsonString.get(index)!='}')
		{
			Element e=new Element();
			index=e.matchElement(jsonString,index);
			
		}
		if(jsonString.get(index)!='}')
		throw new ParserException("Missing }"+index);
		//System.out.println("Start index  is "+ index +" and character at this index is "+ jsonString.get(index));
		//index++;
		return index;
	}
}
