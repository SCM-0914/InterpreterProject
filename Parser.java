public class Parser{
    public Parser(){
        
    }

    public static Node parseLine(String in){
        Lexer lex = new Lexer(in);
        if(lex.nextToken().getType().equals(Token.LET)){
            return parseLetStatement(lex);
        }
        else{return null;}
    }
    
    private static Node.LetStatement parseLetStatement(Lexer lex){
        if(!lex.peakToken().getType().equals(Token.IDENT)){
            return null;
        }
        Node.StatementNode var = new Node.StatementNode(lex.nextToken().getValue());
        if(!lex.nextToken().getType().equals(Token.ASSIGN)){
            return null;
        }
        
        Node.ExpressionNode expr = new Node.ExpressionNode(lex.nextToken().getValue());
        return new Node.LetStatement(var,expr);
    }
}
