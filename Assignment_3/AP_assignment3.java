package Assignment_3;


class Matrix{
    private final int R;
    private final int C;
    private final int[][] M;

    public Matrix(int[][] m){
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
}


public class AP_assignment3 {
    public static void main(String[] args) {
        
    }
}
