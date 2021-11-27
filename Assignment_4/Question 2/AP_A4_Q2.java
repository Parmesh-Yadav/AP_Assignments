import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

abstract class Image {

    abstract void getimages(int r, int c, ArrayList<Image> images);

    abstract void printimage();

    abstract void updateImage();;

    public static void inputarr(int[][] arr) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = s.nextInt();
            }
        }
    }

    public static void copyarr(int[][] a,int[][] b) {
        for(int i = 0; i < b.length; i++) {
            for(int j = 0; j < b[0].length;j++){
                a[i][j] = b[i][j];
            }
        }
    }

    public static <E> void computeNegative(E image) { // GENERIC FUNCTION
        if (image instanceof ColorImage) {
            ColorImage temp = (ColorImage) image;
            ArrayList<int[][]> neg = new ArrayList<>();
            int[][] nred = new int[temp.getR()][temp.getC()];
            int[][] ngreen = new int[temp.getR()][temp.getC()];
            int[][] nblue = new int[temp.getR()][temp.getC()];
            copyarr(nred, temp.getRed());
            copyarr(ngreen, temp.getGreen());
            copyarr(nblue,temp.getBlue());
            neg.add(nred);
            neg.add(ngreen);
            neg.add(nblue);
            for (int[][] m : neg) {
                for (int i = 0; i < temp.getR(); i++) {
                    for (int j = 0; j < temp.getC(); j++) {
                        m[i][j] = 255 - m[i][j];
                    }
                }
            }
            System.out.println("NEGATIVE red");
            System.out.println(Arrays.deepToString(nred));
            System.out.println("NEGATIVE green");
            System.out.println(Arrays.deepToString(ngreen));
            System.out.println("NEGATIVE blue");
            System.out.println(Arrays.deepToString(nblue));

        } else if (image instanceof GrayScaleImage) {
            GrayScaleImage temp = (GrayScaleImage) image;
            int[][] ngray = new int[temp.getR()][temp.getC()];
            copyarr(ngray, temp.getGray());
            for (int i = 0; i < temp.getR(); i++) {
                for (int j = 0; j < temp.getC(); j++) {
                    ngray[i][j] = 255 - ngray[i][j];
                }
            }
            System.out.println("NEGATIVE gray");
            System.out.println(Arrays.deepToString(ngray));
        }
    }

    

}

class ColorImage extends Image {
    private int r;
    private int c;
    private int[][] red;
    private int[][] green;
    private int[][] blue;
    

    public ColorImage(int[][] red, int[][] green, int[][] blue, int r, int c) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.r = r;
        this.c = c;
    }

    public ColorImage() {
    }

    public int[][] getRed() {
        return this.red;
    }

    public void setRed(int[][] red) {
        this.red = red;
    }

    public int[][] getGreen() {
        return this.green;
    }

    public void setGreen(int[][] green) {
        this.green = green;
    }

    public int[][] getBlue() {
        return this.blue;
    }

    public void setBlue(int[][] blue) {
        this.blue = blue;
    }

    public int getR() {
        return this.r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return this.c;
    }

    public void setC(int c) {
        this.c = c;
    }


    @Override
    public void getimages(int r, int c, ArrayList<Image> images) {
        Scanner s = new Scanner(System.in);
        int[][] red = new int[r][c];
        int[][] blue = new int[r][c];
        int[][] green = new int[r][c];
        ArrayList<int[][]> image = new ArrayList<>();
        image.add(red);
        image.add(green);
        image.add(blue);
        System.out.println(
                "First Enter the elements of RED matrix\nThen the elements of GREEN\nThen the elements of BLUE at last.");
        for (int[][] m : image) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    m[i][j] = s.nextInt();
                }
            }
        }
        images.add(new ColorImage(red, green, blue, r, c));
    }

    @Override
    public void printimage() {
        System.out.println("Here is the requested image:");
        System.out.println();
        System.out.println("Red:");
        System.out.println(Arrays.deepToString(this.getRed()));
        System.out.println("Green:");
        System.out.println(Arrays.deepToString(this.getGreen()));
        System.out.println("Blue:");
        System.out.println(Arrays.deepToString(this.getBlue()));
    }

    @Override
    public void updateImage() {
        System.out.println("Update/Enter the new RED values: ");
        Image.inputarr(this.getRed());
        System.out.println("Update/Enter the new GREEN values: ");
        Image.inputarr(this.getGreen());
        System.out.println("Update/Enter the new BLUE values: ");
        Image.inputarr(this.getBlue());
    }

}

