package com.coderscapmus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CrimeReport {
	
	private List<CrimeReportDataRow> rows = new ArrayList<>();
	
	@Value("${report.filename}")
	private String filename;
	
//	@Autowired
//	@Qualifier("ascReport")
//	private CrimeReportResult crimeReportResult;
	
	private FileProcessorService fileProcessorService;
	
	/**
	 * Constructor, what denotes that Object is being created
	 * When it's created it runs the code inside of the constructor.
	 * */
	
	public void generateReport ()
	{
		System.out.println("Loading filename:" + filename);
		this.setRows(fileProcessorService.processFile(filename));
//		System.out.println(crimeReportResult.getSorting());
	}

	public List<CrimeReportDataRow> getRows() {
		return rows;
	}

	public void setRows(List<CrimeReportDataRow> rows) {
		this.rows = rows;
	}


	public FileProcessorService getFileProcessorService() {
		return fileProcessorService;
	}

	@Autowired
	public void setFileProcessorService(FileProcessorService fileProcessorService) {
		this.fileProcessorService = fileProcessorService;
	}
	
	
	
	

}
