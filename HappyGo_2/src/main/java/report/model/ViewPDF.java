package report.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewPDF {
	static boolean PDFView(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/pdf");
		InputStream is;
		try {
			is = new FileInputStream(new File("C:/jasper/HappyGo.pdf"));
			OutputStream os = response.getOutputStream();
			writeBytes(is, os);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	static boolean PDFView_store(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/pdf");
		InputStream is;
		try {
			is = new FileInputStream(new File("C:/jasper/HappyGo2.pdf"));
			OutputStream os = response.getOutputStream();
			writeBytes(is, os);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	static void writeBytes(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer)) != -1) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
	}
}
