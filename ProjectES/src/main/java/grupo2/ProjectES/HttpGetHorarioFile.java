package grupo2.ProjectES;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class HttpGetHorarioFile {

	public static void main(String[] args) {
		
		String FILE_URL="https://fenix.iscte-iul.pt/publico/publicPersonICalendar.do?method=iCalendar&username=tfava1@iscte.pt&password=hRocBUdgWhnQU3ua4S6EqOSz34MyzMSHGxAGsRmQsDdmi6rHEn37kBhMswleKA4yQm8D9twF0406T0fjzF52uSiPLChjRZ0FjTcMZgYAmdNearUjE87RX0DmZbhgDqfr";
		String FILE_NAME="src\\main\\java\\Files\\file.txt";
		try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
				  FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
				    byte dataBuffer[] = new byte[1024];
				    int bytesRead;
				    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				        fileOutputStream.write(dataBuffer, 0, bytesRead);
				    }
				} catch (IOException e) {
				    // handle exception
				}
		
	}
}
