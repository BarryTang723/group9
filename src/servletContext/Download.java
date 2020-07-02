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
		
		//�ļ�д���ڴ�
		System.out.println(realPath2);//test
		FileInputStream fis = new FileInputStream(realPath2);
		//������Ӧͷ
		//��Ӧͷ����
		String mimeType = context.getMimeType(filename);
		resp.setHeader("content-type", mimeType);
		//��Ӧͷ�򿪷�ʽ
		resp.setHeader("content-disposition", "attachment;filename="+filename);
		//�������ŵ���������,��Ҫһ��������
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
