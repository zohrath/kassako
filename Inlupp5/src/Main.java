import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;


public class Main {
    String s = "Hello";


    public static void main(String[] args) {

        StreamTokenizer st = new StreamTokenizer(new StringReader("Mary had 1 little lamb..."));

        try {
            while(st.nextToken() != StreamTokenizer.TT_EOF){

                switch (st.ttype) {
                    case StreamTokenizer.TT_WORD:
                        System.out.println(st.sval);
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println(st.nval);
                        break;
                    case StreamTokenizer.TT_EOL:
                        System.out.println();
                        break;
                }

            }
        } catch (IOException ignored) {

        }

    }
}
