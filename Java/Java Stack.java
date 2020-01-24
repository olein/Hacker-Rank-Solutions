import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);        
		
		while (sc.hasNext()) {
            try{
                Stack<Character> stack = new Stack<Character>(); 
                String input=sc.next();
                
                if(input.length()%2!=0) {
                    System.out.println("false"); 
                    continue;
                }            

                Character[] ch = new Character[input.length()];  
                
                for (int i = 0; i < input.length(); i++) { 
                    ch[i] = input.charAt(i); 
                }     
                
                for (Character c : ch) { 
                    if(c == '(' || c == '{' || c == '[') {
                        stack.push(c);
                    } else {                    
                        Character match = stack.pop();

                        if(c == ')') {
                            if(match != '(') {break;}
                        } else if(c == '}') {
                            if(match != '{') {break;}
                        } else if(c == ']') {
                            if(match != '[') { break;}
                        }
                    }
                }

                if(stack.empty()) System.out.println("true"); 
                else System.out.println("false"); 
            } catch(Exception e) {
                System.out.println("false"); 
            }
		}		
	}
}



