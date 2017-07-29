package jsonparser;
//Element->"Alphanum":Value| "Alphanum":Value,Element
import java.util.ArrayList;
public class Element{
	public int matchElement(ArrayList<Character> jsonString,int index) throws ParserException
	{   
		//System.out.println("In Element before increment of index  is "+ index +" and character at this index is "+ jsonString.get(index));
			if(jsonString.get(index)!='"')
	            throw new ParserException("Json element Missing \" "+index);
		index++;
		
		Terminal t=new Terminal();
		index=t.matchAlphanum(jsonString,index);
		
		if(jsonString.get(index)!=':'){
			//System.out.println("index  is "+ index +" and character at this index is "+ jsonString.get(index));
			throw new ParserException("Json key value pair missing : "+index);
			}	
		index++;
		//System.out.println("Element index  is "+ index +" and character at this index is "+ jsonString.get(index));
		Value v=new Value();
		index=v.matchValue(jsonString,index);
		
		if(jsonString.get(index)==','){
			//Element e=new Element();
			index++;
		    index=matchElement(jsonString, index);
		}
		return index;
	}
    
}
