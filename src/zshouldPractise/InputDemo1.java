package zshouldPractise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.jni.File;

public class InputDemo1 {
	public static void main(String[] args){
//		  FileInputStream fileInputStream = new FileInputStream("C:\\Users\\WDTMD\\workspaceJavaWeb\\Servlet\\src\\hello.txt");
		try {
			//输入的内容放在数组里
			byte bWrite[]= {11,21,3,1,3,1,3};
			OutputStream os = new FileOutputStream("C:\\Users\\WDTMD\\workspaceJavaWeb\\Servlet\\src\\hello.txt");
			for (int i = 0; i < bWrite.length; i++) {
				os.write(bWrite[i]);
			}
			InputStream is = new FileInputStream("C:\\Users\\WDTMD\\workspaceJavaWeb\\Servlet\\src\\hello.txt");
			int size = is.available();
			for (int i = 0; i < size; i++) {
				System.out.println((char)is.read()+ " ");
			}
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
