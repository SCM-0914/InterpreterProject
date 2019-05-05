public class Token{
    /*
    //keywords
    public static final String LET = "LET";         // Saved because i am changing the tokens below
    public static final String TRUE = "TRUE";       // to match their code representations
    public static final String FALSE = "FALSE";     // as all other tokens do, accept 2 odd cases,
    public static final String IF = "IF";           // but idk if thats what i want to do
    public static final String ELSE = "ELSE";       // so im doing this
    public static final String RETURN = "RETURN";   // hopefully i dont need these
    */

    public static final String ILLEGAL = "ILLEGAL";
    public static final String EOF= "EOF";
    // Identifiers + literals
    public static final String IDENT = "IDENT";// add, foobar, x, y, ...
    public static final String INT = "INT";// 1343456
    // Operators
    public static final String ASSIGN = "=";
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String ASTERISK = "*";
    public static final String SLASH = "/";
    //Tests
    public static final String EQUAL = "==";
    public static final String GT = ">";
    public static final String LT = "<";
    public static final String BANG = "!";
    public static final String GTEQUAL = ">=";
    public static final String LTEQUAL = "<=";
    public static final String NOTEQUAL = "!=";
    // Delimiters
    public static final String COMMA = ",";
    public static final String PERIOD = ".";
    public static final String SEMICOLON = ";";
    public static final String LPAREN = "(";
    public static final String RPAREN = ")";
    public static final String LBRACE = "{";
    public static final String RBRACE = "}";
    // Keywords
    public static final String FUNCTION = "func";
    public static final String LET = "let";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String IF = "if";
    public static final String ELSE = "else";
    public static final String RETURN = "return";

    public static final String[] allTokens = {ILLEGAL,EOF,IDENT,INT,ASSIGN,PLUS,MINUS,ASTERISK,SLASH,EQUAL,GT,LT,BANG,
            GTEQUAL,LTEQUAL,NOTEQUAL,COMMA,PERIOD,SEMICOLON,LPAREN,RPAREN,LBRACE,RBRACE,FUNCTION,LET,TRUE,FALSE,IF,ELSE,RETURN};

    private String type;
    private String value;
    public Token(String typ, String val){
        this.type = typ;
        this.value = val;
    }

    public String getType(){return type;}
    
    public String getValue(){return value;}

    public String toString(){
        return ("Token: "+type+" , "+value);
    }
    
    public boolean equals(Token tok){return this.toString().equals(tok.toString());}
}
