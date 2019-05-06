class AST{//abstract because it serves little use instantialized
    private Statement[] statements;
    public Statement[] getStatements(){
        return this.statements;
    }

    public void setStatements(Statement[] statements){
        this.statements = statements;
    }

    public static interface Node{
        //lets me treat all of the nodes as nodes very easily
    }

    public static class Statement implements AST.Node{
        private Node child;
        public Statement(Node c){
            child = c;
        }
        
        public String toString(){return child.toString();}
    }

    public static class Expression implements AST.Node{
        String value;//temporary design for testing
        public Expression(Token t){value = t.getValue();}
        
        public String toString(){return value;}
    }

    public static class LetStatement implements AST.Node{
        private Identifier name;
        private Expression expr;
        public LetStatement(Identifier n, Expression e){
            name = n;
            expr = e;
        }
        public String toString(){return "let "+name+" = "+expr;}
    }

    public static class Identifier implements AST.Node{
        private Token tok;
        private String value;
        public Identifier(Token t){
            tok = t;
            value = t.getValue();
        }
        
        public String toString(){return value;}
    }

}

