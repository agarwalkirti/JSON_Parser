package jsonparser;
//Alphanum -> <String>
//constant->null | true | false | <number>
import java.util.ArrayList;

public class Terminal {
	public int matchAlphanum(ArrayList<Character> jsonString,int index) throws ParserException{
		while(jsonString.get(index) != '"')
		{  
			if(jsonString.get(index)=='\\')
				index++;
			
			index++;
			if(index>=jsonString.size())
		        throw new ParserException("Missing closing \" "+index);
		}
		index++;
		return index;
	}
	public int matchConstant(ArrayList<Character> jsonString,int index) throws ParserException{
		switch(jsonString.get(index))
		{
			case 'n':
			 if(jsonString.get(index+1)!='u'
		     || jsonString.get(index+2)!='l'
		     || jsonString.get(index+3)!='l')
		     throw new ParserException("Expecting 'string' 'number' 'null' 'true' 'false' ' ' ' ' got 'undefined'"+index);
			 index=index+4;
		     break;
		case 't':
			 //System.out.println("Terminal index  is "+ index +" and character at this index is "+ jsonString.get(index));
			 if(jsonString.get(index+1)!='r' ||
		     jsonString.get(index+2)!='u' ||
		     jsonString.get(index+3)!='e')
		     throw new ParserException("Expecting 'string' 'number' 'null' 'true' 'false' ' ' ' ' got 'undefined'"+index);
			 //System.out.println("Element index  is "+ index +" and character at this index is "+ jsonString.get(index));
			 index=index+4;
			 //System.out.println("Element index  is "+ index +" and character at this index is "+ jsonString.get(index));
			 break;
		case 'f':
			 if(jsonString.get(index+1)!='a' ||
		     jsonString.get(index+2)!='l' ||
		     jsonString.get(index+3)!='s' ||
		     jsonString.get(index+4)!='e')
		     throw new ParserException("Expecting 'string' 'number' 'null' 'true' 'false' ' ' ' ' got 'undefined'"+index);
		     index=index+5;
		     break;     
		case '-': index++;
		case '0':index++;
		        if(Character.isDigit(jsonString.get(index))){
		        	throw new ParserException("Number is preeced by 0. We cannot preceed digit by 0"+index);
		        }
		        if(jsonString.get(index)=='.'){
		        	do{
		        		index++;
		        	}while(Character.isDigit(jsonString.get(index)));
		        }
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': while(Character.isDigit(jsonString.get(index))){
			index++;
		     }
			break;
		default: 
			//System.out.println("index  is "+ index +" and character at this index is "+ jsonString.get(index));
			throw new ParserException("Expecting 'string' 'number' 'null' 'true' 'false' ' ' ' ' got 'undefined'"+index);
		}
		return index;
	}
}
	
	
