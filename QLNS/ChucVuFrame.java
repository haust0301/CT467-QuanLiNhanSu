package QLNS;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.Font;


public class ChucVuFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	DefaultTableModel tableModel1;
    
    List<ChucVu> DanhSachChucVu = new ArrayList<>();
    
    
    public ChucVuFrame() {
    	setForeground(SystemColor.activeCaption);
    	setFont(null);
        initComponents();
        
        tableModel1 = (DefaultTableModel) tblChucVu.getModel();
        
        showChucVu();
    }
    
    private void showChucVu() {
        DanhSachChucVu = ChucVuModify.findAll();
        
        tableModel1.setRowCount(0);
        
        DanhSachChucVu.forEach((ChucVu) -> {
            tableModel1.addRow(new Object[] {ChucVu.getMaChucVu(), 
            		ChucVu.getTenChucVu(), ChucVu.getHeSoLuong()});
        });
    }
                   
    private void initComponents() {
    	
    	jPanel1 = new javax.swing.JPanel();
    	jLabel1 = new javax.swing.JLabel();
        txtMaChucVu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenChucVu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHeSoLuong = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnReset = new javax.swing.JButton();
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnDelete = new javax.swing.JButton();
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnFind = new javax.swing.JButton();
        btnFind.setFont(new Font("Tahoma", Font.BOLD, 10));
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChucVu = new javax.swing.JTable();
        tblChucVu.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int i = tblChucVu.getSelectedRow();
        		TableModel model = tblChucVu.getModel();
        		txtMaChucVu.setText((String) model.getValueAt(i, 0));
        		txtTenChucVu.setText((String) model.getValueAt(i, 1));
        		txtHeSoLuong.setText((model.getValueAt(i, 2)).toString());
        	}
        });
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quan ly chuc vu");

        jPanel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin ch\u1EE9c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        jLabel1.setText("M\u00E3 ch\u1EE9c v\u1EE5:");

        jLabel2.setText("T\u00EAn ch\u1EE9c v\u1EE5:");

        jLabel3.setText("H\u1EC7 s\u1ED1 l\u01B0\u01A1ng:");

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
        
        JButton btnUpdate = new JButton();
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
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
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addComponent(jLabel3))
        			.addGap(52)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(btnFind, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnFilter, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
        				.addComponent(txtTenChucVu, 322, 322, 322)
        				.addComponent(txtMaChucVu, 303, 322, Short.MAX_VALUE)
        				.addComponent(txtHeSoLuong, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(txtMaChucVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(txtTenChucVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(17)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtHeSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnDelete))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnFind, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnFilter))
        			.addGap(42))
        );
        jPanel1.setLayout(jPanel1Layout);

        tblChucVu.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        	},
        	new String[] {
        		"MCV", "T\u00EAn Ch\u1EE9c V\u1EE5", "H\u1EC7 S\u1ED1 L\u01B0\u01A1ng"
        	}
        ));
        tblChucVu.getColumnModel().getColumn(0).setPreferredWidth(37);
        tblChucVu.getColumnModel().getColumn(1).setPreferredWidth(183);
        tblChucVu.getColumnModel().getColumn(2).setPreferredWidth(128);
        jScrollPane1.setViewportView(tblChucVu);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane1, Alignment.LEADING)
        				.addComponent(jPanel1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
        			.addGap(26))
        );
        getContentPane().setLayout(groupLayout);

        pack();
    }                       

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
        txtMaChucVu.setText("");
        txtTenChucVu.setText("");
        txtHeSoLuong.setText("");
    }                                        

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String MaChucVu = txtMaChucVu.getText();
        String TenChucVu = txtTenChucVu.getText();
        float HeSoLuong = Float.parseFloat(txtHeSoLuong.getText());
        ChucVu ChucVu = new ChucVu(MaChucVu, TenChucVu, HeSoLuong);
        
        ChucVuModify.insert(ChucVu);
        
        showChucVu();
    }                                       

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int selectedIndex = tblChucVu.getSelectedRow();
        if(selectedIndex >= 0) {
            ChucVu ChucVu = DanhSachChucVu.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this item?");
            
            if(option == 0) {
                ChucVuModify.delete(ChucVu.getMaChucVu());
                
                showChucVu();
            } else {
            	System.out.println("Ban khong the xoa chuc vu này");
            }
        }
    }    
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {   
    	String MaChucVu = txtMaChucVu.getText();
        String TenChucVu = txtTenChucVu.getText();
        float HeSoLuong = Float.parseFloat(txtHeSoLuong.getText());
        ChucVu CV = new ChucVu(MaChucVu, TenChucVu, HeSoLuong);
        
        ChucVuModify.update(CV);
        
        showChucVu();
    } 

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String input = JOptionPane.showInputDialog(this, "Enter chuc vu to search");
        if(input != null && input.length() > 0) {
            DanhSachChucVu = ChucVuModify.findByTenChucVu(input);
            
            tableModel1.setRowCount(0);
        
            DanhSachChucVu.forEach((ChucVu) -> {
                tableModel1.addRow(new Object[] {ChucVu.getMaChucVu(), 
                		ChucVu.getTenChucVu(), ChucVu.getHeSoLuong()});
            });
        } else {
            showChucVu();
        }
    }          
    
    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String input = JOptionPane.showInputDialog(this, "Nhap vao he so luong ban muon loc");
        if(input != null) {
            DanhSachChucVu = ChucVuModify.filterChucVubyHeSoLuong(input);
            
            tableModel1.setRowCount(0);
        
            DanhSachChucVu.forEach((ChucVu) -> {
            	tableModel1.addRow(new Object[] {ChucVu.getMaChucVu(), ChucVu.getTenChucVu(), 
                		ChucVu.getHeSoLuong()});
            });
        } else {
            showChucVu();
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
            java.util.logging.Logger.getLogger(ChucVuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChucVuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChucVuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChucVuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChucVuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChucVu;
    private javax.swing.JTextField txtMaChucVu;
    private javax.swing.JTextField txtTenChucVu;
    private javax.swing.JTextField txtHeSoLuong;
}