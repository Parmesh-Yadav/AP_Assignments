package Assignment_3;

import java.util.ArrayList;
import java.util.Scanner;

class Matrix{
    private static int nom = 0; // used for creating new unique ID's
    private final int ID; //unique ID for every matrix.
    private final int R;
    private final int C;
    private final int[][] M;
    private ArrayList<String> mTypes;



    public int getID() {
        return this.ID;
    }


    public int getR() {
        return this.R;
    }


    public int getC() {
        return this.C;
    }


    public int[][] getM() {
        return this.M;
    }



    public Matrix(int[][] m){//normal matrix constructor
        this.ID = Matrix.nom++;
        this.R = m.length;
        this.C = m[0].length;
        this.M = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                this.M[i][j] = m[i][j];
            }
        }
    }

    public void printMatrix(){
        for(int i=0;i<this.R;i++){
            for(int j=0;j<this.C;j++){
                System.out.println(this.M[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void setType(){
        // 1. Rectangular Matrix
        // 2. Row Matrix
        // 3. Column Matrix
        // 4. Square Matrix
        // 5. Symmetric Matrix
        // 6. Skew-symmetric Matrix
        // 7. Upper-triangular Matrix
        // 8. Lower-triangular Matrix
        // 9. Singular Matrix
        // 10. Diagonal Matrix
        // 11. Scalar Matrix
        // 12. Identity Matrix
        // 13. Singleton Matrix
        // 14. Ones Matrix
        // 15. Null Matrix
    }
}


public class AP_assignment3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Which type of matrix would you like to create?");
        ArrayList<Matrix> matrices = new ArrayList<>();
        
        char choice = 'y';
        while (choice == 'y'){
            System.out.println("Which type of matrix would you like to create?");
            int tm = s.nextInt();
            switch (tm) {
                case 1://Rectangular Matrix
                    break;
                case 2://Row Matrix
                    break;
                case 3://Column Matrix
                    break;
                case 4://Square Matrix
                    break;
                case 5://Symmetric Matrix
                    break;
                case 6://Skew-symmetric Matrix
                    break;
                case 7://Upper-triangular Matrix
                    break;
                case 8://Lower-triangular Matrix
                    break;
                case 9://Singular Matrix
                    break;
                case 10://Diagonal Matrix
                    break;
                case 11:// Scalar Matrix
                    break;
                case 12://Identity Matrix
                    break;
                case 13://Singleton Matrix
                    break;
                case 14://Ones Matrix
                    break;
                case 15://Null Matrix
                    break;

            }
        }


        s.close();

    }
}
