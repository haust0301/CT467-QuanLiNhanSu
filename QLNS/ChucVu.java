package QLNS;

public class ChucVu {
	String MaChucVu, TenChucVu;
	float HeSoLuong;
	
	public ChucVu() {
		
	}
	
	public ChucVu(String MCV, String TCV, float HSL) {
		this.MaChucVu = MCV;
		this.TenChucVu = TCV;
		this.HeSoLuong = HSL;
	}
	
	public String getMaChucVu() {
		return MaChucVu;
	}
	
	public void setMaChucVu(String MCV) {
		this.MaChucVu = MCV;
	}
	
	public String getTenChucVu() {
		return TenChucVu;
	}
	
	public void setTenChucVu(String TCV) {
		this.TenChucVu = TCV;
	}
	
	public float getHeSoLuong() {
		return HeSoLuong;
	}
	
	public void setHeSoLuong(float HSL) {
		this.HeSoLuong = HSL;
	}
	
	
}
