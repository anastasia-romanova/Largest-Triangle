public class LargestTriangle {
    
    public static void main(String[] args) {
        ReaderInAndCalc readerInAndCalc = new ReaderInAndCalc();
        WriteOut writeOut = new WriteOut();

        try {
            String inTxt = args[0];
            readerInAndCalc.calc(inTxt);

            String outTxt = args[1];
            writeOut.recorder(outTxt, readerInAndCalc.getOutText());
        } catch (ArrayIndexOutOfBoundsException e)  {
            System.out.println( "Введено неверное количество файлов. \n" +
                    "Введите, пожалуйста, имена двух фалов: входного и выходного. \n" +
                    "Пример: my-program in.txt out.txt \n" ) ;
        }
    }
}