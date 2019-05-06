public class Parser{
    Lexer lex;
    private Token curTok;
    private Token peakTok;

    public Parser(Lexer l){
        lex = l;
        peakTok = lex.nextToken();
        nextToken();
    }

    public void nextToken(){
        curTok = peakTok.clone();
        peakTok = lex.nextToken();
    }

    public AST.Statement parseProgram(){
        if(curTok.getType().equals(Token.LET)){
            return new AST.Statement(parseLetStatement());
        }
        return null;
    }

    public AST.LetStatement parseLetStatement(){
        if(peakTok.getType().equals(Token.IDENT)){
            nextToken();
            AST.Identifier ident = new AST.Identifier(curTok);
            nextToken();
            if(!curTok.getType().equals(Token.ASSIGN)){return null;}
            nextToken();
            AST.Expression expr = new AST.Expression(curTok);
            return new AST.LetStatement(ident,expr);
        }
        else{return null;}
    }
}
