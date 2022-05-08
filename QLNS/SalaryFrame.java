package QLNS;

import java.awt.EventQueue;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class SalaryFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblSalary;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryFrame frame = new SalaryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SalaryFrame() {
		setTitle("Qu\u1EA3n l\u00ED l\u01B0\u01A1ng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Th\u00F4ng tin l\u01B0\u01A1ng t\u1EEBng nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShow = new JButton("Display Salay Table");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblSalary.setModel(new DefaultTableModel());
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
					Statement st = con.createStatement();
					String sql = "select NhanVien.MaNhanVien, NhanVien.HoTen, ChucVu.HeSoLuong, count(*) as SoNgayCong, round(HeSoLuong*count(*)*150000,0) as Luong"
							+ " from Nhanvien join ChucVu on NhanVien.MaChucVu = ChucVu.MaChucVu"
							+ "	join ChamCong on ChamCong.MaNhanVien = NhanVien.MaNhanvien"
							+ " group by Nhanvien.MaNhanVien";
					
					ResultSet rs = st.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tblSalary.getModel();
					int cols = rsmd.getColumnCount();
					
					String[] colName = new String[cols];
					for(int i=0; i<cols; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					String MaNhanVien, HoTen, HeSoLuong, SoNgayCong, Luong;
					String[] rows = {MaNhanVien="Ma nhan vien", HoTen="Ho ten", HeSoLuong="HSL", SoNgayCong="So ngay cong", Luong="Thanh tien"};
					model.addRow(rows);
					while(rs.next()) {
						MaNhanVien=rs.getString(1);
						HoTen=rs.getString(2);
						HeSoLuong=rs.getString(3);
						SoNgayCong=rs.getString(4);
						Luong=rs.getString(5);
						String[] row = {MaNhanVien, HoTen, HeSoLuong, SoNgayCong, Luong};
						model.addRow(row);
					}
					st.close();
					con.close();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnShow.setBounds(20, 43, 144, 28);
		contentPane.add(btnShow);
		
		tblSalary = new JTable();
		tblSalary.setToolTipText("");
		tblSalary.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		tblSalary.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tblSalary.setBounds(20, 104, 596, 337);
		contentPane.add(tblSalary);
		
		JButton btnClear = new JButton("Clear Table");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblSalary.setModel(new DefaultTableModel());
			}
		});
		btnClear.setBounds(206, 43, 144, 28);
		contentPane.add(btnClear);
		
		JButton btnSpXpTheo = new JButton("Sort by Salary");
		btnSpXpTheo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tblSalary.setModel(new DefaultTableModel());
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
					Statement st = con.createStatement();
					String sql = "select NhanVien.MaNhanVien, NhanVien.HoTen, ChucVu.HeSoLuong, count(*) as SoNgayCong, round(HeSoLuong*count(*)*150000,0) as Luong"
							+ " from Nhanvien join ChucVu on NhanVien.MaChucVu = ChucVu.MaChucVu"
							+ "	join ChamCong on ChamCong.MaNhanVien = NhanVien.MaNhanvien"
							+ " group by Nhanvien.MaNhanVien"
							+ " order by Luong desc";
					
					ResultSet rs = st.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tblSalary.getModel();
					int cols = rsmd.getColumnCount();
					
					String[] colName = new String[cols];
					for(int i=0; i<cols; i++) {
						colName[i] = rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					String MaNhanVien, HoTen, HeSoLuong, SoNgayCong, Luong;
					String[] rows = {MaNhanVien="Ma nhan vien", HoTen="Ho ten", HeSoLuong="HSL", SoNgayCong="So ngay cong", Luong="Thanh tien"};
					model.addRow(rows);
					while(rs.next()) {
						MaNhanVien=rs.getString(1);
						HoTen=rs.getString(2);
						HeSoLuong=rs.getString(3);
						SoNgayCong=rs.getString(4);
						Luong=rs.getString(5);
						String[] row = {MaNhanVien, HoTen, HeSoLuong, SoNgayCong, Luong};
						model.addRow(row);
					}
					st.close();
					con.close();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnSpXpTheo.setBounds(394, 43, 144, 28);
		contentPane.add(btnSpXpTheo);
	}
}
