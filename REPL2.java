import java.util.Scanner;
public class REPL2{
    public static void main(String[] args){
        //String input = "let x = 5";
        String input = getNext(">>>");
        Node ls = Parser.parseLine(input);
        
        println(ls);
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
