import java.util.Arrays;

public class Main {
    //1. Crear el tablero con valores aleatorios
    //2. Definir los padres, utilizando el metodo de generar arrays aleatorios
    //3. Convetir toda la matriz a binario
    //4.

    /** Criterios
     *  - Agarrar padres con un fitness != 0
     *  - Hijos mejor que padres
     *  - Números no repetidos por cada individuo (las parejas si pueden repetir)
     */

    static int[][] padre1 = new int[3][3];
    static int[][] padre2 = new int[3][3];

    static int[][] hijo = new int[3][3];

    public static void main(String[] args) {
        padre1 = createTable();
        padre2 = createTable();

        System.out.println(Arrays.deepToString(padre1));
        System.out.println(Arrays.deepToString(decimalToBinary(padre1)));
        System.out.println("Fitness: "+fitness(padre1));
        System.out.println("--------------------------------------------");
        System.out.println(Arrays.deepToString(padre2));
        System.out.println(Arrays.deepToString(decimalToBinary(padre2)));
        System.out.println("Fitness: "+fitness(padre2));

    }

    public static int[][] createTable(){
        int[][] tablero = new int[3][3];

        for(int i=0; i<tablero.length;i++){
            int invidiuo1 = (int) (Math.random()*8+1);
            int invidiuo2 = (int) (Math.random()*8+1);
            int invidiuo3 = (int) (Math.random()*8+1);

            if(invidiuo1 == invidiuo2 || invidiuo2 == invidiuo3 || invidiuo1 == invidiuo3){
                return createTable();
            } else {
                tablero[i] = new int[]{invidiuo1,invidiuo2,invidiuo3};
            }
        }
        return tablero;
    }

    public static int fitness(int[][] cuadrado){
        int fitness = 1;
        //comparar filas
        if(cuadrado[0][0] + cuadrado[0][1] + cuadrado[0][2]==15) fitness++;
        if(cuadrado[1][0] + cuadrado[1][1] + cuadrado[1][2]==15) fitness++;
        if(cuadrado[2][0] + cuadrado[2][1] + cuadrado[2][2]==15) fitness++;
        //comparar columnas
        if(cuadrado[0][0] + cuadrado[1][0] + cuadrado[2][0]==15) fitness++;
        if(cuadrado[0][1] + cuadrado[1][1] + cuadrado[2][1]==15) fitness++;
        if(cuadrado[0][2] + cuadrado[1][2] + cuadrado[2][2]==15) fitness++;
        //comparando diagonales
        if(cuadrado[0][1] + cuadrado[1][1] + cuadrado[2][2]==15) fitness++;
        if(cuadrado[0][2] + cuadrado[1][1] + cuadrado[2][0]==15) fitness++;

        return fitness;
    }

    public static String[][] decimalToBinary(int[][] number){
        String[][] binaries = new String[padre1.length][padre1.length];
        for(int i=0;i<binaries.length;i++){
            for(int j=0; j<binaries.length;j++){
                binaries[i][j] = Integer.toBinaryString(number[i][j]);
                if(binaries[i][j].length() == 1){
                    binaries[i][j] = "000"+binaries[i][j];
                }
                if(binaries[i][j].length() == 2){
                    binaries[i][j] = "00"+binaries[i][j];
                }
                if(binaries[i][j].length() == 3){
                    binaries[i][j] = "0"+binaries[i][j];
                }
            }
        }
        return binaries;
    }
}