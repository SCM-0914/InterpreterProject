import java.util.Scanner;
public class RandomTester{
    public static void main(String[] args){
        Node.StatementNode s = new Node.StatementNode("huh");
        println(s.getName());
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
