package Assignment_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

abstract class gMatrix {

    abstract void Printm();

    abstract void PrintTypes();

    abstract int[][] GetTraspose();

    abstract int GetDeterminant();

    public static void printArr(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.println(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArr(float[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.println(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] sumM(int[][] m, int[][] n) {// assuming order of both arrays are same...
        int[][] temp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                temp[i][j] = m[i][j] + n[i][j];
            }
        }

        return temp;
    }

    public static int[][] diffM(int[][] m, int[][] n) {// assuming order of both arrays are same...
        int[][] temp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                temp[i][j] = m[i][j] - n[i][j];
            }
        }

        return temp;
    }

    public static int[][] mullM(int[][] m, int[][] n) {
        int[][] temp = new int[m.length][n[0].length];
        for (int i = 9; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = 0;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                for (int k = 0; k < m[0].length; k++) {
                    temp[i][j] += m[i][k] * n[k][j];
                }
            }
        }

        return temp;
    }

    public static int deter(int[][] m, int n) {
        int d = 0;
        if (m.length == 1) {
            return m[0][0];
        }
        int[][] t = new int[m.length][m.length];
        int s = 1;
        for (int i = 0; i < m.length; i++) {
            gMatrix.coFactorE(m, t, 0, i, n);
            d += s * m[0][i] * gMatrix.deter(t, n - 1);
            s = -s;
        }
        return d;
    }

    public static void coFactorE(int[][] m, int[][] t, int q, int r, int n) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (i != q && j != r) {
                    t[a][b++] = m[i][j];
                    if (b == n - 1) {
                        b = 0;
                        a++;
                    }
                }
            }
        }
    }

    public static void adjointM(int[][] m, int[][] adjoint) {
        if (m.length == 1) {
            adjoint[0][0] = 1;
            return;
        }
        int s = 1;
        int[][] t = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                gMatrix.coFactorE(m, t, i, j, m.length);
                s = ((i + j) % 2 == 0) ? 1 : -1;
                adjoint[i][j] = (s) * (gMatrix.deter(t, m.length - 1));
            }
        }
    }

    public static float[][] inverseM(int[][] m, int determinant) {
        float[][] inverse = new float[m.length][m.length];
        int[][] adjoint = new int[m.length][m.length];
        gMatrix.adjointM(m, adjoint);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                inverse[i][j] = adjoint[i][j] / (float) determinant;
            }
        }

        return inverse;
    }

}

class Cmatrix extends gMatrix {
    private final int R;
    private final int C;
    private int[][] M;
    private final int O;
    private ArrayList<String> mTypes = new ArrayList<>();

