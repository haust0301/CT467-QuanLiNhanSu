package QLNS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienModify {
	public static List<NhanVien> findAll() {
		List<NhanVien> DanhSachNhanVien = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			String sql = "select MaNhanVien, HoTen, GioiTinh, NamSinh, SoDienThoai, MaChucVu"
					+ " from NhanVien";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                NhanVien NV = new NhanVien(resultSet.getString("MaNhanVien"), 
                        resultSet.getString("HoTen"), resultSet.getString("GioiTinh"),
                        resultSet.getInt("NamSinh"),
                        resultSet.getString("SoDienThoai"),resultSet.getString("MaChucVu")
                        );
                DanhSachNhanVien.add(NV);
            }
		} catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return DanhSachNhanVien;
	}
	
	public static void insert(NhanVien NV) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			 String sql = "insert into NhanVien(MaNhanVien, HoTen, GioiTinh, NamSinh, SoDienThoai, MaChucVu) values(?, ?, ?, ?, ?, ?)";
			 
			 statement = connection.prepareCall(sql);
			 
			 statement.setString(1, NV.getMaNhanVien());
			 statement.setString(2, NV.getHoTen());
			 statement.setString(3, NV.getGioiTinh());
			 statement.setInt(4, NV.getNamSinh());
			 statement.setString(5, NV.getSoDienThoai());
			 statement.setString(6, NV.getMaChucVu());
			 
			 statement.execute();
		}  catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}
	
  	public static void update(NhanVien NV) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			 String sql = "update NhanVien set HoTen=?, GioiTinh=?, NamSinh=?, SoDienThoai=?, MaChucVu=? where MaNhanVien = ?";
			 
			 statement = connection.prepareCall(sql);
			 
			 statement.setString(1, NV.getHoTen());
			 statement.setString(2, NV.getGioiTinh());
			 statement.setInt(3, NV.getNamSinh());
			 statement.setString(4, NV.getSoDienThoai());
			 statement.setString(5, NV.getMaChucVu());
			 statement.setString(6, NV.getMaNhanVien());
			 
			 statement.execute();
		}  catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}
	
	public static void delete(String MNV) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			 String sql = "delete from NhanVien where MaNhanVien = ?";
			 
			 statement = connection.prepareCall(sql);
			 
			 statement.setString(1, MNV);
			 
			 statement.execute();
		}  catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}
	
	public static List<NhanVien> filterNhanVienbyMaChucVu(String ChucVu) {
        List<NhanVien> DanhSachNhanVien = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
            
            String sql = "select MaNhanVien, HoTen, GioiTinh, NamSinh, SoDienThoai, MaChucVu "
					+ " from NhanVien"
					+ " where MaChucVu like ?";
            
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+ChucVu+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                NhanVien std = new NhanVien(resultSet.getString("MaNhanVien"), 
                        resultSet.getString("HoTen"), resultSet.getString("GioiTinh"), 
                        resultSet.getInt("NamSinh"), resultSet.getString("SoDienThoai"), 
                        resultSet.getString("MaChucVu"));
                DanhSachNhanVien.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return DanhSachNhanVien;
    }
	
	public static List<NhanVien> findByFullname(String HoTen) {
        List<NhanVien> DanhSachNhanVien = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
            
            String sql = "select MaNhanVien, HoTen, GioiTinh, NamSinh, SoDienThoai, MaChucVu "
					+ " from NhanVien"
					+ " where HoTen like ?";
            
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+HoTen+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                NhanVien std = new NhanVien(resultSet.getString("MaNhanVien"), 
                        resultSet.getString("HoTen"), resultSet.getString("GioiTinh"), 
                        resultSet.getInt("NamSinh"), resultSet.getString("SoDienThoai"), 
                        resultSet.getString("MaChucVu"));
                DanhSachNhanVien.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return DanhSachNhanVien;
    }

	
}


	
