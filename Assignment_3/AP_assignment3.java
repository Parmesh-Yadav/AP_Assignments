package Assignment_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Matrix {
    private static int nom = 0; // used for creating new unique ID's
    private int ID; // unique ID for every matrix.
    private final int R;
    private final int C;
    private int[][] M;
    private ArrayList<String> mTypes = new ArrayList<>();

    public int getID() {
        return this.ID;
    }

    public int getR() {
        return this.R;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setM(int[][] M) {
        this.M = M;
    }

    public ArrayList<String> getMTypes() {
        return this.mTypes;
    }

    public void setMTypes(ArrayList<String> mTypes) {
        this.mTypes = mTypes;
    }

    public int getC() {
        return this.C;
    }

    public int[][] getM() {
        return this.M;
    }

    public Matrix(int r, int c) {// temp use
        this.R = r;
        this.C = c;
        this.M = new int[R][C];
    }

    public Matrix(int[][] m) {// normal matrix constructor used in task 1
        this.ID = Matrix.nom++;
        this.R = m.length;
        this.C = m[0].length;
        this.M = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                this.M[i][j] = m[i][j];
            }
        }
        Matrix.setType(this);
    }

    public void printMatrix() {
        for (int i = 0; i < this.getR(); i++) {
            for (int j = 0; j < this.getC(); j++) {
                System.out.print(this.getM()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printTypes() {
        System.out.println("Types of the selected matrix are: ");
        if (this.getMTypes().size() != 0) {
            for (int i = 0; i < this.getMTypes().size(); i++) {
                System.out.println(this.getMTypes().get(i));
            }
        }

    }

    public static Matrix Transpose(Matrix m) {
        Matrix T = new Matrix(m.getR(), m.getC());
        for (int i = 0; i < m.getR(); i++) {
            for (int j = 0; j < m.getC(); j++) {
                T.M[j][i] = m.getM()[i][j];
            }
        }
        return T;
    }

    public static int determinant3(Matrix m) {
        int x, y, z;
        x = (m.getM()[0][0] * (m.getM()[1][1] * m.getM()[2][2] - m.getM()[1][2] * m.getM()[2][1]));
        y = (m.getM()[0][1] * (m.getM()[1][0] * m.getM()[2][2] - m.getM()[1][2] * m.getM()[2][0]));
        z = (m.getM()[0][2] * (m.getM()[1][0] * m.getM()[2][1] - m.getM()[1][1] * m.getM()[2][0]));

        return (x - y + z);
    }

    public static int determinant2(Matrix m) {
        int x, y;
        x = (m.getM()[0][0] * m.getM()[1][1]);
        y = (m.getM()[0][1] * m.getM()[1][0]);

        return (x - y);
    }

    public static void squareRec(Matrix m) {
        if (m.C == m.R) {
            m.mTypes.add("Square Matrix");
        } else {
            m.mTypes.add("Rectangular Matrix");
        }
    }

    public static void Row(Matrix m) {
        if (m.R == 1) {
            m.mTypes.add("Row Matrix");
        }
    }

    public static void Column(Matrix m) {
        if (m.C == 1) {
            m.mTypes.add("Column Matrix");
        }
    }

    public static void symmetrix(Matrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            if (Arrays.deepEquals(m.getM(), Matrix.Transpose(m).getM())) {
                m.mTypes.add("Symmetrix Matrix");
            }
        }
    }

    public static void skewSymmetrix(Matrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            Matrix temp = new Matrix(m.getR(), m.getC());
            temp.M = new int[m.getR()][m.getC()];
            // temp.M = m.M;
            for (int i = 0; i < temp.getR(); i++) {
                for (int j = 0; j < temp.getC(); j++) {
                    temp.getM()[i][j] = -m.getM()[i][j];
                }
            }
            if (Arrays.deepEquals(temp.getM(), Matrix.Transpose(m).M)) {
                m.mTypes.add("Skew-Symmetrix Matrix");
            }
        }
    }

    public static void upperT(Matrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            boolean check = true;
            for (int i = 0; i < m.getR(); i++) {
                for (int j = 0; j < m.getC(); j++) {
                    if (i > j) {
                        if (m.getM()[i][j] != 0) {
                            check = false;
                            break;
                        }
                    }
                }
            }
            if (check) {
                m.mTypes.add("Upper Triangular Matrix");
            }

        }
    }

    public static void lowerT(Matrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            boolean check = true;
            for (int i = 0; i < m.getR(); i++) {
                for (int j = 0; j < m.getC(); j++) {
                    if (i < j) {
                        if (m.getM()[i][j] != 0) {
                            check = false;
                            break;
                        }
                    }
                }
            }
            if (check) {
                m.mTypes.add("Lower Triangular Matrix");
            }

        }
    }

    public static void singular(Matrix m){
        if (m.mTypes.contains("Square Matrix")) {
            if(m.getC() == 2){
                if(Matrix.determinant2(m)==0){
                    m.mTypes.add("Singular Matrix");
                }
            }
            if(m.getC() == 3){
                if(Matrix.determinant3(m)==0){
                    m.mTypes.add("Singular Matrix");
                }
            }
        }
    }

    public static void setType(Matrix m) {
        Matrix.squareRec(m);
        Matrix.Row(m);
        Matrix.Column(m);
        Matrix.symmetrix(m);
        Matrix.skewSymmetrix(m);
        Matrix.upperT(m);
        Matrix.lowerT(m);
        Matrix.singular(m);
        // 10. Diagonal Matrix
        // 11. Scalar Matrix
        // 12. Identity Matrix
        // 13. Singleton Matrix
        // 14. Ones Matrix
        // 15. Null Matrix
    }
}

public class AP_assignment3 {
    // the zero matrices are the only matrix, which is both symmetric and
    // skew-symmetric matrix.
    // symm and skew symm doesnt work.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Matrix> matrices = new ArrayList<>();

        char choice = 'y';
        while (choice == 'y') {
            // System.out.println("Which type of matrix would you like to create?");
            int tm = s.nextInt();
            switch (tm) {
            case 1:// Take matrices as input and label them with appropriate matrix-types
                System.out.println("Enter no of rows:");
                int r = s.nextInt();
                System.out.println("Enter no of columns:");
                int c = s.nextInt();
                int[][] m = new int[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        m[i][j] = s.nextInt();
                    }
                }
                matrices.add(new Matrix(m));
                break;
            case 2:// Create matrices of requested matrix-types and label them with appropriate
                   // matrix-types.
                break;
            case 3:// Change the elements of a matrix as long as the fixed matrix-type labels
                   // remain valid
                break;
            case 4:// Display all the matrix-type labels of a requested matrix.
                System.out.println("Choose a matrix: ");
                for (Matrix matrix : matrices) {
                    System.out.println(matrix.getID() + " : ");
                    matrix.printMatrix();

                }
                int Id = s.nextInt();
                matrices.get(Id).printTypes();
                break;
            case 5:// Perform addition, subtraction, multiplication & division.
                break;
            case 6:// Perform element-wise operations
                break;
            case 7:// Transpose matrices
                System.out.println("Choose a matrix: ");
                for (Matrix matrix : matrices) {
                    System.out.println(matrix.getID() + " : ");
                    matrix.printMatrix();

                }
                int id = s.nextInt();
                Matrix trans = Matrix.Transpose(matrices.get(id));
                System.out.println("Ans : ");
                trans.printMatrix();
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
}
