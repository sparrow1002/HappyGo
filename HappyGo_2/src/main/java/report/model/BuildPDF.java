package report.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class BuildPDF {
	private static final String jsFile = "C:/EEIT_JSP_Software/JDBCDriver/HappyGo.jasper";
	private static final String outFilePdf = "C:/EEIT_JSP_Software/JDBCDriver/HappyGo.pdf";
	private static final String outFileHtml = "C:/EEIT_JSP_Software/JDBCDriver/HappyGo.html";

	static void PDFBuid(Collection<Map<String, ?>> list) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		JRMapCollectionDataSource dataSource05 = new JRMapCollectionDataSource(list);
		JasperPrint print;
		try {
			print = JasperFillManager.fillReport(jsFile, parameters, dataSource05);

			JRExporter exporterPdf = new JRPdfExporter();
			exporterPdf.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFilePdf);
			exporterPdf.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporterPdf.exportReport();

			JRExporter exporterHtml = new JRHtmlExporter();
			exporterHtml.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileHtml);
			exporterHtml.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporterHtml.exportReport();

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
