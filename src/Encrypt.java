import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class Encrypt {
//Properties
	File browseFile;
	String fileName;
	String encryptName;
	String line;
// Constructed
	public Encrypt(File file , String fileName) throws IOException {
		browseFile = new File(file , fileName);
		this.fileName = fileName;
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((line = br.readLine()) != null) {
			
		}
		System.out.print(line);
		br.close();
	}
	
// Method
	String changName() {
		String[] arrName = fileName.split(".txt");
		encryptName = arrName[0]+"-txt.encrypt";
		try (PrintWriter newFile = new PrintWriter( encryptName )){
			System.out.print(line);
			newFile.print(line);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encryptName;
	}
}
//devnon