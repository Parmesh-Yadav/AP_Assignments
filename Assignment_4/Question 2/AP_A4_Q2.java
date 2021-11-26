import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

abstract class Image {

    abstract void getimages(int r, int c, ArrayList<Image> images);

    abstract void printimage();

    abstract void updateImage();

    public static void inputarr(int [][] arr){
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = s.nextInt();
            }
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
    void printimage() {
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
    void updateImage() {
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
    private int[][] gray;

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
    void getimages(int r, int c, ArrayList<Image> images) {
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
    void printimage() {
        System.out.println("Here is the requested GrayScale image:");
        System.out.println();
        System.out.println(Arrays.deepToString(this.getGray()));
    }

    @Override
    void updateImage() {
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
                    System.out.println("Enter the dimension of the matrix:\ni.e. enter 3 for 3x3, 4 for 4x4.");
                    int r = s.nextInt();
                    int c = r;
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
                    break;
                case 5:// exit
                    ch = 'n';
                    break;
            }
        }

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
