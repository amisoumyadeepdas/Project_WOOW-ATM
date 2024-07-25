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

public class SetUpPin_2 extends JFrame {

	/**
	 * Create the frame.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAtm;
	private JTextField textField;

	public SetUpPin_2(String str, String accNo) {
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

		JLabel lblNewLabel_1 = new JLabel("Enter Your New 4-Digit PIN ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_1.setBounds(224, 50, 647, 81);
		contentPane.add(lblNewLabel_1);

		JButton btnBanking = new JButton("Back");
		btnBanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[] {};
				SetUpPin_1.main(a);
			}
		});
		btnBanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanking.setOpaque(true);
		btnBanking.setForeground(Color.WHITE);
		btnBanking.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnBanking.setFocusPainted(false);
		btnBanking.setBorderPainted(false);
		btnBanking.setBackground(new Color(112, 128, 144));
		btnBanking.setBounds(243, 453, 247, 96);

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
		layeredPane.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		layeredPane.setBackground(new Color(240, 255, 240));
		layeredPane.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane.setBounds(83, 262, 230, 70);
		contentPane.add(layeredPane);

		JLabel lblNewLabel_2 = new JLabel("PIN No :");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_2.setBounds(10, 0, 180, 63);
		layeredPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 40));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(UIManager.getBorder("RadioButton.border"));
		layeredPane_1.setBackground(new Color(240, 255, 240));
		layeredPane_1.setBounds(239, 449, 254, 104);
		contentPane.add(layeredPane_1);

		JButton btnBanking_1 = new JButton("Finish");
		btnBanking_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pin = textField.getText();
				if (cs.setPin(accNo, pin)) {
					JOptionPane.showConfirmDialog(null, "Successful!");
					String a[] = new String[] {};
					MainPage.main(a);
				} else
					JOptionPane.showConfirmDialog(null, "invalid pin!");
			}
		});
		btnBanking_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanking_1.setOpaque(true);
		btnBanking_1.setForeground(Color.WHITE);
		btnBanking_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnBanking_1.setFocusPainted(false);
		btnBanking_1.setBorderPainted(false);
		btnBanking_1.setBackground(new Color(112, 128, 144));
		btnBanking_1.setBounds(672, 449, 247, 96);

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
		layeredPane_1_1.setBounds(668, 445, 254, 104);
		contentPane.add(layeredPane_1_1);

		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_2.setBackground(new Color(240, 255, 240));
		layeredPane_2.setBounds(324, 262, 598, 70);
		contentPane.add(layeredPane_2);
		layeredPane_2.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setBounds(10, 10, 578, 51);
		layeredPane_2.add(textField);
		textField.setBorder(UIManager.getBorder("CheckBox.border"));
		textField.setColumns(10);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetUpPin_2 frame = new SetUpPin_2("ATM project", args[0]);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
