package QLNS;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;


public class ChamCongFrame extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;

	DefaultTableModel tableModel1;
    
    List<ChamCong> DanhSachChamCong = new ArrayList<>();
    
    
    public ChamCongFrame() {
    	setForeground(SystemColor.activeCaption);
    	setFont(null);
        initComponents();
        
        tableModel1 = (DefaultTableModel) tblChamCong.getModel();
        
        showChamCong();
    }
    
    private void showChamCong() {
        DanhSachChamCong = ChamCongModify.findAll();
        
        tableModel1.setRowCount(0);
        
        DanhSachChamCong.forEach((ChamCong) -> {
            tableModel1.addRow(new Object[] {ChamCong.getNgayChamCong(), 
            		ChamCong.getMaNhanVien()});
        });
    }
                  
    private void initComponents() {
    	
    	jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnReset = new javax.swing.JButton();
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 10));
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChamCong = new javax.swing.JTable();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Qu\u1EA3n l\u00FD ch\u1EA5m c\u00F4ng");

        jPanel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin ch\u1EA5m c\u00F4ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        jLabel2.setText("M\u00E3 nh\u00E2n vi\u00EAn:");

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
        
        btnFilter = new JButton();
        btnFilter.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(jLabel2)
        			.addGap(47)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtMaNhanVien, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnFilter, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addGap(36)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSave)
        				.addComponent(btnReset)
        				.addComponent(btnFilter))
        			.addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        tblChamCong.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null},
        	},
        	new String[] {
        		" Ng\u00E0y ch\u1EA5m c\u00F4ng", "T\u00EAn nh\u00E2n vi\u00EAn"
        	}
        ));
        tblChamCong.getColumnModel().getColumn(0).setPreferredWidth(114);
        tblChamCong.getColumnModel().getColumn(1).setPreferredWidth(293);
        jScrollPane1.setViewportView(tblChamCong);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        			.addGap(55)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
        			.addGap(43))
        );
        getContentPane().setLayout(groupLayout);

        pack();
    }                       

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        txtMaNhanVien.setText("");
    }                                        

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String MaNhanVien = txtMaNhanVien.getText();
        ChamCong CC = new ChamCong(MaNhanVien);
        
        ChamCongModify.insert(CC);
        
        showChamCong();
    }                                       
                
    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String input = txtMaNhanVien.getText();
        if(input != null && input.length() > 0) {
            DanhSachChamCong = ChamCongModify.filterChamCongByMaNhanVien(input);
            
            tableModel1.setRowCount(0);
        
            DanhSachChamCong.forEach((ChamCong) -> {
            	tableModel1.addRow(new Object[] {ChamCong.getNgayChamCong(), ChamCong.getMaNhanVien()});
            });
        } else {
            showChamCong();
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
            java.util.logging.Logger.getLogger(ChamCongFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChamCongFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChamCongFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChamCongFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChamCongFrame().setVisible(true);
            }
        });
    }
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChamCong;
    private javax.swing.JTextField txtMaNhanVien;
    private JButton btnFilter;
}