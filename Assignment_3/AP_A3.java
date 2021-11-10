package Assignment_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

abstract class gMatrix {

    abstract void Printm();

    abstract void PrintTypes();

    abstract int[][] GetTraspose();

    abstract int GetDeterminant();

    abstract int[][] getArr();

    abstract int[][] getM();

    abstract ArrayList<String> getMTypes();

    public static void getMofTypes(ArrayList<gMatrix> matrices, String s) {
        for (gMatrix m : matrices) {
            if (m.getMTypes().contains(s)) {
                m.Printm();
                System.out.println();
            }
        }
    }

    public static void printArr(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArr(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rowWiseMean(int[][] m) {
        double mean = 0;
        int d = m[0].length;
        for (int i = 0; i < m.length; i++) {
            mean = 0.0;
            for (int j = 0; j < m[0].length; j++) {
                mean += m[i][j];
            }
            mean = mean / d;
            System.out.println("Mean of " + (i + 1) + " row is: " + mean);
        }
    }

    public static void colWiseMean(int[][] m) {
        double mean = 0;
        int d = m.length;
        for (int i = 0; i < m.length; i++) {
            mean = 0.0;
            for (int j = 0; j < m[0].length; j++) {
                mean += m[j][i];
            }
            mean = mean / d;
            System.out.println("Mean of " + (i + 1) + " column is: " + mean);
        }
    }

    public static void allMean(int[][] m) {
        double mean = 0;
        int d = m.length * m[0].length;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                mean += m[j][i];
            }
        }
        mean = mean / d;
        System.out.println("Mean of all the elements in the matrix is: " + mean);
    }

