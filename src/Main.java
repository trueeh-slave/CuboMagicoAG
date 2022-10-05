import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

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
        padre1 = createTable();
        padre2 = createTable();

        System.out.println(Arrays.deepToString(padre1));
        System.out.println(Arrays.deepToString(decimalToBinary(padre1)));
//        System.out.println(Arrays.toString(Arrays.deepToString(decimalToBinary(padre1)).split("")));
        System.out.println("Fitness: " + fitness(padre1));
        System.out.println("--------------------------------------------");
//        System.out.println(Arrays.deepToString(padre2));
//        System.out.println(Arrays.deepToString(decimalToBinary(padre2)));
//        System.out.println("Fitness: "+fitness(padre2));

    }

    public static int[][] createTable() {
        int[][] tablero = new int[3][3];
        long[] numerosAleatorios = LongStream.rangeClosed(1, 9).toArray();
        //desordenando los elementos
        Random r = new Random();
        for (int i = numerosAleatorios.length; i > 0; i--) {
            int posicion = r.nextInt(i);
            long tmp = numerosAleatorios[i - 1];
            numerosAleatorios[i - 1] = numerosAleatorios[posicion];
            numerosAleatorios[posicion] = tmp;
        }
        for (int i = 0; i < tablero.length; i++) {
            int[] row = new int[3];
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    row[j] = (int) numerosAleatorios[j];
                }
            }

            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    row[j] = (int) numerosAleatorios[j + 3];
                }
            }

            if (i == 2) {
                for (int j = 0; j < 3; j++) {
                    row[j] = (int) numerosAleatorios[j + 6];
                }
            }
            tablero[i] = row;
        }
        return tablero;
    }

    public static int fitness(int[][] cuadrado) {
        int fitness = 0;
        //comparar filas
        if (cuadrado[0][0] + cuadrado[0][1] + cuadrado[0][2] == 15) fitness++;
        if (cuadrado[1][0] + cuadrado[1][1] + cuadrado[1][2] == 15) fitness++;
        if (cuadrado[2][0] + cuadrado[2][1] + cuadrado[2][2] == 15) fitness++;
        //comparar columnas
        if (cuadrado[0][0] + cuadrado[1][0] + cuadrado[2][0] == 15) fitness++;
        if (cuadrado[0][1] + cuadrado[1][1] + cuadrado[2][1] == 15) fitness++;
        if (cuadrado[0][2] + cuadrado[1][2] + cuadrado[2][2] == 15) fitness++;
        //comparando diagonales
        if (cuadrado[0][1] + cuadrado[1][1] + cuadrado[2][2] == 15) fitness++;
        if (cuadrado[0][2] + cuadrado[1][1] + cuadrado[2][0] == 15) fitness++;

        return fitness;
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

        for (int i = 0; i < binaries.length; i++) {
            System.out.println("a");
            for (int j = 0; j < binaries.length; j++) {
                String[] numbersplit = Arrays.toString(binaries[i][j].split("1")).split("0");
                for(String string : numbersplit) {
                    System.out.println(string);
                }
            }
        }
        return binaries;
    }

}