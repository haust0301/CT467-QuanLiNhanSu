package QLNS;

import java.sql.Date;

public class ChamCong {
	Date NgayChamCong;
	String MaNhanVien;
	
	public ChamCong() {
		
	}
	
	public ChamCong(String MNV) {
		long millis=System.currentTimeMillis(); 
		java.sql.Date date = new java.sql.Date(millis);
		this.NgayChamCong = date;
		this.MaNhanVien = MNV;
	}
	
	public ChamCong(Date NCC, String MNV) {
		this.NgayChamCong = NCC;
		this.MaNhanVien = MNV;
	}
	
	public Date getNgayChamCong() {
		return NgayChamCong;
	}
	
	
	public String getMaNhanVien () {
		return MaNhanVien;
	}
	
	public void setMaNhanVien (String MNV) {
		this.MaNhanVien = MNV;
	}
}
