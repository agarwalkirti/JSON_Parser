package jsonparser;
//Value->"Alphanum"| {Element}| [Array]| Constant
import java.util.ArrayList;
public class Value {
	public int matchValue(ArrayList<Character> jsonString,int index) throws ParserException{
		switch(jsonString.get(index)){
		case '{':
			Start s=new Start();
			index=s.matchstart(jsonString, index);
			 if(jsonString.get(index)!='}')
				 {
				 System.out.println("Value index  is "+ index +" and character at this index is "+ jsonString.get(index));
				 throw new ParserException("Missing } flower braces inside array "+index);
				 }
			 index++;
			break;
		case '[':
			index++;
			ArrayClass a=new ArrayClass();
		    index=a.matchArray(jsonString, index);
		    break;
		case '"':
			index++;
			Terminal t=new Terminal();
			index=t.matchAlphanum(jsonString,index);
		    break;
		default:
			Terminal t1=new Terminal();
			index=t1.matchConstant(jsonString,index);
		    break;
		}
		return index;
	}
}
