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
	private static final String jsFile = "C:/jasper/HappyGo.jasper";
	private static final String outFilePdf = "C:/jasper/HappyGo.pdf";
	private static final String outFileHtml = "C:/jasper/HappyGo.html";

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

//			JRExporter exporterHtml = new JRHtmlExporter();
//			exporterHtml.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileHtml);
//			exporterHtml.setParameter(JRExporterParameter.JASPER_PRINT, print);
//			exporterHtml.exportReport();

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String jsFile_store = "C:/jasper/HappyGo2.jasper";
	private static final String outFilePdf_store = "C:/jasper/HappyGo2.pdf";
	private static final String outFileHtml_store = "C:/jasper/HappyGo2.html";
	
	static void PDFBuid_store(Collection<Map<String, ?>> list) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		JRMapCollectionDataSource dataSource05 = new JRMapCollectionDataSource(list);
		JasperPrint print;
		try {
			print = JasperFillManager.fillReport(jsFile_store, parameters, dataSource05);

			JRExporter exporterPdf = new JRPdfExporter();
			exporterPdf.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFilePdf_store);
			exporterPdf.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporterPdf.exportReport();

//			JRExporter exporterHtml = new JRHtmlExporter();
//			exporterHtml.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileHtml_store);
//			exporterHtml.setParameter(JRExporterParameter.JASPER_PRINT, print);
//			exporterHtml.exportReport();

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
