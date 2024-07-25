package com.woowatm;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class Transfer_1 extends JFrame {

	/**
	 * Create the frame.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAtm;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public Transfer_1(String str, String pin, String ownerAccNo) {
		// System.out.println(pin);
		setTitle(str);

		CheckService cs = new CheckService();
//		accountHolder user = cs.getDetails(pin);

		setBackground(new Color(204, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 707);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_2.setBackground(new Color(169, 169, 169));
		panel_2.setBounds(637, 184, 240, 41);
		contentPane.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));

		JLayeredPane layeredPane_3 = new JLayeredPane();
		panel_2.add(layeredPane_3, "name_313816198881800");
		layeredPane_3.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_3.setBackground(new Color(240, 255, 240));

		JLabel lblNewLabel_2_1 = new JLabel("Re-enter Account Number");
		lblNewLabel_2_1.setBounds(10, 0, 214, 37);
		layeredPane_3.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JPanel panel = new JPanel();
		panel.setBounds(108, 184, 164, 41);
		contentPane.add(panel);
		panel.setBackground(new Color(169, 169, 169));
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		panel.setLayout(new CardLayout(0, 0));

		JLayeredPane layeredPane = new JLayeredPane();
		panel.add(layeredPane, "name_279055441641900");
		layeredPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		layeredPane.setBackground(new Color(240, 255, 240));
		layeredPane.setBorder(UIManager.getBorder("CheckBox.border"));

		JLabel lblNewLabel_2 = new JLabel("Account Number");
		lblNewLabel_2.setBounds(10, 0, 140, 37);
		layeredPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel("WOOW");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		lblNewLabel.setBounds(936, 3, 80, 36);
		contentPane.add(lblNewLabel);

		lblAtm = new JLabel("ATM");
		lblAtm.setForeground(new Color(128, 0, 0));
		lblAtm.setFont(new Font("Arial", lblAtm.getFont().getStyle() | Font.BOLD | Font.ITALIC,
				lblAtm.getFont().getSize() + 15));
		lblAtm.setBounds(1000, 3, 71, 36);
		contentPane.add(lblAtm);

		JLabel lblNewLabel_1 = new JLabel("Enter Recipient Details");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_1.setBounds(271, 48, 516, 81);
		contentPane.add(lblNewLabel_1);

		JButton btnBanking = new JButton("Back");
		btnBanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[] { pin };
				Menu_atm.main(a);
			}
		});
		btnBanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanking.setOpaque(true);
		btnBanking.setForeground(Color.WHITE);
		btnBanking.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnBanking.setFocusPainted(false);
		btnBanking.setBorderPainted(false);
		btnBanking.setBackground(new Color(112, 128, 144));
		btnBanking.setBounds(221, 528, 247, 96);

		// Add mouse listener for hover and press effects
		Color hoverBackgroundColor = new Color(144, 164, 174);
		Color pressedBackgroundColor = new Color(47, 79, 79);

		btnBanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBanking.setBackground(hoverBackgroundColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBanking.setBackground(new Color(112, 128, 144));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnBanking.setBackground(pressedBackgroundColor);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnBanking.setBackground(new Color(112, 128, 144));
			}
		});

		contentPane.add(btnBanking);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(UIManager.getBorder("RadioButton.border"));
		layeredPane_1.setBackground(new Color(240, 255, 240));
		layeredPane_1.setBounds(217, 524, 254, 104);
		contentPane.add(layeredPane_1);

		JButton btnBanking_1 = new JButton("Confirm");
		btnBanking_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CHECK ACCOUNT-NO AND RE-ENTER ACCNO ARE SAME OR NOT
				if (textField.getText().equalsIgnoreCase(textField_2.getText())) {
					// CHECK AUTHENTICATION OF TRANSFER ACCOUNT-NO AND IFSC CODE
					if (cs.checkAccnoIfscCode(textField.getText(), textField_1.getText())) {
						String a[] = new String[] { pin, ownerAccNo, textField.getText(), textField_1.getText() };
						Transfer_2.main(a); // ownerAccNo transferAccountNo transferAccountIFSC-CODE
					} else
						JOptionPane.showConfirmDialog(null, "invalid Account-No or IFSC-CODE !");
				} else
					JOptionPane.showConfirmDialog(null, "Account-No and re-enter accountNo are Different!");
			}
		});
		btnBanking_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanking_1.setOpaque(true);
		btnBanking_1.setForeground(Color.WHITE);
		btnBanking_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnBanking_1.setFocusPainted(false);
		btnBanking_1.setBorderPainted(false);
		btnBanking_1.setBackground(new Color(112, 128, 144));
		btnBanking_1.setBounds(650, 524, 247, 96);

		// Add mouse listener for hover and press effects
		Color hoverBackgroundColor1 = new Color(144, 164, 174);
		Color pressedBackgroundColor1 = new Color(47, 79, 79);

		btnBanking_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBanking_1.setBackground(hoverBackgroundColor1);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBanking_1.setBackground(new Color(112, 128, 144));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnBanking_1.setBackground(pressedBackgroundColor1);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnBanking_1.setBackground(new Color(112, 128, 144));
			}
		});
		contentPane.add(btnBanking_1);

		JLayeredPane layeredPane_1_1 = new JLayeredPane();
		layeredPane_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		layeredPane_1_1.setBorder(UIManager.getBorder("RadioButton.border"));
		layeredPane_1_1.setBackground(new Color(240, 255, 240));
		layeredPane_1_1.setBounds(646, 520, 254, 104);
		contentPane.add(layeredPane_1_1);

		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_2.setBackground(new Color(240, 255, 240));
		layeredPane_2.setBounds(85, 213, 424, 71);
		contentPane.add(layeredPane_2);
		layeredPane_2.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setBounds(10, 20, 404, 43);
		layeredPane_2.add(textField);
		textField.setBorder(UIManager.getBorder("CheckBox.border"));
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_1.setBackground(new Color(169, 169, 169));
		panel_1.setBounds(108, 339, 140, 41);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JLayeredPane layeredPane_4 = new JLayeredPane();
		panel_1.add(layeredPane_4, "name_314009622782800");
		layeredPane_4.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_4.setBackground(new Color(240, 255, 240));

		JLabel lblNewLabel_2_3 = new JLabel("IFSC Code");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(26, 0, 97, 37);
		layeredPane_4.add(lblNewLabel_2_3);

		JLayeredPane layeredPane_2_1 = new JLayeredPane();
		layeredPane_2_1.setLayout(null);
		layeredPane_2_1.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_2_1.setBackground(new Color(240, 255, 240));
		layeredPane_2_1.setBounds(85, 368, 424, 71);
		contentPane.add(layeredPane_2_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBorder(UIManager.getBorder("CheckBox.border"));
		textField_1.setBounds(10, 20, 404, 43);
		layeredPane_2_1.add(textField_1);

		JLayeredPane layeredPane_2_2 = new JLayeredPane();
		layeredPane_2_2.setLayout(null);
		layeredPane_2_2.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_2_2.setBackground(new Color(240, 255, 240));
		layeredPane_2_2.setBounds(614, 213, 424, 71);
		contentPane.add(layeredPane_2_2);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField_2.setColumns(10);
		textField_2.setBorder(UIManager.getBorder("CheckBox.border"));
		textField_2.setBounds(10, 20, 404, 43);
		layeredPane_2_2.add(textField_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_3.setBackground(new Color(169, 169, 169));
		panel_3.setBounds(637, 339, 164, 41);
		contentPane.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		JLayeredPane layeredPane_5 = new JLayeredPane();
		panel_3.add(layeredPane_5, "name_314375554188900");
		layeredPane_5.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_5.setBackground(new Color(240, 255, 240));

		JLabel lblNewLabel_2_4 = new JLabel("Receiver's Name");
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_4.setBounds(13, 0, 140, 37);
		layeredPane_5.add(lblNewLabel_2_4);

		JLayeredPane layeredPane_2_3 = new JLayeredPane();
		layeredPane_2_3.setLayout(null);
		layeredPane_2_3.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_2_3.setBackground(new Color(240, 255, 240));
		layeredPane_2_3.setBounds(614, 368, 424, 71);
		contentPane.add(layeredPane_2_3);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField_3.setColumns(10);
		textField_3.setBorder(UIManager.getBorder("CheckBox.border"));
		textField_3.setBounds(10, 20, 404, 43);
		layeredPane_2_3.add(textField_3);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer_1 frame = new Transfer_1("ATM project", args[0], args[1]);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
