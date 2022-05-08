package QLNS;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class NhanVienFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	DefaultTableModel tableModel;
    
    List<NhanVien> DanhSachNhanVien = new ArrayList<>();
    
    
    public NhanVienFrame() {
    	setForeground(SystemColor.activeCaption);
    	setFont(null);
        initComponents();
        
        tableModel = (DefaultTableModel) tblNhanVien.getModel();
        
        showNhanVien();
    }
    
    private void showNhanVien() {
        DanhSachNhanVien = NhanVienModify.findAll();
        
        tableModel.setRowCount(0);
        
        DanhSachNhanVien.forEach((NhanVien) -> {
            tableModel.addRow(new Object[] {NhanVien.getMaNhanVien(), NhanVien.getHoTen(), 
            		NhanVien.getGioiTinh(), NhanVien.getNamSinh(), NhanVien.getSoDienThoai(), NhanVien.getMaChucVu()});
        });
    }
                  
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbGioiTinh = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNamSinh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbMaChucVu = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnReset = new javax.swing.JButton();
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnDelete = new javax.swing.JButton();
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnFind = new javax.swing.JButton();
        btnFind.setFont(new Font("Tahoma", Font.BOLD, 10));
        jScrollPane1 = new javax.swing.JScrollPane();
        getArrayListMaChucVu();
        
        tblNhanVien = new javax.swing.JTable();
        tblNhanVien.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int i = tblNhanVien.getSelectedRow();
        		TableModel model = tblNhanVien.getModel();
        		txtMaNhanVien.setText((String) model.getValueAt(i, 0));
        		txtHoTen.setText((String) model.getValueAt(i, 1));
        		txtSoDienThoai.setText((String) model.getValueAt(i, 4));
        		txtNamSinh.setText((model.getValueAt(i, 3)).toString());
        		for(int j=0; j < cbGioiTinh.getItemCount(); j++) {
        			if (cbGioiTinh.getItemAt(j).equals(model.getValueAt(i, 2))) {
        				cbGioiTinh.setSelectedIndex(j);
        				break;
        			}
        		}
        		for(int k=0; k < cbMaChucVu.getItemCount(); k++) {
        			if (cbMaChucVu.getItemAt(k).equals(model.getValueAt(i, 5))) {
        				cbMaChucVu.setSelectedIndex(k);
        				break;
        			}
        		}
        	}
        });
        
        
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Career Manager");

        jPanel1.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        jLabel1.setText("H\u1ECD t\u00EAn:");

        jLabel2.setText("Gi\u1EDBi t\u00EDnh: ");

        cbGioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "N\u1EEF"}));
        
        cbGioiTinh.setSelectedIndex(0);

        jLabel3.setText("N\u0103m sinh:");

        jLabel4.setText("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i:");

        jLabel5.setText("Ch\u1EE9c v\u1EE5:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        
        tblNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
               
            }
        });
        
        txtMaNhanVien = new JTextField();
        
        JLabel lblMSNhn = new JLabel();
        lblMSNhn.setText("M\u00E3 nh\u00E2n vi\u00EAn:");
        
        btnUpdate = new JButton();
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        btnUpdate.setText("Update");
        
        JButton btnFilter = new JButton();
        btnFilter.setText("Filter");
        btnFilter.setFont(new Font("Tahoma", Font.BOLD, 10));
        
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(15)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel5)
        				.addComponent(jLabel4)
        				.addComponent(jLabel3)
        				.addComponent(jLabel2)
        				.addComponent(jLabel1)
        				.addComponent(lblMSNhn, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
        			.addGap(28)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(cbGioiTinh, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(txtNamSinh)
        					.addComponent(txtSoDienThoai)
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
        						.addGap(13)
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(btnFind, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        						.addPreferredGap(ComponentPlacement.UNRELATED)
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(btnFilter, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(txtHoTen, Alignment.LEADING)
        					.addComponent(txtMaNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
        				.addComponent(cbMaChucVu, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblMSNhn))
        			.addGap(19)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(cbGioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtNamSinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(cbMaChucVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5))
        			.addGap(34)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSave)
        				.addComponent(btnReset)
        				.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnUpdate)
        				.addComponent(btnFind)
        				.addComponent(btnFilter))
        			.addGap(65))
        );
        jPanel1.setLayout(jPanel1Layout);

        tblNhanVien.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"MNV", "H\u1ECD t\u00EAn", "Gi\u1EDBi t\u00EDnh", "N\u0103m sinh", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "Ch\u1EE9c v\u1EE5"
        	}
        ));
        tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(37);
        tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(126);
        tblNhanVien.getColumnModel().getColumn(2).setPreferredWidth(49);
        tblNhanVien.getColumnModel().getColumn(3).setPreferredWidth(56);
        tblNhanVien.getColumnModel().getColumn(5).setPreferredWidth(87);
        jScrollPane1.setViewportView(tblNhanVien);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(19)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);

        pack();
    }                       

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {     
    	txtMaNhanVien.setText("");
        txtHoTen.setText("");
        cbGioiTinh.setSelectedIndex(0);
        txtNamSinh.setText("");
        txtSoDienThoai.setText("");
        cbMaChucVu.setSelectedIndex(0);
    }                                        

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {   
    	String MaNhanVien = txtMaNhanVien.getText();
        String HoTen = txtHoTen.getText();
        String GioiTinh = cbGioiTinh.getSelectedItem().toString();
        int NamSinh = Integer.parseInt(txtNamSinh.getText());
        String SoDienThoai = txtSoDienThoai.getText();
        String MaChucVu = cbMaChucVu.getSelectedItem().toString();
        NhanVien NhanVien = new NhanVien(MaNhanVien, HoTen, GioiTinh, NamSinh, SoDienThoai, MaChucVu);
        
        NhanVienModify.insert(NhanVien);
        
        showNhanVien();
    }     
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {   
    	String MaNhanVien = txtMaNhanVien.getText();
        String HoTen = txtHoTen.getText();
        String GioiTinh = cbGioiTinh.getSelectedItem().toString();
        int NamSinh = Integer.parseInt(txtNamSinh.getText());
        String SoDienThoai = txtSoDienThoai.getText();
        String MaChucVu = cbMaChucVu.getSelectedItem().toString();
        NhanVien NhanVien = new NhanVien(MaNhanVien, HoTen, GioiTinh, NamSinh, SoDienThoai, MaChucVu);
        
        NhanVienModify.update(NhanVien);
        
        showNhanVien();
    } 
    
    public ArrayList<ChucVu> getArrayListMaChucVu() {
    	ArrayList<ChucVu> list = new ArrayList<>();
    	Connection conn = null;
 		Statement stmt = null;
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CT467", "root", "");
			String sql = "select * from ChucVu";
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
    	 while (rs.next()) {
    	  ChucVu CV = new ChucVu(rs.getString("MaChucVu"), rs.getString("TenChucVu"), rs.getFloat("HeSoLuong"));
    	  list.add(CV);
    	  cbMaChucVu.addItem(rs.getString("MaChucVu"));
    	  }
    	  
    	} catch (Exception e) {
    	  e.printStackTrace();
    	}

    	return list;
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int selectedIndex = tblNhanVien.getSelectedRow();
        if(selectedIndex >= 0) {
            NhanVien NhanVien = DanhSachNhanVien.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this item?");
            if(option == 0) {
                NhanVienModify.delete(NhanVien.getMaNhanVien());
                
                showNhanVien();
            }
        }
    }                                         

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String input = JOptionPane.showInputDialog(this, "Nhap vao ten muon tim kiem");
        if(input != null && input.length() > 0) {
            DanhSachNhanVien = NhanVienModify.findByFullname(input);
            
            tableModel.setRowCount(0);
        
            DanhSachNhanVien.forEach((NhanVien) -> {
                tableModel.addRow(new Object[] {NhanVien.getMaNhanVien(), NhanVien.getHoTen(), 
                		NhanVien.getGioiTinh(), NhanVien.getNamSinh(), NhanVien.getSoDienThoai(),NhanVien.getMaChucVu()});
            });
        } else {
            showNhanVien();
        }
    }
    
    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String input = JOptionPane.showInputDialog(this, "Nhap vao chuc vu ban muon loc");
        if(input != null && input.length() > 0) {
            DanhSachNhanVien = NhanVienModify.filterNhanVienbyMaChucVu(input);
            
            tableModel.setRowCount(0);
        
            DanhSachNhanVien.forEach((NhanVien) -> {
                tableModel.addRow(new Object[] {NhanVien.getMaNhanVien(), NhanVien.getHoTen(), 
                		NhanVien.getGioiTinh(), NhanVien.getNamSinh(), NhanVien.getSoDienThoai(),NhanVien.getMaChucVu()});
            });
        } else {
            showNhanVien();
        }
    }
    
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify   
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtHoTen;
    private static javax.swing.JComboBox<String> cbMaChucVu;
    private JButton btnUpdate;
    private JTextField txtMaNhanVien;
}