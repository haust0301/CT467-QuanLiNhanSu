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

public class ChucVuModify {
	public static List<ChucVu> findAll() {
		List<ChucVu> DanhSachChucVu = new ArrayList<>();
		Connection cn = null;
		Statement statement = null;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			String sql = "select * from ChucVu";
			statement = cn.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {                
                ChucVu CV = new ChucVu(resultSet.getString("MaChucVu"), 
                        resultSet.getString("TenChucVu"), resultSet.getFloat("HeSoLuong")
                        );
                DanhSachChucVu.add(CV);
            }
		} catch (SQLException ex) {
            Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return DanhSachChucVu;
	}
	
	public static List<ChucVu> filterChucVubyHeSoLuong(String HeSoLuong) {
        List<ChucVu> DanhSachChucVu = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
            
            String sql = "select MaChucVu, TenChucVu, HeSoLuong "
					+ " from ChucVu"
					+ " where HeSoLuong like ?";
            
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+HeSoLuong+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                ChucVu CV = new ChucVu(resultSet.getString("MaChucVu"), 
                        resultSet.getString("TenChucVu"), resultSet.getFloat("heSoLuong"));
                DanhSachChucVu.add(CV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return DanhSachChucVu;
    }
	
	public static void insert(ChucVu CV) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			 String sql = "insert into ChucVu(MaChucVu, TenChucVu, HeSoLuong) values(?, ?, ?)";
			 
			 statement = connection.prepareCall(sql);
			 
			 statement.setString(1, CV.getMaChucVu());
			 statement.setString(2, CV.getTenChucVu());
			 statement.setFloat(3, CV.getHeSoLuong());
			 
			 statement.execute();
		}  catch (SQLException ex) {
            Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}
	
	public static void update(ChucVu CV) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			 String sql = "update ChucVu set TenChucVu=?, HeSoLuong=? where MaChucVu = ?";
			 
			 statement = connection.prepareCall(sql);
			 
			 statement.setString(1, CV.getTenChucVu());
			 statement.setFloat(2, CV.getHeSoLuong());
			 statement.setString(3, CV.getMaChucVu());
			 
			 statement.execute();
		}  catch (SQLException ex) {
            Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}

	public static void delete(String MCV) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			 String sql = "delete from ChucVu where MaChucVu = ?";
			 
			 statement = connection.prepareCall(sql);
			 
			 statement.setString(1, MCV);
			 
			 statement.execute();
		}  catch (SQLException ex) {
            Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}

	public static List<ChucVu> findByTenChucVu(String TenChucVu) {
        List<ChucVu> DanhSachChucVu = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
            
            String sql = "select * from ChucVu where TenChucVu like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+TenChucVu+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                ChucVu std = new ChucVu(resultSet.getString("MaChucVu"), 
                        resultSet.getString("TenChucVu"), resultSet.getFloat("HeSoLuong"));
                DanhSachChucVu.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return DanhSachChucVu;
    }
} 
