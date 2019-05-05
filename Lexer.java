import java.util.HashMap;
public class Lexer{
    private String input;//The input that needs to be lexed
    private int position=0;//current position
    private int readPosition=0;//next position to read
    private char ch;//current character;

    public Lexer(String in){
        input = in;

    }

    public void readChar(){
        if(readPosition >= input.length()){
            ch = 0;
        }
        else{
            ch = input.charAt(readPosition);
        }
        position = readPosition;
        readPosition++;
    }

    public char peakChar(){
        if(readPosition >= input.length()){
            return 0;
        }
        else{
            return input.charAt(readPosition);
        }
    }

    public Token peakToken(){
        return new Lexer(input.substring(readPosition)).nextToken();
    }

    public void eatWhitespace(){
        while(ch == ' '){
            readChar();
        }
    }

    public boolean isLetter(char character){
        if(('a'<=character && character<='z') || ('A'<=character && character<='Z') || character == '_'){
            return true;
        }
        return false;
    }

    public boolean isLetterOrNumber(char character){
        return isLetter(character) || isNumber(character);//t allows variables with numbers
    }

    public boolean isNumber(char character){
        if(('0'<=character && character<='9')){
            return true;
        }
        return false;
    }

    public Token nextToken(){
        readChar();
        eatWhitespace();
        String type = Token.ILLEGAL;//assume illegal until proven otherwise (insert bad joke about courts or something);
        String val = ch+"";

        //special cases
        if(isLetter(ch)){
            String str = "";
            do{
                str+=ch;
                if(isLetter(peakChar())){
                    readChar();
                }else{break;}
            }while(isLetterOrNumber(ch));
            type =  Token.IDENT;
            for(String tok : Token.allTokens){
                if(str.equals(tok)){
                    type = tok;
                    break;
                }
            }

            val = str;
        }
        else if(isNumber(ch)){
            String str = "";
            do{
                str+=ch;
                if(isNumber(peakChar())){
                    readChar();
                }else{break;}
            }while(isNumber(ch));
            type =  Token.INT;
            for(String tok : Token.allTokens){
                if(str.equals(tok)){
                    type = tok;
                    break;
                }
            }
            val = str;
        }
        else if(ch == '='){
            if(peakChar() == '='){
                readChar();
                type = Token.EQUAL;
                val = "==";
            }
            else{type = Token.ASSIGN;}
        }
        else if(ch == '<'){
            if(peakChar() == '='){
                readChar();
                type = Token.LTEQUAL;
                val = "<=";
            }
            else{type = Token.LT;}
        }
        else if(ch == '>'){
            if(peakChar() == '='){
                readChar();
                type = Token.GTEQUAL;
                val = ">=";
            }
            else{type = Token.GT;}
        }
        else if(ch == '!'){
            if(peakChar() == '='){
                readChar();
                type = Token.NOTEQUAL;
                val = "!=";
            }
            else{type = Token.BANG;}
        }
        else if(ch == 0){type = Token.EOF;}
        else{//not special cases
            for(String tok : Token.allTokens){
                if(tok.charAt(0) == ch){
                    type = tok;
                    break;
                }
            }
        }

        /*
        else if(ch == '+'){type = Token.PLUS;}
        else if(ch == '-'){type = Token.MINUS;}
        else if(ch == '*'){type = Token.ASTERISK;}
        else if(ch == '/'){type = Token.SLASH;}
        else if(ch == ','){type = Token.COMMA;}
        else if(ch == '.'){type = Token.PERIOD;}
        else if(ch == ';'){type = Token.SEMICOLON;}
        else if(ch == '('){type = Token.LPAREN;}
        else if(ch == ')'){type = Token.RPAREN;}
        else if(ch == '{'){type = Token.LBRACE;}
        else if(ch == '}'){type = Token.RBRACE;}
        //*/
        return new Token(type,val);
    }

}
