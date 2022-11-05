import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.Code128Reader;
import com.google.zxing.oned.Code128Writer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadBarcode {
    public void read()throws Exception{
        try
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your barcode name: ");
            String text = input.nextLine();
            String path = "src/main/resources/" + text + ".jpg";

            BufferedImage bf = ImageIO.read(new FileInputStream(path));
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(bf)
            ));
            Result result = new Code128Reader().decode(bitmap);
            System.out.println(path +" - reads, "+result.getText());

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
