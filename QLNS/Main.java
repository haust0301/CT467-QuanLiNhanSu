package QLNS;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Main extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new javax.swing.JButton("Qu\u1EA3n l\u00ED th\u00F4ng tin nh\u00E2n vi\u00EAn");

		JButton btnNewButton_2 = new javax.swing.JButton("Qu\u1EA3n l\u00ED ch\u1EE9c v\u1EE5");
		
		JButton btnNewButton_3 = new javax.swing.JButton("Ch\u1EA5m c\u00F4ng");
		
		JLabel lblNewLabel = new JLabel("\u1EE8ng d\u1EE5ng qu\u1EA3n l\u00ED nh\u00E2n vi\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNewButton = new JButton("B\u1EA3ng l\u01B0\u01A1ng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(8, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(83, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(9))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	NhanVienFrame frame = new NhanVienFrame();
            	frame.setVisible(true);
            }
        });
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ChucVuFrame frame = new ChucVuFrame();
            	frame.setVisible(true);
            }
        });
		btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ChamCongFrame frame = new ChamCongFrame();
            	frame.setVisible(true);
            }
        });
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SalaryFrame frame = new SalaryFrame();
            	frame.setVisible(true);
            }
        });
		
	}
}
