import java.util.Scanner;
public class REPL2{//This Time Its Correct
    public static void main(String[] args){
        //String input = "let x = 5";
        String input = getNext(">>>");
        Lexer lex = new Lexer(input);
        Parser par = new Parser(lex);
        println(par.parseProgram());
    }
    
    private static String getNext(String msg){
        print(msg+"\t");
        Scanner scan = new Scanner(System.in);
        String c = "z";
        c = scan.nextLine();
        return c;
    }

    private static <E> void println(E msg){System.out.println(msg);}

    private static <E> void print(E msg){System.out.print(msg);}
}