class GrayScaleImage extends Image {
    private int r;
    private int c;
    private int[][] gray;;

    public GrayScaleImage(int[][] gray, int r, int c) {
        this.gray = gray;
        this.r = r;
        this.c = c;
    }

    public GrayScaleImage() {
    }

    public int[][] getGray() {
        return this.gray;
    }

    public void setGray(int[][] gray) {
        this.gray = gray;
    }

    public int getR() {
        return this.r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return this.c;
    }

    public void setC(int c) {
        this.c = c;
    }



    @Override
    public void getimages(int r, int c, ArrayList<Image> images) {
        Scanner s = new Scanner(System.in);
        int[][] gray = new int[r][c];
        System.out.println(
                "Enter the elements of GRAY matrix.");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                gray[i][j] = s.nextInt();
            }
        }
        images.add(new GrayScaleImage(gray, r, c));

    }

    @Override
    public void printimage() {
        System.out.println("Here is the requested GrayScale image:");
        System.out.println();
        System.out.println(Arrays.deepToString(this.getGray()));
    }

    @Override
    public void updateImage() {
        System.out.println("Update/Enter the new GRAY values: ");
        Image.inputarr(this.getGray());
    }

}

public class AP_A4_Q2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Image> images = new ArrayList<>();
        char ch = 'y';
        while (ch == 'y') {
            Menu();
            int choice = s.nextInt();
            switch (choice) {
                case 1:// input image
                    ImageMenu();
                    int im = s.nextInt();
                    System.out.println("Enter the no. rows of the matrix:");
                    int r = s.nextInt();
                    System.out.println("Enter the no. columns of the matrix:");
                    int c = s.nextInt();
                    switch (im) {
                        case 1:// color
                            (new ColorImage()).getimages(r, c, images);
                            break;
                        case 2:// grayscale
                            (new GrayScaleImage()).getimages(r, c, images);
                            break;
                    }
                    break;
                case 2:// update iamge
                    if (images.size() == 0) {
                        System.out.println("No images present.");
                        break;
                    }
                    System.out.println("Enter the image id: ( 0 - " + (images.size() - 1) + " ) :");
                    int ig = s.nextInt();
                    images.get(ig).updateImage();
                    break;
                case 3:// dsplay image
                    if (images.size() == 0) {
                        System.out.println("No images present.");
                        break;
                    }
                    System.out.println("Enter the image id: ( 0 - " + (images.size() - 1) + " ) :");
                    int img = s.nextInt();
                    images.get(img).printimage();
                    break;
                case 4:// compute negative
                    if (images.size() == 0) {
                        System.out.println("No images present.");
                        break;
                    }
                    System.out.println("Enter the image id: ( 0 - " + (images.size() - 1) + " ) :");
                    int mg = s.nextInt();
                    Image.computeNegative(images.get(mg));
                    break;
                case 5:// exit
                    ch = 'n';
                    break;
            }
        }
        s.close();

    }

    public static void Menu() {
        System.out.println("Choose an option>>");
        System.out.println("1. Create an Image");
        System.out.println("2. Update an Image");
        System.out.println("3. Display an Image");
        System.out.println("4. Compute Negative of a Matrix");
        System.out.println("5. Exit");
    }

    public static void ImageMenu() {
        System.out.println("Choose an option>>");
        System.out.println("1. Color Image");
        System.out.println("2. GrayScale Image");
    }
}
