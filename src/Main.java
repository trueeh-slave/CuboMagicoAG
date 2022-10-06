import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    //1. Crear el tablero con valores aleatorios
    //2. Definir los padres, utilizando el metodo de generar arrays aleatorios
    //3. Convetir toda la matriz a binario
    //4. Cruzar entre matrices

    /**
     * Criterios
     * - Agarrar padres con un fitness != 0
     * - Hijos mejor que padres
     * - Números no repetidos por cada individuo (las parejas si pueden repetir)
     */

    static int[][] padre1 = new int[3][3];
    static int[][] padre2 = new int[3][3];

    static int[][] hijo = new int[3][3];

    public static void main(String[] args) {
        List<String> binaryStrings = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            padre1 = createTable();
            if (sumArray(padre1) >= 40 && sumArray(padre1) <= 45) {
                System.out.println("----------");
                System.out.println("Array Decimal: " + Arrays.deepToString(padre1));
                System.out.println("Array Binario: " + Arrays.deepToString(decimalToBinary(padre1)));
                System.out.println("String Binario: " + arrayToString(decimalToBinary(padre1)));
                System.out.println("Fitness: " + sumArray(padre1));
                System.out.println("----------");

                if(binaryStrings.size()<6){
//                    binaryStrings.add(arrayToString(decimalToBinary(padre1)));
                }
                counter++;
            }
        }
        System.out.println("Las iteraciones totales son: " + counter);
        System.out.println("Lista: " + binaryStrings.toString());
    }

    public static int[][] createTable() {
        int[][] tablero = new int[3][3];

        for (int i = 0; i < tablero.length; i++) {
            int gen1 = (int) (Math.random() * 8 + 1);
            int gen2 = (int) (Math.random() * 8 + 1);
            int gen3 = (int) (Math.random() * 8 + 1);

            tablero[i] = new int[]{gen1, gen2, gen3};
        }
        return tablero;

//        int[][] tablero = new int[3][3];
//        long[] numerosAleatorios = LongStream.rangeClosed(1, 9).toArray();
//        //desordenando los elementos
//        Random r = new Random();
//        for (int i = numerosAleatorios.length; i > 0; i--) {
//            int posicion = r.nextInt(i);
//            long tmp = numerosAleatorios[i - 1];
//            numerosAleatorios[i - 1] = numerosAleatorios[posicion];
//            numerosAleatorios[posicion] = tmp;
//        }
//        for (int i = 0; i < tablero.length; i++) {
//            int[] row = new int[3];
//            if (i == 0) {
//                for (int j = 0; j < 3; j++) {
//                    row[j] = (int) numerosAleatorios[j];
//                }
//            }
//
//            if (i == 1) {
//                for (int j = 0; j < 3; j++) {
//                    row[j] = (int) numerosAleatorios[j + 3];
//                }
//            }
//
//            if (i == 2) {
//                for (int j = 0; j < 3; j++) {
//                    row[j] = (int) numerosAleatorios[j + 6];
//                }
//            }
//            tablero[i] = row;
//        }
//        return tablero;
    }

    public static String[][] decimalToBinary(int[][] number) {
        String[][] binaries = new String[number.length][number.length];
        for (int i = 0; i < binaries.length; i++) {
            for (int j = 0; j < binaries.length; j++) {
                binaries[i][j] = Integer.toBinaryString(number[i][j]);
                if (binaries[i][j].length() == 1) {
                    binaries[i][j] = "000" + binaries[i][j];
                }
                if (binaries[i][j].length() == 2) {
                    binaries[i][j] = "00" + binaries[i][j];
                }
                if (binaries[i][j].length() == 3) {
                    binaries[i][j] = "0" + binaries[i][j];
                }
            }
        }
        return binaries;
    }

    static int sumArray(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    public static String arrayToString(String[][] a) {
        String returnString = "";
        int column;
        int row;

        for (row = 0; row < a.length; row++) {
            for (column = 0; column < a[0].length; column++) {
                returnString = returnString + "" + a[row][column];
            }
        }
        return returnString;
    }
}