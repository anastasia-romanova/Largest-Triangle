import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOut {
    public  void recorder ( String nameOutTxt, String outText ) {
        try {
            FileWriter file = new FileWriter( nameOutTxt ) ;
            BufferedWriter buffer = new BufferedWriter( file ) ; // BufferedWriter object to write a file
            buffer.write( outText ) ; // create a new file with the received data
            buffer.close() ;
        } catch ( IOException e ) {
            System.out.println( "Произошла ошибка записи" ) ;
        }
    }
}