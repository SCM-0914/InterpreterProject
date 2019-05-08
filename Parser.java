;public class Parser{
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

    public boolean curTokenIs(String t){
        return curTok.getType().equals(t);
    }

    public boolean peakTokenIs(String t){
        return peakTok.getType().equals(t);
    }

    public boolean expectPeak(String t){
        if(peakTokenIs(t)){
            nextToken();
            return true;
        }
        return false;
    }

    public AST.Program parseProgram(){
        AST.Program prgm = new AST.Program();

        while(!curTokenIs(Token.EOF)){//parse until at the end of file;
            if(curTokenIs(Token.LET)){
                prgm.append(new AST.Statement(parseLetStatement()));
            }
            else{

                RuntimeException e = new RuntimeException("Invalid Statement Found: "+curTok);
                throw e;
            }
        }
        return prgm;
    }

    public AST.LetStatement parseLetStatement(){
        if(expectPeak(Token.IDENT)){
            AST.Identifier ident = new AST.Identifier(curTok);
            nextToken();
            if(!curTokenIs(Token.ASSIGN)){
                
                RuntimeException e = new RuntimeException("Not A Statement: "+curTok);
                throw e;
                //return null;
            }
            AST.Expression expr = parseExpression();//new AST.Expression(curTok);
            return new AST.LetStatement(ident,expr);
        }
        else{
            System.out.println(curTok);
            RuntimeException e = new RuntimeException("No Identifier: "+curTok);
            throw e;
            //return null;
        }
    }

    public AST.Expression parseExpression(){
        AST.Expression expr = new AST.Expression(curTok);
        nextToken();
        while(!curTokenIs(Token.SEMICOLON)){
            expr = new AST.Expression(curTok);
            if(peakTokenIs(Token.EOF)){
                RuntimeException e = new RuntimeException("Reached end of file while parsing: "+curTok);
                throw e;
            }
            nextToken();
        }
        nextToken();
        return expr;
    }
}
