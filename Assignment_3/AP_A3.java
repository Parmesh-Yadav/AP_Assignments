package Assignment_3;

import java.util.ArrayList;
import java.util.Scanner;

abstract class gMatrix {

    abstract void Printm();

    abstract void PrintTypes();

    abstract void getTraspose();

    abstract void getDeterminant();

}

class Nmatrix extends gMatrix {
    private final int R;
    private final int C;
    private int[][] M;
    private final int O;
    private ArrayList<String> mTypes = new ArrayList<>();

    public int getR() {
        return this.R;
    }

    public int getC() {
        return this.C;
    }

    public int[][] getM() {
        return this.M;
    }

    public void setM(int[][] M) {
        this.M = M;
    }

    public int getO() {
        return this.O;
    }

    public ArrayList<String> getMTypes() {
        return this.mTypes;
    }

    public void setMTypes(ArrayList<String> mTypes) {
        this.mTypes = mTypes;
    }

    public Nmatrix(int r, int c) {// temp use
        this.R = r;
        this.C = c;
        this.O = r * c;
        this.M = new int[R][C];
    }

    public Nmatrix(int[][] m) {// normal matrix constructor
        this.R = m.length;
        this.C = m[0].length;
        this.O = this.R * this.C;
        this.M = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                this.M[i][j] = m[i][j];
            }
        }
    }

    @Override
    void Printm() {
        // TODO Auto-generated method stub

    }

    @Override
    void PrintTypes() {
        // TODO Auto-generated method stub

    }

    @Override
    void getTraspose() {
        // TODO Auto-generated method stub

    }

    @Override
    void getDeterminant() {
        // TODO Auto-generated method stub

    }

}

class Dmatrix extends gMatrix {
    private final int R;
    private final int C;
    private int[][] M;
    private final int O;
    private ArrayList<String> mTypes = new ArrayList<>();

    public int getR() {
        return this.R;
    }

    public int getC() {
        return this.C;
    }

    public int[][] getM() {
        return this.M;
    }

    public void setM(int[][] M) {
        this.M = M;
    }

    public int getO() {
        return this.O;
    }

    public ArrayList<String> getMTypes() {
        return this.mTypes;
    }

    public void setMTypes(ArrayList<String> mTypes) {
        this.mTypes = mTypes;
    }

    public Dmatrix(int[][] m) {// normal matrix constructor
        this.R = m.length;
        this.C = m[0].length;
        this.O = this.R * this.C;
        this.M = new int[1][C];
        if (this.getC() == 2) {
            this.getM()[0][0] = m[0][0];
            this.getM()[0][1] = m[1][1];
        } else if (this.getC() == 3) {
            this.getM()[0][0] = m[0][0];
            this.getM()[0][1] = m[1][1];
            this.getM()[0][2] = m[2][2];
        }
    }

    @Override
    void Printm() {
        // TODO Auto-generated method stub

    }

    @Override
    void PrintTypes() {
        // TODO Auto-generated method stub

    }

    @Override
    void getTraspose() {
        // TODO Auto-generated method stub

    }

    @Override
    void getDeterminant() {
        // TODO Auto-generated method stub

    }

}

class ONmatrix extends gMatrix {
    private final int R;
    private final int C;
    private int[][] M;
    private int O;
    private ArrayList<String> mTypes = new ArrayList<>();

    public int getR() {
        return this.R;
    }

    public int getC() {
        return this.C;
    }

    public int[][] getM() {
        return this.M;
    }

    public void setM(int[][] M) {
        this.M = M;
    }

    public int getO() {
        return this.O;
    }

    public void setO(int O) {
        this.O = O;
    }

    public ArrayList<String> getMTypes() {
        return this.mTypes;
    }

    public void setMTypes(ArrayList<String> mTypes) {
        this.mTypes = mTypes;
    }

    public ONmatrix(int[][] m) {// normal matrix constructor
        this.R = m.length;
        this.C = m[0].length;
        this.O = this.R * this.C;
        this.M = new int[1][1];
        this.getM()[0][0] = m[0][0];
    }

    @Override
    void Printm() {
        // TODO Auto-generated method stub

    }

    @Override
    void PrintTypes() {
        // TODO Auto-generated method stub

    }

    @Override
    void getTraspose() {
        // TODO Auto-generated method stub

    }

    @Override
    void getDeterminant() {
        // TODO Auto-generated method stub

    }

}

public class AP_A3 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ArrayList<gMatrix> matrices = new ArrayList<>();

        char choice = 'y';
        while (choice == 'y') {
            // System.out.println("Which type of matrix would you like to create?");
            int tm = s.nextInt();
            switch (tm) {
            case 1:// Take matrices as input and label them with appropriate matrix-types

                break;
            case 2:// Create matrices of requested matrix-types and label them with appropriate
                   // matrix-types.
                break;
            case 3:// Change the elements of a matrix as long as the fixed matrix-type labels
                   // remain valid
                break;
            case 4:// Display all the matrix-type labels of a requested matrix.

                break;
            case 5:// Perform addition, subtraction, multiplication & division.
                break;
            case 6:// Perform element-wise operations
                break;
            case 7:// Transpose matrices

                break;
            case 8:// Inverse matrices.
                break;
            case 9:// Compute means: row-wise mean, column-wise mean, mean of all the elements.
                break;
            case 10:// Compute determinants

                break;
            case 11:// Use singleton matrices as scalars, if requested.
                break;
            case 12:// Compute A+AT for a matrix A.
                break;
            case 13:// Compute Eigen vectors and values.
                break;
            case 14:// Solve sets of linear equations using matrices.
                break;
            case 15:// Retrieve all the existing matrices (entered or created) having requested
                    // matrix-type labels.
                break;
            case 16:
                choice = 'n';
                break;
            }
        }
        s.close();
    }

    public static void instrMenu() {
        System.out.println("1. Take Matrix as Input");
        System.out.println("2. Create Matrix of Requested Type");
        System.out.println("3. Change elements in a Matrix");
        System.out.println("4. Display all matrix types.");
        System.out.println("5. Add, Sub, Mul, Div");
        System.out.println("6. Element wise operations");
        System.out.println("7. Get the Transpose a Matrix");
        System.out.println("8. Get the Inverse a Matrix");
        System.out.println("9. Compute means.");
        System.out.println("10. Compute Determinants");
        System.out.println("11. Use singleton as scalars");
        System.out.println("12. Compute A + AT");
        System.out.println("13. Compute Eigen vectors and Values");
        System.out.println("14. Solve Linear Equations");
        System.out.println("15. Get all matrices of a requested type");
        System.out.println("16. Exit");
    }
}
