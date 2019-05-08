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

    public AST.Program parseProgram(){
        AST.Program prgm = new AST.Program();
        //write boolean methods for expected tokens, then add while loop here;
        if(curTok.getType().equals(Token.LET)){
            prgm.append(new AST.Statement(parseLetStatement()));
        }
        else{
            RuntimeException e = new RuntimeException("Invalid Statement");
            throw e;
        }
        return prgm;
    }

    public AST.LetStatement parseLetStatement(){
        if(peakTok.getType().equals(Token.IDENT)){
            nextToken();
            AST.Identifier ident = new AST.Identifier(curTok);
            nextToken();
            if(!curTok.getType().equals(Token.ASSIGN)){
                RuntimeException e = new RuntimeException("Not A Statement");
                throw e;
                //return null;
            }
            nextToken();
            AST.Expression expr = new AST.Expression(curTok);
            return new AST.LetStatement(ident,expr);
        }
        else{
            RuntimeException e = new RuntimeException("No Identifier");
            throw e;
            //return null;
        }
    }
}
