class Solution {
    public int maximumGain(String s, int x, int y) {
        int score =0;
        Stack<Character> stack = new Stack<>();

        int i=0;
        
        while(i<s.length()){
            if(x>=y){
                score+=stackFunction(stack,"ab",s.charAt(i),x);
            }else{
                score+=stackFunction(stack,"ba",s.charAt(i),y);
            }
            i++;
        }
        StringBuilder newString = new StringBuilder();
        while(!stack.isEmpty()){
            newString.append(stack.peek());
            stack.pop();
        }
        s = newString.reverse().toString();
                System.out.println(s);

        i=0;    
        while(i<s.length()){
            if(x>=y){
                score+=stackFunction(stack,"ba",s.charAt(i),y);
            }else{
                score+=stackFunction(stack,"ab",s.charAt(i),x);
            }
            i++;
        }

        return score;
    }

    static int stackFunction(Stack<Character> stack, String sub,char a,int x){
        if(stack.isEmpty()){
            stack.push(a);
            return 0;
        }
        char top = stack.peek();
        
        String ab = ""+top+a;
        
        if(ab.equals(sub)){
            stack.pop();
            System.out.println(x);
            return x;
        }else{
            stack.push(a);
            return 0;
        }
    }
}