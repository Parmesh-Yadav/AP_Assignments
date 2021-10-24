package Assignment_3;

import java.util.ArrayList;
import java.util.Scanner;

class Matrix {
    private static int nom = 0; // used for creating new unique ID's
    private final int ID; // unique ID for every matrix.
    private final int R;
    private final int C;
    private int[][] M;
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

    public Matrix(int[][] m) {// normal matrix constructor
        this.ID = Matrix.nom++;
        this.R = m.length;
        this.C = m[0].length;
        this.M = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                this.M[i][j] = m[i][j];
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < this.R; i++) {
            for (int j = 0; j < this.C; j++) {
                System.out.println(this.M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setType() {
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
        while (choice == 'y') {
            System.out.println("Which type of matrix would you like to create?");
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

            }
        }
        s.close();

    }
}
