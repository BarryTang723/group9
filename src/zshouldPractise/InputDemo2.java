package zshouldPractise;
import java.io.*;

import com.sun.java.swing.plaf.windows.resources.windows;
public class InputDemo2 {
	public static void main(String[] args) throws IOException {
		File f = new File("a.txt");
		FileOutputStream fop = new FileOutputStream(f);
		OutputStreamWriter writer = new OutputStreamWriter(fop,"UTF-8");
		writer.append("中文输入");
		writer.append("English");
		writer.close();
	}
}
