package servletContext;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/download")
public class Download extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("kaishi xiazai!!");
		//test
		String filename = req.getParameter("filename");
//		String filename="1.png";
		
		ServletContext context = this.getServletContext();
		String realPath1 = context.getRealPath("/");
		String realPath2 = realPath1+"img\\"+filename;
//		System.out.println(realPath2);
		//test
//		String realPath="C:\\Users\\WDTMD\\workspaceJavaWeb\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Servlet\\img\\1.png";
		
		//文件写入内存
		System.out.println(realPath2);//test
		FileInputStream fis = new FileInputStream(realPath2);
		//设置响应头
		//响应头类型
		String mimeType = context.getMimeType(filename);
		resp.setHeader("content-type", mimeType);
		//响应头打开方式
		resp.setHeader("content-disposition", "attachment;filename="+filename);
		//输入流放到输入流里,需要一个缓冲区
		ServletOutputStream sos = resp.getOutputStream();	
		byte[] buff=new byte[1024*8];
		int len=0;
		while((len=fis.read(buff)) !=-1 ) {
			sos.write(buff,0,len);
		}
		fis.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
