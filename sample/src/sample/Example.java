package sample;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Example {

	public static void main(String[] args) throws Exception {
		//String imageUrl = "https://intuitcorp.quickbase.com/up/bkck562m5/g/rc2c/eg/va/3539_002.png";
		String imageUrl="https://intuitcorp.quickbase.com/up/bkck562m5/g/rc2d/eg/va/3539_003.png";
		String destinationFile = "3539_003.png";
		System.out.println("started...."+imageUrl);
		saveImage(imageUrl, destinationFile);
	}

	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);
		try{
		
		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		}catch(Exception e){
			System.out.println("Got Exception for file"+destinationFile);	
		}
		System.out.println("done file...."+destinationFile);
		is.close();
		os.close();
	}

}
