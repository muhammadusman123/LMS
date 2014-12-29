package algo;
import comp102x.IO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
public class NewLibTest {
	public static void main(String args[]) {
		// System.out.println(decode(new File(
		// "C:\\Users\\Muhammad Usman\\Desktop\\barcode1.jpg")));
		// System.out.println(value1);
	}
	// private long value1;
	public String getbar() {
		long value1 = IO.inputBarcode();
		return Long.toString(value1);
	}
	public static String decode(File file) {// , Map<DecodeHintType, Object>
		// hints) throws Exception {
		// check the required parameters
		if (file == null || file.getName().trim().isEmpty())
			throw new IllegalArgumentException(
					"File not found, or invalid file name.");
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException ioe) {
			try {
				throw new Exception(ioe.getMessage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (image == null)
			throw new IllegalArgumentException("Could not decode image.");
		LuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		MultiFormatReader barcodeReader = new MultiFormatReader();
		Result result;
		String finalResult = null;
		try {
			// if (hints != null && ! hints.isEmpty())
			// result = barcodeReader.decode(bitmap, hints);
			// else
			result = barcodeReader.decode(bitmap);
			// setting results.
			finalResult = String.valueOf(result.getText());
		} catch (Exception e) {
			e.printStackTrace();
			// throw new BarcodeEngine().new
			// BarcodeEngineException(e.getMessage());
		}
		return finalResult;
	}
}