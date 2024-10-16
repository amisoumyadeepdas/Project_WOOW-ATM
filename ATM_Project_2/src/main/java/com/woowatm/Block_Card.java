package com.woowatm;

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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class Block_Card extends JFrame {

	/**
	 * Create the frame.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAtm;
	private JTextField textField;
	private JTextField textField_1;

	public Block_Card(String str) {
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

		JLabel lblNewLabel_1 = new JLabel("Enter Card Details");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_1.setBounds(309, 50, 434, 81);
		contentPane.add(lblNewLabel_1);

		JButton btnBanking = new JButton("Back");
		btnBanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanking.setOpaque(true);
		btnBanking.setForeground(Color.WHITE);
		btnBanking.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnBanking.setFocusPainted(false);
		btnBanking.setBorderPainted(false);
		btnBanking.setBackground(new Color(112, 128, 144));
		btnBanking.setBounds(243, 469, 247, 96);

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

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		layeredPane.setBackground(new Color(240, 255, 240));
		layeredPane.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane.setBounds(82, 212, 247, 70);
		contentPane.add(layeredPane);

		JLabel lblNewLabel_2 = new JLabel("Card NO:");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_2.setBounds(10, 0, 180, 63);
		layeredPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 40));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(UIManager.getBorder("RadioButton.border"));
		layeredPane_1.setBackground(new Color(240, 255, 240));
		layeredPane_1.setBounds(239, 465, 254, 104);
		contentPane.add(layeredPane_1);

		JButton btnBanking_1 = new JButton("Submit");
		btnBanking_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accno = textField_1.getText();
				if (cs.blockCard(accno)) {
					JOptionPane.showConfirmDialog(null, "Card Block!");
					String a[] = new String[] {};
					MainPage.main(a);
				} else {
					JOptionPane.showConfirmDialog(null, "Invalid card Details!");
				}
			}
		});
		btnBanking_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanking_1.setOpaque(true);
		btnBanking_1.setForeground(Color.WHITE);
		btnBanking_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnBanking_1.setFocusPainted(false);
		btnBanking_1.setBorderPainted(false);
		btnBanking_1.setBackground(new Color(112, 128, 144));
		btnBanking_1.setBounds(672, 465, 247, 96);

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
		layeredPane_1_1.setBounds(668, 461, 254, 104);
		contentPane.add(layeredPane_1_1);

		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_2.setBackground(new Color(240, 255, 240));
		layeredPane_2.setBounds(339, 212, 598, 70);
		contentPane.add(layeredPane_2);
		layeredPane_2.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setBounds(10, 10, 578, 51);
		layeredPane_2.add(textField);
		textField.setBorder(UIManager.getBorder("CheckBox.border"));
		textField.setColumns(10);

		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_3.setBackground(new Color(240, 255, 240));
		layeredPane_3.setBounds(82, 310, 247, 70);
		contentPane.add(layeredPane_3);

		JLayeredPane layeredPane_2_1 = new JLayeredPane();
		layeredPane_2_1.setLayout(null);
		layeredPane_2_1.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_2_1.setBackground(new Color(240, 255, 240));
		layeredPane_2_1.setBounds(339, 310, 598, 70);
		contentPane.add(layeredPane_2_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBorder(UIManager.getBorder("CheckBox.border"));
		textField_1.setBounds(10, 10, 578, 51);
		layeredPane_2_1.add(textField_1);

		JLabel lblNewLabel_2_1 = new JLabel("Account No:");
		lblNewLabel_2_1.setBounds(93, 310, 246, 63);
		contentPane.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 40));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Block_Card frame = new Block_Card("ATM project");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
