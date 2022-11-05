import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;


public class BarcodeTest{
    public static void main(String[] args) throws Exception {
        try{
            Webcam webcam = Webcam.getDefault();
            webcam.open();
            ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));

            Scanner input = new Scanner(System.in);
            System.out.println("Enter your barcode text: ");
            String text = input.nextLine();
            String path = "src/main/resources/"+text+".jpg";
            Code128Writer writer = new Code128Writer();
            BitMatrix matrix = writer.encode(text, BarcodeFormat.CODE_128,300,200);

            MatrixToImageWriter.writeToPath(matrix,"jpg", Paths.get(path));
            System.out.println("Barcode created...");
            ReadBarcode barcodeReader = new ReadBarcode();
            barcodeReader.read();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}