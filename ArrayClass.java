package jsonparser;
// Array->Value| Value,Array| Null
import java.util.ArrayList;

public class ArrayClass {
	public int matchArray(ArrayList<Character> jsonString,int index) throws ParserException{
	    if(jsonString.get(index) != ']')
	    {
	    	Value v=new Value();
	    	index=v.matchValue(jsonString, index);
	        	
	    while(jsonString.get(index) != ']')
	    {
	      if(jsonString.get(index) != ','){
	    	  throw new ParserException("Missing array closing brace ] or , "+index);
	    	
	    }
	      index++;
	      if(index>=jsonString.size())
		        throw new ParserException("Missing closing ] for some array "+index);
	         Value v1=new Value();
	        index=v1.matchValue(jsonString, index);
	      }
	    }
	    if(jsonString.get(index) != ']'){
	    	throw new ParserException("Missing array closing brace ] "+index);
	    }
	    index++;
	    return index;
	}
}
