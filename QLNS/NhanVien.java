package QLNS;

public class NhanVien {
	String MaNhanVien, HoTen, GioiTinh, SoDienThoai, MaChucVu;
	int NamSinh;
	
	public NhanVien () {
		
	}
	
	public NhanVien(String MaNhanVien, String HoTen, String GioiTinh ,int NamSinh, String SoDienThoai, String MaChucVu) {
	this.MaNhanVien = MaNhanVien;
	this.HoTen = HoTen;
	this.GioiTinh = GioiTinh;
	this.SoDienThoai = SoDienThoai;
	this.MaChucVu = MaChucVu;
	this.NamSinh = NamSinh;
	}
	
	
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	
	public void setMaNhanVien(String MNV) {
		this.MaNhanVien = MNV;
	}
	
	public String getHoTen() {
		return HoTen;
	}
	
	public void setHoTen(String HoTen) {
		this.HoTen = HoTen;
	}
	
	public String getGioiTinh() {
		return GioiTinh;
	}
	
	public void setGioiTinh(String GT) {
		this.GioiTinh = GT;
	}
	
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	
	public void setSoDienThoai(String SDT) {
		this.SoDienThoai = SDT;
	}
	
	public String getMaChucVu() {
		return MaChucVu;
	}
	
	public void setMaChucVu(String MCV) {
		this.MaChucVu = MCV;
	}
	
	public int getNamSinh() {
		return NamSinh;
	}
	
	public void setNamSinh(int NS) {
		this.NamSinh = NS;
	}
	
	
}
