package com.coderscapmus;

import java.util.Comparator;

public class CrimeReportDataRow {
	
	private String crimeDescription;
	private Integer crimeInstanceNumber;
	private Integer crimeRate;
	private Integer yearlyCrimeRateChange;
	private Integer decadeCrimeRateChange;
	
	public CrimeReportDataRow(String[] data) 
	{
		this.setCrimeDescription(data[0]);
		this.setCrimeInstanceNumber(Integer.valueOf(data[1]));
		this.setCrimeRate(Integer.valueOf(data[2]));
		this.setYearlyCrimeRateChange(Integer.valueOf(data[3]));
		this.setDecadeCrimeRateChange(Integer.valueOf(data[4]));
		
	}
	public String getCrimeDescription() {
		return crimeDescription;
	}
	public void setCrimeDescription(String crimeDescription) {
		this.crimeDescription = crimeDescription;
	}
	public Integer getCrimeInstanceNumber() {
		return crimeInstanceNumber;
	}
	public void setCrimeInstanceNumber(Integer crimeInstanceNumber) {
		this.crimeInstanceNumber = crimeInstanceNumber;
	}
	public Integer getCrimeRate() {
		return crimeRate;
	}
	public void setCrimeRate(Integer crimeRate) {
		this.crimeRate = crimeRate;
	}
	public Integer getYearlyCrimeRateChange() {
		return yearlyCrimeRateChange;
	}
	public void setYearlyCrimeRateChange(Integer yearlyCrimeRateChange) {
		this.yearlyCrimeRateChange = yearlyCrimeRateChange;
	}
	public Integer getDecadeCrimeRateChange() {
		return decadeCrimeRateChange;
	}
	public void setDecadeCrimeRateChange(Integer decadeCrimeRateChange) {
		this.decadeCrimeRateChange = decadeCrimeRateChange;
	}
	
	/**
	 * Without toString() we can get memory address location of the object, which is not helpful
	 * toString() provides us the memory text representation of the object
	 * */
	@Override
	public String toString() {
		return "CrimeReportDataRow [crimeDescription=" + crimeDescription + ", crimeInstanceNumber="
				+ crimeInstanceNumber + ", crimeRate=" + crimeRate + ", yearlyCrimeRateChange=" + yearlyCrimeRateChange
				+ ", decadeCrimeRateChange=" + decadeCrimeRateChange + "]";
	}

}
