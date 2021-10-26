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
        if (this.getMTypes().contains("Ones Matrix") || this.getMTypes().contains("Null Matrix")) {
            if (this.getM()[0][0] == 0) {
                for (int i = 0; i < this.getR(); i++) {
                    for (int j = 0; j < this.getC(); j++) {
                        System.out.print(0 + " ");
                    }
                    System.out.println();
                }
            } else if (this.getM()[0][0] == 1) {
                for (int i = 0; i < this.getR(); i++) {
                    for (int j = 0; j < this.getC(); j++) {
                        System.out.print(1 + " ");
                    }
                    System.out.println();
                }
            }
        } else if (!this.getMTypes().contains("Diagonal Matrix")) {
            for (int i = 0; i < this.getR(); i++) {
                for (int j = 0; j < this.getC(); j++) {
                    System.out.print(this.getM()[i][j] + " ");
                }
                System.out.println();
            }
        } else if (this.getMTypes().contains("Diagonal Matrix")) {
            int a = 0;
            if (this.getC() == 2 || this.getC() == 3) {
                for (int i = 0; i < this.getR(); i++) {
                    for (int j = 0; j < this.getC(); j++) {
                        if (i == j) {
                            System.out.print(this.getM()[0][a] + " ");
                            a++;
                        } else {
                            System.out.print(0 + " ");
                        }
                    }
                    System.out.println();
                }
            }
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

    public static void singular(Matrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            if (m.getC() == 2) {
                if (Matrix.determinant2(m) == 0) {
                    m.mTypes.add("Singular Matrix");
                }
            }
            if (m.getC() == 3) {
                if (Matrix.determinant3(m) == 0) {
                    m.mTypes.add("Singular Matrix");
                }
            }
        }
    }

    public static void diagonal(Matrix m) {
        if (m.mTypes.contains("Upper Triangular Matrix") && m.mTypes.contains("Lower Triangular Matrix")) {
            m.mTypes.add("Diagonal Matrix");

            int[][] temp = new int[1][m.getC()];

            if (m.getC() == 2) {
                temp[0][0] = m.getM()[0][0];
                temp[0][1] = m.getM()[1][1];
            } else if (m.getC() == 3) {
                temp[0][0] = m.getM()[0][0];
                temp[0][1] = m.getM()[1][1];
                temp[0][2] = m.getM()[2][2];
            }

            m.setM(temp);
        }
    }

    public static void scalar(Matrix m) {
        if (m.mTypes.contains("Diagonal Matrix")) {
            if (m.getC() == 2) {
                if (m.getM()[0][0] == m.getM()[0][1]) {

                }
            } else if (m.getC() == 3) {
                if ((m.getM()[0][0] == m.getM()[0][1]) && (m.getM()[0][1] == m.getM()[0][1])) {
                    m.mTypes.add("Scalar Matrix");
                }
            }
        }
    }

    public static void identity(Matrix m) {
        if (m.getC() == 1) {
            if (m.getM()[0][0] == 1) {
                m.mTypes.add("Identity Matrix");
            }
        }
        if (m.mTypes.contains("Scalar Matrix")) {
            if (m.getC() == 2) {
                if (m.getM()[0][0] == 1 & m.getM()[0][1] == 1) {
                    m.mTypes.add("Identity Matrix");
                }
            } else if (m.getC() == 3) {
                if (m.getM()[0][0] == 1 & m.getM()[0][1] == 1 && m.getM()[0][2] == 1) {
                    m.mTypes.add("Identity Matrix");
                }
            }
        }

    }

    public static void singleton(Matrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            if (m.getC() == 1) {
                m.mTypes.add("Singleton Matrix");
            }
        }
    }

    public static void ones(Matrix m) {
        boolean check = true;
        for (int i = 0; i < m.getR(); i++) {
            for (int j = 0; j < m.getC(); j++) {
                if (m.getM()[i][j] != 1) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                break;
            }
        }
        if (check) {
            m.mTypes.add("Ones Matrix");
            int[][] temp = new int[1][1];
            temp[0][0] = 1;
            m.setM(temp);
        }
    }

    public static void nullM(Matrix m) {
        boolean check = true;
        for (int i = 0; i < m.getR(); i++) {
            for (int j = 0; j < m.getC(); j++) {
                if (m.getM()[i][j] != 0) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                break;
            }
        }
        if (check) {
            m.mTypes.add("Null Matrix");
            int[][] temp = new int[1][1];
            temp[0][0] = 0;
            m.setM(temp);
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
        Matrix.diagonal(m);
        Matrix.scalar(m);
        Matrix.identity(m);
        Matrix.singleton(m);
        Matrix.ones(m);
        Matrix.nullM(m);
    }
}

public class AP_assignment3 {
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
                System.out.println("Choose a matrix: ");
                for (Matrix matrix : matrices) {
                    System.out.println(matrix.getID() + " : ");
                    matrix.printMatrix();

                }
                int iD = s.nextInt();
                if (matrices.get(iD).getC() == matrices.get(iD).getR()) {
                    if (matrices.get(iD).getC() == 1) {
                        System.out.println("Ans: " + matrices.get(iD).getM()[0][0]);
                    } else if (matrices.get(iD).getC() == 2) {
                        System.out.println("Ans : " + Matrix.determinant2(matrices.get(iD)));
                    } else if (matrices.get(iD).getC() == 3) {
                        System.out.println("Ans : " + Matrix.determinant3(matrices.get(iD)));
                    }
                } else {
                    System.out.println("Not a square Matrix");
                }

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