    public static int[][] sumScM(int m, int[][] n) {
        int[][] temp = new int[n.length][n[0].length];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                temp[i][j] = m + n[i][j];
            }
        }

        return temp;
    }

    public static int[][] diffScM(int m, int[][] n) {
        int[][] temp = new int[n.length][n[0].length];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                temp[i][j] = n[i][j] - m;
            }
        }

        return temp;
    }

    public static int[][] mullScM(int m, int[][] n) {
        int[][] temp = new int[n.length][n[0].length];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                temp[i][j] = n[i][j] * m;
            }
        }

        return temp;
    }

    public static double[][] divdScM(int m, int[][] n) {
        double[][] temp = new double[n.length][n[0].length];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                temp[i][j] = n[i][j] / (double) m;
            }
        }

        return temp;
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

    public static int[][] mullMe(int[][] m, int[][] n) {// assuming order of both arrays are same...
        int[][] temp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                temp[i][j] = m[i][j] * n[i][j];
            }
        }

        return temp;
    }

    public static double[][] divdMe(int[][] m, int[][] n) {// assuming order of both arrays are same...
        double[][] temp = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                temp[i][j] = m[i][j] / (double) n[i][j];
            }
        }

        return temp;
    }

    public static int[][] mullM(int[][] m, int[][] n) {
        int[][] temp = new int[m.length][n[0].length];
        for (int i = 0; i < temp.length; i++) {
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

    public static double[][] mullM(int[][] m, double[][] n) {// m * n(double)
        double[][] temp = new double[m.length][n[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = 0;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                for (int k = 0; k < m[0].length; k++) {
                    temp[i][j] += (double) m[i][k] * n[k][j];
                }
            }
        }

        return temp;
    }

    public static double[][] mullMdf(double[][] m, int[][] n) {// m(double) * n
        double[][] temp = new double[m.length][n[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = 0;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                for (int k = 0; k < m[0].length; k++) {
                    temp[i][j] += m[i][k] * (double) n[k][j];
                }
            }
        }

        return temp;
    }

    public static double[][] inverseM(int[][] m, int d) {
        double[][] inverse = new double[m.length][m.length];
        if (m.length == 3) {
            inverse = gMatrix.inverseM3(m, d);
        } else if (m.length == 2) {
            inverse = gMatrix.inverseM2(m, d);
        } else {
            inverse = gMatrix.inverseM1(m, d);
        }
        return inverse;
    }

    public static double[][] inverseM3(int[][] m, int d) {
        double[][] inverse = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[i][j] = ((m[(i + 1) % 3][(j + 1) % 3] * m[(i + 2) % 3][(j + 2) % 3])
                        - (m[(i + 1) % 3][(j + 2) % 3] * m[(i + 2) % 3][(j + 1) % 3])) / (double) d;
            }
        }
        return inverse;
    }

    public static double[][] inverseM2(int[][] m, int d) {
        double[][] inverse = new double[2][2];
        inverse[0][0] = (m[1][1]) / (double) d;
        inverse[1][1] = (m[0][0]) / (double) d;
        inverse[0][1] = -(m[0][1]) / (double) d;
        inverse[1][0] = -(m[1][0]) / (double) d;
        return inverse;
    }

    public static double[][] inverseM1(int[][] m, int d) {
        double[][] inverse = new double[1][1];
        inverse[0][0] = 1 / (double) m[0][0];
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

    @Override
    public int[][] getM() {
        return this.M;
    }

    public void setM(int[][] M) {
        this.M = M;
    }

    public int getO() {
        return this.O;
    }

    @Override
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

    public static int[][] getTraspose(int[][] m) {
        int[][] temp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                temp[j][i] = m[i][j];
            }
        }
        return temp;

    }

    public static double[][] getTraspose(double[][] m) {
        double[][] temp = new double[m.length][m[0].length];
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
            if (Arrays.deepEquals(m.getM(), Cmatrix.getTraspose(m.getM()))) {
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
            if (Arrays.deepEquals(temp, Cmatrix.getTraspose(m.getM()))) {
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
                if (m.getM()[0][0] == m.getM()[1][1]) {
                    m.mTypes.add("Scalar Matrix");
                }
            } else if (m.getC() == 3) {
                if ((m.getM()[0][0] == m.getM()[1][1]) && (m.getM()[1][1] == m.getM()[2][2])) {
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
                if (m.getM()[0][0] == 1 & m.getM()[1][1] == 1) {
                    m.mTypes.add("Identity Matrix");
                }
            } else if (m.getC() == 3) {
                if (m.getM()[0][0] == 1 & m.getM()[1][1] == 1 && m.getM()[2][2] == 1) {
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

    @Override
    int[][] getArr() {
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

    @Override
    public int[][] getM() {
        return this.M;
    }

    public void setM(int[][] M) {
        this.M = M;
    }

    public int getO() {
        return this.O;
    }

    @Override
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
        int[][] temp = new int[m[0].length][m.length];
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

    @Override
    public int[][] getArr() {
        return this.getM();
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

    @Override
    public int[][] getM() {
        return this.M;
    }

    public void setM(int[][] M) {
        this.M = M;
    }

    public int getO() {
        return this.O;
    }

    @Override
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

    @Override
    public int[][] getArr() {
        int[][] temp = new int[this.getR()][this.getC()];
        int a = 0;
        for (int i = 0; i < this.getR(); i++) {
            for (int j = 0; j < this.getC(); j++) {
                if (i == j) {
                    temp[i][j] = this.getM()[0][a];
                    a++;
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        return temp;
    }

    public static int[][] getArr(int[][] d, int r, int c) {
        int[][] temp = new int[r][c];
        int a = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j) {
                    temp[i][j] = d[0][a];
                    a++;
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        return temp;
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

    @Override
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

    @Override
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

    @Override
    public int[][] getArr() {
        int[][] temp = new int[this.getR()][this.getC()];
        for (int i = 0; i < this.getR(); i++) {
            for (int j = 0; j < this.getC(); j++) {
                temp[i][j] = this.getM()[0][0];
            }
        }
        return temp;
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
            case 2:// Create matrices of requested matrix-types and label them with appropriate
                   // matrix-types.
                typeOfMMenu();
                int o = s.nextInt();
                switch (o) {
                case 1:// Rectangular Matrix
                    int[][] m1 = { { 1, 2, 3 }, { 3, 4, 5 } };
                    Cmatrix n1 = new Cmatrix(m1);
                    Cmatrix.setType(n1);
                    matrices.add(new Nmatrix(m1, n1.getMTypes()));
                    break;
                case 2:// Row Matrix
                    int[][] m2 = { { 1, 2 } };
                    Cmatrix n2 = new Cmatrix(m2);
                    Cmatrix.setType(n2);
                    matrices.add(new Nmatrix(m2, n2.getMTypes()));
                    break;
                case 3:// Column Matrix
                    int[][] m3 = { { 1 }, { 4 } };
                    Cmatrix n3 = new Cmatrix(m3);
                    Cmatrix.setType(n3);
                    matrices.add(new Nmatrix(m3, n3.getMTypes()));
                    break;
                case 4:// Square Matrix
                    int[][] m4 = { { 1, 2 }, { 3, 4 } };
                    Cmatrix n4 = new Cmatrix(m4);
                    Cmatrix.setType(n4);
                    matrices.add(new Nmatrix(m4, n4.getMTypes()));
                    break;
                case 5:// Symmetric Matrix
                    int[][] m5 = { { 1, 1, -1 }, { 1, 2, 0 }, { -1, 0, 5 } };
                    Cmatrix n5 = new Cmatrix(m5);
                    Cmatrix.setType(n5);
                    matrices.add(new Nmatrix(m5, n5.getMTypes()));
                    break;
                case 6:// Skew Symmetric Matrix
                    int[][] m6 = { { 0, 1, -2 }, { -1, 0, 3 }, { 2, -3, 0 } };
                    Cmatrix n6 = new Cmatrix(m6);
                    Cmatrix.setType(n6);
                    matrices.add(new Nmatrix(m6, n6.getMTypes()));
                    break;
                case 7:// Upper Triangular Matrix
                    int[][] m7 = { { 1, 2, 3 }, { 0, 3, 4 }, { 0, 0, 6 } };
                    Cmatrix n7 = new Cmatrix(m7);
                    Cmatrix.setType(n7);
                    matrices.add(new Nmatrix(m7, n7.getMTypes()));
                    break;
                case 8:// Lower Triangular Matrix
                    int[][] m8 = { { 1, 0, 0 }, { 3, 4, 0 }, { 1, 2, 3 } };
                    Cmatrix n8 = new Cmatrix(m8);
                    Cmatrix.setType(n8);
                    matrices.add(new Nmatrix(m8, n8.getMTypes()));
                    break;
                case 9:// Singular Matrix
                    int[][] m9 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
                    Cmatrix n9 = new Cmatrix(m9);
                    Cmatrix.setType(n9);
                    matrices.add(new Nmatrix(m9, n9.getMTypes()));
                    break;
                case 10:// Diagonal Matrix
                    int[][] m10 = { { 1, 0, 0 }, { 0, 2, 0 }, { 0, 0, 3 } };
                    Cmatrix n10 = new Cmatrix(m10);
                    Cmatrix.setType(n10);
                    matrices.add(new Dmatrix(m10, n10.getMTypes()));
                    break;
                case 11:// Scalar Matrix
                    int[][] m11 = { { 2, 0, 0 }, { 0, 2, 0 }, { 0, 0, 2 } };
                    Cmatrix n11 = new Cmatrix(m11);
                    Cmatrix.setType(n11);
                    matrices.add(new Dmatrix(m11, n11.getMTypes()));
                    break;
                case 12:// Identity Matrix
                    int[][] m12 = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
                    Cmatrix n12 = new Cmatrix(m12);
                    Cmatrix.setType(n12);
                    matrices.add(new Dmatrix(m12, n12.getMTypes()));
                    break;
                case 13:// Singleton Matrix
                    int[][] m13 = { { 2 } };
                    Cmatrix n13 = new Cmatrix(m13);
                    Cmatrix.setType(n13);
                    matrices.add(new Nmatrix(m13, n13.getMTypes()));
                    break;
                case 14:// Ones Matrix
                    int[][] m14 = { { 1, 1 }, { 1, 1 } };
                    Cmatrix n14 = new Cmatrix(m14);
                    Cmatrix.setType(n14);
                    matrices.add(new ONmatrix(m14, n14.getMTypes()));
                    break;
                case 15:// Null Matrix
                    int[][] m15 = { { 0, 0 }, { 0, 0 } };
                    Cmatrix n15 = new Cmatrix(m15);
                    Cmatrix.setType(n15);
                    matrices.add(new ONmatrix(m15, n15.getMTypes()));
                    break;
                }
                break;
            case 3:// Change the elements of a matrix as long as the fixed matrix-type labels
                   // remain valid
                System.out.println("Choose a matrix to be changed");
                printMatrices(matrices);
                int change = s.nextInt();
                if (matrices.get(change).getMTypes().contains("Null Matrix")
                        || matrices.get(change).getMTypes().contains("Ones Matrix")) {
                    System.out.println(
                            "Cannot Change elements of ones or null matrix without changing their fixed matrix labels.");
                } else if (matrices.get(change).getMTypes().contains("Diagonal Matrix")) {
                    int[][] deleted = matrices.get(change).getM();
                    for (int i = 0; i < deleted.length; i++) {
                        for (int j = 0; j < deleted[0].length; j++) {
                            deleted[i][j] = s.nextInt();
                        }
                    }
                    int[][] deleteP = Dmatrix.getArr(deleted, matrices.get(change).getArr().length,
                            matrices.get(change).getArr()[0].length);
                    System.out.println(Arrays.deepToString(deleteP));
                    Cmatrix dia = new Cmatrix(deleteP);
                    Cmatrix.setType(dia);
                    matrices.remove(change);
                    matrices.add(new Dmatrix(deleteP, dia.getMTypes()));
                } else {
                    int[][] deleted = matrices.get(change).getArr();
                    matrices.remove(change);
                    for (int i = 0; i < deleted.length; i++) {
                        for (int j = 0; j < deleted[0].length; j++) {
                            deleted[i][j] = s.nextInt();
                        }
                    }
                    Cmatrix dia = new Cmatrix(deleted);
                    Cmatrix.setType(dia);
                    if (dia.getMTypes().contains("Diagonal Matrix") && dia.getMTypes().contains("Null Matrix")) {
                        matrices.add(new ONmatrix(deleted, dia.getMTypes()));
                    } else if (dia.getMTypes().contains("Diagonal Matrix")) {
                        matrices.add(new Dmatrix(deleted, dia.getMTypes()));
                    } else if (dia.getMTypes().contains("Ones Matrix") || dia.getMTypes().contains("Null Matrix")) {
                        matrices.add(new ONmatrix(deleted, dia.getMTypes()));
                    } else {
                        matrices.add(new Nmatrix(deleted, dia.getMTypes()));
                    }
                }
                break;
            case 4:// Display all the matrix-type labels of a requested matrix.
                System.out.println("Choose a matrix: ");
                printMatrices(matrices);
                int Id = s.nextInt();
                matrices.get(Id).PrintTypes();
                break;
            case 5:// Perform addition, subtraction, multiplication & division.
                addSubMulDivmenu();
                int C = s.nextInt();
                printMatrices(matrices);
                System.out.println("Choose first matrix: ");
                int first = s.nextInt();
                System.out.println("Choose second matrix: ");
                int second = s.nextInt();
                switch (C) {
                case 1:// addition
                    if (matrices.get(first).getArr().length == matrices.get(second).getArr().length) {
                        if (matrices.get(first).getArr()[0].length == matrices.get(second).getArr()[0].length) {
                            int[][] sum = gMatrix.sumM(matrices.get(first).getArr(), matrices.get(second).getArr());
                            System.out.println("Ans: ");
                            gMatrix.printArr(sum);
                        } else {
                            System.out.println("Matrices not Compatible");
                        }
                    } else {
                        System.out.println("Matrices not Compatible.");
                    }
                    break;
                case 2:// subtraction
                    if (matrices.get(first).getArr().length == matrices.get(second).getArr().length) {
                        if (matrices.get(first).getArr()[0].length == matrices.get(second).getArr()[0].length) {
                            int[][] diff = gMatrix.diffM(matrices.get(first).getArr(), matrices.get(second).getArr());
                            System.out.println("Ans: ");
                            gMatrix.printArr(diff);
                        } else {
                            System.out.println("Matrices not Compatible");
                        }
                    } else {
                        System.out.println("Matrices not Compatible.");
                    }
                    break;
                case 3:// multiplication
                    if (matrices.get(first).getArr()[0].length == matrices.get(second).getArr().length) {
                        int[][] mull = gMatrix.mullM(matrices.get(first).getArr(), matrices.get(second).getArr());
                        System.out.println("Ans: ");
                        gMatrix.printArr(mull);
                    } else {
                        System.out.println("Matrices not Compatible.");
                    }
                    break;
                case 4:// division AB-1
                    if (matrices.get(first).getArr()[0].length == matrices.get(second).getArr().length) {
                        if (matrices.get(second).GetDeterminant() != 0) {
                            double[][] divd = gMatrix.mullM(matrices.get(first).getArr(), gMatrix
                                    .inverseM(matrices.get(second).getArr(), matrices.get(second).GetDeterminant()));
                            System.out.println("Ans: ");
                            gMatrix.printArr(divd);
                        } else {
                            System.out.println("Matrix no invertible.");
                        }

                    } else {
                        System.out.println("Matrices not Compatible.");
                    }
                    break;
                }
                break;
            case 6:// Perform element-wise operations
                System.out.println("1. Element wise Multiplication.");
                System.out.println("2. Element wise Division.");
                int key = s.nextInt();
                printMatrices(matrices);
                System.out.println("Choose first matrix: ");
                int fir = s.nextInt();
                System.out.println("Choose second matrix: ");
                int sec = s.nextInt();
                if ((matrices.get(fir).getArr().length == matrices.get(sec).getArr().length)
                        && (matrices.get(fir).getArr()[0].length == matrices.get(sec).getArr()[0].length)) {
                    switch (key) {
                    case 1:
                        int[][] mullMe = gMatrix.mullMe(matrices.get(fir).getArr(), matrices.get(sec).getArr());
                        gMatrix.printArr(mullMe);
                        break;
                    case 2:
                        double[][] divdMe = gMatrix.divdMe(matrices.get(fir).getArr(), matrices.get(sec).getArr());
                        gMatrix.printArr(divdMe);
                        break;
                    }
                } else {
                    System.out.println("Matrices not Compatible.");
                }
                break;
            case 7:// Transpose matrices
                System.out.println("Choose a matrix: ");
                printMatrices(matrices);
                int id = s.nextInt();
                matrices.get(id).GetTraspose();
                break;
            case 8:// Inverse matrices.
                System.out.println("Choose a matrix: ");
                printMatrices(matrices);
                int inv = s.nextInt();
                int[][] i = matrices.get(inv).getArr();
                if (i.length == i[0].length) {
                    if (matrices.get(inv).GetDeterminant() != 0) {
                        double[][] invM = gMatrix.inverseM(i, matrices.get(inv).GetDeterminant());
                        System.out.println("Ans: ");
                        if (invM.length == 3) {
                            invM = Cmatrix.getTraspose(invM);
                        }
                        gMatrix.printArr(invM);
                    } else {
                        System.out.println("Matrix not invertible as determinant is zero.");
                    }

                } else {
                    System.out.println("Matrix not a square matrix.");
                }
                break;
            case 9:// Compute means: row-wise mean, column-wise mean, mean of all the elements.
                System.out.println("Choose a matrix: ");
                printMatrices(matrices);
                int me = s.nextInt();
                typeOfMean();
                int mean = s.nextInt();
                switch (mean) {
                case 1:// row wise mean
                    gMatrix.rowWiseMean(matrices.get(me).getArr());
                    break;
                case 2:// column wise mean
                    gMatrix.colWiseMean(matrices.get(me).getArr());
                    break;
                case 3:// mean of all the elements
                    gMatrix.allMean(matrices.get(me).getArr());
                    break;
                }
                break;
            case 10:// Compute determinants
                System.out.println("Choose a matrix: ");
                printMatrices(matrices);
                int iD = s.nextInt();
                System.out.println("Ans: " + matrices.get(iD).GetDeterminant());

                break;
            case 11:// Use singleton matrices as scalars, if requested.
                System.out.println("Choose a matrix to be used as scalar: ");
                printSingletonMatrices(matrices);
                int sc = s.nextInt();
                System.out.println("Choose the other matrix on which the operation is to be performed: ");
                printMatrices(matrices);
                int om = s.nextInt();
                addSubMulDivmenu();
                int ch = s.nextInt();
                switch (ch) {
                case 1:// scalar addtion
                    int[][] scSum = gMatrix.sumScM(matrices.get(sc).getArr()[0][0], matrices.get(om).getArr());
                    gMatrix.printArr(scSum);
                    break;
                case 2:// scalar subtraction
                    int[][] scdiff = gMatrix.diffScM(matrices.get(sc).getArr()[0][0], matrices.get(om).getArr());
                    gMatrix.printArr(scdiff);
                    break;
                case 3:// scalar multiplication
                    int[][] scmull = gMatrix.mullScM(matrices.get(sc).getArr()[0][0], matrices.get(om).getArr());
                    gMatrix.printArr(scmull);
                    break;
                case 4:// scalar division
                    double[][] scdiv = gMatrix.divdScM(matrices.get(sc).getArr()[0][0], matrices.get(om).getArr());
                    gMatrix.printArr(scdiv);
                    break;
                }
                break;
            case 12:// Compute A+AT for a matrix A.
                System.out.println("Choose a matrix: ");
                printMatrices(matrices);
                int ID = s.nextInt();
                if (matrices.get(ID).getMTypes().contains("Square Matrix")) {
                    int[][] Sum = gMatrix.sumM(matrices.get(ID).getArr(), matrices.get(ID).GetTraspose());
                    gMatrix.printArr(Sum);
                } else {
                    System.out.println("Incompatible Matrix");
                }
                break;
            case 13:// Compute Eigen vectors and values.
                break;
            case 14:// Solve sets of linear equations using matrices.
                System.out.println("Choose matrix one: ");
                printMatrices(matrices);
                int one = s.nextInt();
                int[][] oneM = matrices.get(one).getArr();
                if (oneM.length == oneM[0].length) {
                    if (matrices.get(one).GetDeterminant() != 0) {
                        System.out.println("Choose matrix two: ");
                        printMatrices(matrices);
                        int two = s.nextInt();
                        int[][] twoM = matrices.get(two).getArr();
                        if (oneM[0].length == twoM.length) {
                            double[][] oneI = gMatrix.inverseM(oneM, matrices.get(one).GetDeterminant());
                            if (oneI.length == 3) {
                                oneI = Cmatrix.getTraspose(oneI);
                            }
                            double[][] eqSolv = gMatrix.mullMdf(oneI, twoM);
                            gMatrix.printArr(eqSolv);
                        } else {
                            System.out.println("Matrices not compatibel to be solved.");
                        }
                    } else {
                        System.out.println("Matrix not invertible as determinant is zero.");
                    }
                } else {
                    System.out.println("Matrix not Square.");
                }

                break;
            case 15:// Retrieve all the existing matrices (entered or created) having requested
                    // matrix-type labels.
                typeOfMMenu();
                int O = s.nextInt();
                switch (O) {
                case 1:// Rectangular Matrix
                    gMatrix.getMofTypes(matrices, "Rectangular Matrix");
                    break;
                case 2:// Row Matrix
                    gMatrix.getMofTypes(matrices, "Row Matrix");
                    break;
                case 3:// Column Matrix
                    gMatrix.getMofTypes(matrices, "Column Matrix");
                    break;
                case 4:// Square Matrix
                    gMatrix.getMofTypes(matrices, "Square Matrix");
                    break;
                case 5:// Symmetric Matrix
                    gMatrix.getMofTypes(matrices, "Symmetrix Matrix");
                    break;
                case 6:// Skew Symmetric Matrix
                    gMatrix.getMofTypes(matrices, "Skew-Symmetrix Matrix");
                    break;
                case 7:// Upper Triangular Matrix
                    gMatrix.getMofTypes(matrices, "Upper Triangular Matrix");
                    break;
                case 8:// Lower Triangular Matrix
                    gMatrix.getMofTypes(matrices, "Lower Triangular Matrix");
                    break;
                case 9:// Singular Matrix
                    gMatrix.getMofTypes(matrices, "Singular Matrix");
                    break;
                case 10:// Diagonal Matrix
                    gMatrix.getMofTypes(matrices, "Diagonal Matrix");
                    break;
                case 11:// Scalar Matrix
                    gMatrix.getMofTypes(matrices, "Scalar Matrix");
                    break;
                case 12:// Identity Matrix
                    gMatrix.getMofTypes(matrices, "Identity Matrix");
                    break;
                case 13:// Singleton Matrix
                    gMatrix.getMofTypes(matrices, "Singleton Matrix");
                    break;
                case 14:// Ones Matrix
                    gMatrix.getMofTypes(matrices, "Ones Matrix");
                    break;
                case 15:// Null Matrix
                    gMatrix.getMofTypes(matrices, "Null Matrix");
                    break;
                }
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

    public static void printSingletonMatrices(ArrayList<gMatrix> matrices) {
        for (int i = 0; i < matrices.size(); i++) {
            if (matrices.get(i).getMTypes().contains("Singleton Matrix")) {
                System.out.println(i + ": ");
                matrices.get(i).Printm();
            }
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

    public static void typeOfMMenu() {
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

    public static void typeOfMean() {
        System.out.println("Choose an option>>");
        System.out.println("1. Row Wise Mean");
        System.out.println("2. Column Wise Mean");
        System.out.println("3. Mean of all the elements");
    }
}
