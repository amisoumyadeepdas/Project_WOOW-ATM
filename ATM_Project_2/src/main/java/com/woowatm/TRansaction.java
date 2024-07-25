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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class TRansaction extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAtm;

	public TRansaction(String str, String pin, String accNo) {
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

		JLabel lblNewLabel_1 = new JLabel("Transaction History:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 70));
		lblNewLabel_1.setBounds(208, 23, 656, 81);
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
		btnBanking.setBounds(415, 544, 247, 96);

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
		layeredPane_1.setBounds(411, 540, 254, 104);
		contentPane.add(layeredPane_1);

		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_2.setBackground(new Color(240, 255, 240));
		layeredPane_2.setBounds(110, 114, 866, 406);
		contentPane.add(layeredPane_2);
		layeredPane_2.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane_2.add(panel, "name_318144840548700");
		panel.setLayout(null);

		JTextArea txtrIAmA = new JTextArea(cs.transactionHistory(accNo));
		txtrIAmA.setBackground(new Color(51, 102, 102));
		txtrIAmA.setEditable(false);
		txtrIAmA.setOpaque(true);
		txtrIAmA.setFocusable(false);
		txtrIAmA.setLineWrap(true);
		txtrIAmA.setWrapStyleWord(true);
		txtrIAmA.setForeground(Color.LIGHT_GRAY);
		txtrIAmA.setFont(new Font("Tahoma", Font.PLAIN, 32));

		// Add the JTextArea to a JScrollPane if you want it to scroll
		JScrollPane scrollPane = new JScrollPane(txtrIAmA);
		scrollPane.setBorder(null); // Remove the border if you don't want it
		scrollPane.setBounds(10, 85, 842, 307);
		panel.add(scrollPane); // Add the JScrollPane to the panel

		JLabel lblNewLabel_2_1 = new JLabel("AccNo:  Transation Type:  Amount:\r\n");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setBounds(10, 20, 842, 73);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 48));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TRansaction frame = new TRansaction("ATM project", args[0], args[1]);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
