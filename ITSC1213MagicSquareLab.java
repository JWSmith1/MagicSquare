import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ITSC1213MagicSquareLab {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException
    {
        Scanner scan = new Scanner(new File("magicData.txt"));
        int count = 1; //count which square we're on
        int size = scan.nextInt(); //size of next square

        //Expecting -1 at bottom of input file
        while (size != -1)
        {
            //Creates square based on size given in magicData.txt
            Square magSquare = new Square(size);

            //Read Method from square.java, outputs the data from magicData.txt
            magSquare.readSquare(scan);

            System.out.println("\n******* Square " + count + " *******");
            //Print square
            magSquare.printSquare();

            //Output sum of Rows
            for (int row = 0; row < size; row++) {
                System.out.println("Sum of row at index " + row + " equals " + magSquare.sumRow(row));
            }

            //Output sum of columns
            for (int col = 0; col < size; col++){
                System.out.println("Sum of column at index " + col + " equals " + magSquare.sumRow(col));
            }

            //Output of Diagonal from top left to bottom right
            System.out.println("Sum of Diagonal(Top Left -- Bottom Right: " + magSquare.sumMainDiag());

            //Output of diagonal from top right to bottom left
            System.out.println("Sum of Diagonal(Top Right -- Bottom Left: " + magSquare.sumOtherDiag());


            //Shows whether square is magic or not
            System.out.println("Magic Sqaure? " + magSquare.isMagic());

            //Size of next square in magicData.txt
            size = scan.nextInt();
        }
    }

}