    public Cmatrix(int[][] m) {// normal matrix constructor
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

    @Override
    public void Printm() {
        // TODO Auto-generated method stub

    }

    @Override
    public void PrintTypes() {
        // TODO Auto-generated method stub

    }

    public int[][] getTraspose(int[][] m) {
        int[][] temp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                temp[j][i] = m[i][j];
            }
        }
        return temp;

    }

    public int getDeterminant(int[][] m) {
        if (m[0].length == 3) {
            int x, y, z;
            x = (m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1]));
            y = (m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0]));
            z = (m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]));
            return (x - y + z);
        } else if (m[0].length == 2) {
            int x, y;
            x = (m[0][0] * m[1][1]);
            y = (m[0][1] * m[1][0]);
            return (x - y);
        } else {
            return m[0][0];
        }
    }

    public static void squareRec(Cmatrix m) {
        if (m.C == m.R) {
            m.mTypes.add("Square Matrix");
        } else {
            m.mTypes.add("Rectangular Matrix");
        }
    }

    public static void Row(Cmatrix m) {
        if (m.R == 1) {
            m.mTypes.add("Row Matrix");
        }
    }

    public static void Column(Cmatrix m) {
        if (m.C == 1) {
            m.mTypes.add("Column Matrix");
        }
    }

    public static void symmetrix(Cmatrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            if (Arrays.deepEquals(m.getM(), m.getTraspose(m.getM()))) {
                m.mTypes.add("Symmetrix Matrix");
            }
        }
    }

    public static void skewSymmetrix(Cmatrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            int[][] temp = new int[m.getR()][m.getC()];
            for (int i = 0; i < m.getR(); i++) {
                for (int j = 0; j < m.getC(); j++) {
                    temp[i][j] = -m.getM()[i][j];
                }
            }
            if (Arrays.deepEquals(temp, m.getTraspose(m.getM()))) {
                m.mTypes.add("Skew-Symmetrix Matrix");
            }
        }
    }

    public static void upperT(Cmatrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            if (!(m.getR() == 1 && m.getC() == 1)) {
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
    }

    public static void lowerT(Cmatrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            if (!(m.getR() == 1 && m.getC() == 1)) {
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
    }

    public static void singular(Cmatrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            if (m.getDeterminant(m.getM()) == 0) {
                m.mTypes.add("Singular Matrix");
            }
        }
    }

    public static void diagonal(Cmatrix m) {
        if (m.mTypes.contains("Upper Triangular Matrix") && m.mTypes.contains("Lower Triangular Matrix")) {
            m.mTypes.add("Diagonal Matrix");
        }
    }

    public static void scalar(Cmatrix m) {
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

    public static void identity(Cmatrix m) {
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

    public static void singleton(Cmatrix m) {
        if (m.mTypes.contains("Square Matrix")) {
            if (m.getC() == 1) {
                m.mTypes.add("Singleton Matrix");
            }
        }
    }

    public static void ones(Cmatrix m) {
        if (m.getR() == 1 && m.getC() == 1) {
        }
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
            if (m.getR() == 1 && m.getC() == 1) {
                return;
            } else {
                m.mTypes.add("Ones Matrix");
            }
        }
    }

    public static void nullM(Cmatrix m) {
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
        }
    }

    public static void setType(Cmatrix m) {
        Cmatrix.squareRec(m);
        Cmatrix.Row(m);
        Cmatrix.Column(m);
        Cmatrix.symmetrix(m);
        Cmatrix.skewSymmetrix(m);
        Cmatrix.upperT(m);
        Cmatrix.lowerT(m);
        Cmatrix.singular(m);
        Cmatrix.diagonal(m);
        Cmatrix.scalar(m);
        Cmatrix.identity(m);
        Cmatrix.singleton(m);
        Cmatrix.ones(m);
        Cmatrix.nullM(m);
    }

    @Override
    int GetDeterminant() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    int[][] GetTraspose() {
        // TODO Auto-generated method stub
        return null;
    }

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

    public Nmatrix(int[][] m, ArrayList<String> mtypes) {// normal matrix constructor
        this.R = m.length;
        this.C = m[0].length;
        this.O = this.R * this.C;
        this.M = new int[R][C];
        this.mTypes = mtypes;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                this.M[i][j] = m[i][j];
            }
        }
    }

    @Override
    public void Printm() {
        for (int i = 0; i < this.getR(); i++) {
            for (int j = 0; j < this.getC(); j++) {
                System.out.print(this.getM()[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void PrintTypes() {
        for (int i = 0; i < this.getMTypes().size(); i++) {
            System.out.println(this.getMTypes().get(i));
        }
    }

    @Override
    public int[][] GetTraspose() {
        int[][] m = this.getM();
        int[][] temp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                temp[j][i] = m[i][j];
            }
        }
        gMatrix.printArr(temp);
        return temp;
    }

    @Override
    public int GetDeterminant() {
        if (this.getC() == 3) {
            int x, y, z;
            x = (this.getM()[0][0] * (this.getM()[1][1] * this.getM()[2][2] - this.getM()[1][2] * this.getM()[2][1]));
            y = (this.getM()[0][1] * (this.getM()[1][0] * this.getM()[2][2] - this.getM()[1][2] * this.getM()[2][0]));
            z = (this.getM()[0][2] * (this.getM()[1][0] * this.getM()[2][1] - this.getM()[1][1] * this.getM()[2][0]));
            return (x - y + z);
        } else if (this.getC() == 2) {
            int x, y;
            x = (this.getM()[0][0] * this.getM()[1][1]);
            y = (this.getM()[0][1] * this.getM()[1][0]);
            return (x - y);
        } else {
            return this.getM()[0][0];
        }

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

    public Dmatrix(int[][] m, ArrayList<String> mtypes) {// normal matrix constructor
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
        this.mTypes = mtypes;
    }

    @Override
    public void Printm() {
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

    @Override
    public void PrintTypes() {
        for (int i = 0; i < this.getMTypes().size(); i++) {
            System.out.println(this.getMTypes().get(i));
        }

    }

    @Override
    public int[][] GetTraspose() {
        this.Printm();
        return this.getM();

    }

    @Override
    public int GetDeterminant() {
        int ans = 1;
        int i = 0;
        for (int j = 0; j < this.getC(); j++) {
            ans = ans * this.getM()[i][j];
        }
        return ans;

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

    public ONmatrix(int[][] m, ArrayList<String> mtypes) {// normal matrix constructor
        this.R = m.length;
        this.C = m[0].length;
        this.O = this.R * this.C;
        this.M = new int[1][1];
        this.getM()[0][0] = m[0][0];
        this.mTypes = mtypes;
    }

    @Override
    public void Printm() {
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
    }

    @Override
    public void PrintTypes() {
        for (int i = 0; i < this.getMTypes().size(); i++) {
            System.out.println(this.getMTypes().get(i));
        }

    }

    @Override
    public int[][] GetTraspose() {
        this.Printm();
        return this.getM();

    }

    @Override
    public int GetDeterminant() {
        return 0;

    }

}

public class AP_A3 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ArrayList<gMatrix> matrices = new ArrayList<>();

        char choice = 'y';
        while (choice == 'y') {
            // System.out.println("Which type of matrix would you like to create?");
            instrMenu();
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
                Cmatrix n = new Cmatrix(m);
                Cmatrix.setType(n);
                if (n.getMTypes().contains("Diagonal Matrix") && n.getMTypes().contains("Null Matrix")) {
                    matrices.add(new ONmatrix(m, n.getMTypes()));
                } else if (n.getMTypes().contains("Diagonal Matrix")) {
                    matrices.add(new Dmatrix(m, n.getMTypes()));
                } else if (n.getMTypes().contains("Ones Matrix") || n.getMTypes().contains("Null Matrix")) {
                    matrices.add(new ONmatrix(m, n.getMTypes()));
                } else {
                    matrices.add(new Nmatrix(m, n.getMTypes()));
                }

                break;
            case 2:// Create matrices of requested matrix-types and label them with appropriate matrix-types.
                typeOfMMenu();
                int o = s.nextInt();
                switch(o){
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
                    case 6://Skew Symmetric Matrix
                        break;
                    case 7://Upper Triangular Matrix
                        break;
                    case 8://Lower Triangular Matrix
                        break;
                    case 9://Singular Matrix
                        break;
                    case 10://Diagonal Matrix
                        break;
                    case 11://Scalar Matrix
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
                break;
            case 3:// Change the elements of a matrix as long as the fixed matrix-type labels remain valid
                break;
            case 4:// Display all the matrix-type labels of a requested matrix.
                System.out.println("Choose a matrix: ");
                printMatrices(matrices);
                int Id = s.nextInt();
                matrices.get(Id).PrintTypes();
                break;
            case 5:// Perform addition, subtraction, multiplication & division.
                addSubMulDivmenu();
                int C =s.nextInt();
                switch (C) {
                    case 1://addition
                        break;
                    case 2://subtraction
                        break;
                    case 3://multiplication
                        break;
                    case 4://division
                        break;
                }
                break;
            case 6:// Perform element-wise operations
                break;
            case 7:// Transpose matrices
                System.out.println("Choose a matrix: ");
                printMatrices(matrices);
                int id = s.nextInt();
                matrices.get(id).GetTraspose();
                break;
            case 8:// Inverse matrices.
                break;
            case 9:// Compute means: row-wise mean, column-wise mean, mean of all the elements.
                break;
            case 10:// Compute determinants
                System.out.println("Choose a matrix: ");
                printMatrices(matrices);
                int iD = s.nextInt();
                System.out.println("Ans: " + matrices.get(iD).GetDeterminant());

                break;
            case 11:// Use singleton matrices as scalars, if requested.
                break;
            case 12:// Compute A+AT for a matrix A.
                break;
            case 13:// Compute Eigen vectors and values.
                break;
            case 14:// Solve sets of linear equations using matrices.
                break;
            case 15:// Retrieve all the existing matrices (entered or created) having requested matrix-type labels.
                break;
            case 16:
                choice = 'n';
                break;
            }
        }
        s.close();
    }

    public static void printMatrices(ArrayList<gMatrix> matrices) {
        for (int i = 0; i < matrices.size(); i++) {
            System.out.println(i + ": ");
            matrices.get(i).Printm();
        }
    }

    public static void instrMenu() {
        System.out.println("Choose an option>>");
        System.out.println("1. Take Matrix as Input");
        System.out.println("2. Create Matrix of Requested Type");
        System.out.println("3. Change elements in a Matrix");
        System.out.println("4. Display all matrix types.");
        System.out.println("5. Add, Sub, Mul, Div");
        System.out.println("6. Element wise operations");
        System.out.println("7. Get the Transpose of a Matrix");
        System.out.println("8. Get the Inverse of a Matrix");
        System.out.println("9. Compute means.");
        System.out.println("10. Compute Determinants");
        System.out.println("11. Use singleton as scalars");
        System.out.println("12. Compute A + AT");
        System.out.println("13. Compute Eigen vectors and Values");
        System.out.println("14. Solve Linear Equations");
        System.out.println("15. Get all matrices of a requested type");
        System.out.println("16. Exit");
    }

    public static void addSubMulDivmenu() {
        System.out.println("Choose an option>>");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
    }

    public static void typeOfMMenu(){
        System.out.println("Choose an option>>");
        System.out.println("1. Rectangular Matrix");
        System.out.println("2. Row Matrix");
        System.out.println("3. Column Matrix");
        System.out.println("4. Square Matrix");
        System.out.println("5. Symmetric Matrix");
        System.out.println("6. Skew Symmetric Matrix");
        System.out.println("7. Upper Triangular Matrix");
        System.out.println("8. Lower Triangular Matrix");
        System.out.println("9. Singular Matrix");
        System.out.println("10. Diagonal Matrix");
        System.out.println("11. Scalar Matrix");
        System.out.println("12. Identity Matrix");
        System.out.println("13. Singleton Matrix");
        System.out.println("14. Ones Matrix");
        System.out.println("15. Null Matrix");
    }
}
