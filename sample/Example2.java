package sample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;

public class Example2
{
    public static void main(String[] arguments) throws IOException
    {
        downloadImage("https://intuitcorp.quickbase.com/up/bkck562m5/g/rc2d/eg/va/3539_003.png",
                new File("").getAbsolutePath());
    }

    public static void downloadImage(String sourceUrl, String targetDirectory)
            throws MalformedURLException, IOException, FileNotFoundException
    {
        URL imageUrl = new URL(sourceUrl);
        try (InputStream imageReader = new BufferedInputStream(
                imageUrl.openStream());
                OutputStream imageWriter = new BufferedOutputStream(
                        new FileOutputStream(targetDirectory + File.separator
                                + FilenameUtils.getName(sourceUrl)));)
        {
            int readByte;

            while ((readByte = imageReader.read()) != -1)
            {
                imageWriter.write(readByte);
            }
            System.out.println("File downloaded...."+targetDirectory + File.separator
                    + FilenameUtils.getName(sourceUrl));
            imageReader.close();
            imageWriter.close();
        }catch(Exception e){
        	System.out.println("Exception:..File doesn't exists....");
        }
        
    }
}
