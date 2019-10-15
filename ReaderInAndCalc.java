import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReaderInAndCalc {
    float largestSqr ;
    int [] topsLargSqr;
    String outText;

    public  void calc (String nameInTxt) {
        try {
            FileReader file = new FileReader( nameInTxt ) ;
            BufferedReader buffer = new BufferedReader( file ) ; // create object BufferedReader for reading fail
            String line = "" ; //Variable to store a string of text

            // Loop to read the contents of a text file into a variable
            while ( ( line = buffer.readLine() ) != null ) {  // Get the line
                try {
                    // Initializing an array with variables
                    int[] topsArr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                    if (topsArr.length == 6){
                        // figuring out if a triangle is isosceles
                        int side1 = (topsArr[2]-topsArr[0])*(topsArr[2]-topsArr[0]) + (topsArr[3]-topsArr[1])*(topsArr[3]-topsArr[1]);
                        if (side1<0) side1= side1*(-1);
                        int side2 = (topsArr[4]-topsArr[2])*(topsArr[4]-topsArr[2]) + (topsArr[5]-topsArr[3])*(topsArr[5]-topsArr[3]);
                        if (side2<0) side2= side2*(-1);
                        int side3 = (topsArr[0]-topsArr[4])*(topsArr[0]-topsArr[4]) + (topsArr[1]-topsArr[5])*(topsArr[1]-topsArr[5]);
                        if (side3<0) side3= side3*(-1);
                        if (side1==side2||side2==side3||side3==side1){
                            // calculate the area of the triangle
                            float sqr = (float)((topsArr[2]-topsArr[0])*(topsArr[5]-topsArr[1])-(topsArr[4]-topsArr[0])*(topsArr[3]-topsArr[1]))/2;
                            if (sqr<0) sqr = sqr*(-1);
                            // check if it is the largest
                            if (sqr > largestSqr) {
                                largestSqr = sqr;
                                topsLargSqr = topsArr;
                            }
                        }
                    }
                } catch (NumberFormatException e) {
 //                   System.out.println( "Введён неверный формат. Введите, пожалуйста, числа." ) ;
                }
            }
            buffer.close() ;
        } catch ( IOException e) {
//            System.out.println( "Произошла ошибка чтения" ) ;
        }
        // remove extra characters so that the coordinates are in the input file format
        String str =  Arrays.toString(topsLargSqr);
        str = str.replace (',' , ' ');
        str = str.replace ('[' , ' ');
        str = str.replace (']' , ' ');
        str = str.trim();
        outText = str;
    }

    public String getOutText () {return outText;}

}
