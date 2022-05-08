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

public class ChamCongModify {
	public static List<ChamCong> findAll() {
		List<ChamCong> DanhSachChamCong = new ArrayList<>();
		Connection cn = null;
		Statement statement = null;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			String sql = "select NgayChamCong, HoTen"
					+ " from ChamCong, NhanVien"
					+ " where ChamCong.MaNhanVien = NhanVien.MaNhanVien";
			statement = cn.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {                
                ChamCong CC = new ChamCong(
                		resultSet.getDate("NgayChamCong"),
                        resultSet.getString("HoTen")
                        );
                DanhSachChamCong.add(CC);
            }
		} catch (SQLException ex) {
            Logger.getLogger(ChamCongModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChamCongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChamCongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return DanhSachChamCong;
	}
	
	public static void insert(ChamCong CC) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			 String sql = "insert into ChamCong(NgayChamCong, MaNhanVien) values(?, ?)";
			 
			 statement = connection.prepareCall(sql);
			 
			 statement.setDate(1, CC.getNgayChamCong());
			 statement.setString(2, CC.getMaNhanVien());
			 
			 statement.execute();
		}  catch (SQLException ex) {
            Logger.getLogger(ChamCongModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChamCongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChamCongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}
	
	public static List<ChamCong> filterChamCongByMaNhanVien(String MaNhanVien) {
        List<ChamCong> DanhSachChamCong = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
            
            String sql = "select NgayChamCong, HoTen "
					+ " from ChamCong, NhanVien"
					+ " where ChamCong.MaNhanVien = NhanVien.MaNhanVien and ChamCong.MaNhanVien like ?";
            
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+MaNhanVien+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                ChamCong CC = new ChamCong(resultSet.getDate("NgayChamCong"), 
                        resultSet.getString("HoTen"));
                DanhSachChamCong.add(CC);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChamCongModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChamCongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChamCongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return DanhSachChamCong;
    }
	
} 
