import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Advent2020_Day_3 {

    public static void main (String[] args) throws IOException {
        String fileName = "input";
        char[][] hill = getMatrix(fileName);
        int result = getResult(hill);
        System.out.println(result);


        long temp = 64*71*68*40;
        System.out.println(284*temp);
    }

    public static int getLength (String fileName) throws IOException {
        int length = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.readLine() != null) {
            length++;
        }
        bufferedReader.close();
        return length;
    }

    public static char[][] getMatrix (String fileName) throws IOException {
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        int fileLength = getLength(fileName);
        String tempString = input.nextLine();
        int stringLength = tempString.length();
        char[][] matrix = new char[fileLength][stringLength];
        int i = 0;
        int k = 0;
        while (input.hasNext()) {
            String fileLine = input.nextLine();
            char[] temp = fileLine.toCharArray();
            for (int j = 0; j < stringLength; j++) {
                matrix[i][j] = temp[j];
            }
            i++;
        }
        return matrix;
    }

    public static int getResult(char[][] matrix) {
        int result = 0;
        int j = 1;
        for (int i = 1; i < matrix.length; i += 2) {
            if (j == 31)
                j = 0;
            else if (j == 32)
                j = 1;
            else if (j == 33)
                j = 2;
            else if (j == 34)
                j = 3;
            else if (j == 35)
                j = 4;
            else if (j == 36)
                j = 5;
            else if (j == 37)
                j = 6;
            if (matrix[i][j] == '#') {
                result++;
            }
            j += 1;
        }
        return result;
    }
}
