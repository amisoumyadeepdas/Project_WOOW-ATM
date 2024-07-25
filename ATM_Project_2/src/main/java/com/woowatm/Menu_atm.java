package com.woowatm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class Menu_atm extends JFrame {

	/**
	 * Create the frame.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAtm;

	public Menu_atm(String str, String pin) {
		// System.out.println(pin);
		setTitle(str);

		CheckService cs = new CheckService();
		accountHolder user = cs.getDetails(pin);

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

		// Customize Enter PIN button to resemble CustomButton
		JButton btnNewButton = new JButton("WithDraw");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[] { pin, user.getAccNo() };
				Withdraw.main(a);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton.setBounds(398, 213, 247, 96);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(112, 128, 144)); // Initial background color
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(true);

		// Add mouse listener for hover and press effects
		Color hoverBackgroundColor = new Color(144, 164, 174);
		Color pressedBackgroundColor = new Color(47, 79, 79);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(hoverBackgroundColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(112, 128, 144));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setBackground(pressedBackgroundColor);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.setBackground(new Color(112, 128, 144));
			}
		});

		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Welcome!");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_1.setBounds(272, 50, 294, 81);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel(user.getName());
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_1.setBounds(502, 50, 412, 81);
		contentPane.add(lblNewLabel_1_1);

		JButton btnDeposite = new JButton("Deposite");
		btnDeposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[] { pin, user.getAccNo() };
				Deposite.main(a);
			}
		});
		btnDeposite.setOpaque(true);
		btnDeposite.setForeground(Color.WHITE);
		btnDeposite.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnDeposite.setFocusPainted(false);
		btnDeposite.setBorderPainted(false);
		btnDeposite.setBackground(new Color(112, 128, 144));
		btnDeposite.setBounds(767, 213, 247, 96);
		contentPane.add(btnDeposite);

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[] { pin, user.getAccNo() };
				Transfer_1.main(a);
			}
		});
		btnTransfer.setOpaque(true);
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnTransfer.setFocusPainted(false);
		btnTransfer.setBorderPainted(false);
		btnTransfer.setBackground(new Color(112, 128, 144));
		btnTransfer.setBounds(398, 385, 247, 96);
		contentPane.add(btnTransfer);

		JButton btnBanking = new JButton("Block Card");
		btnBanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[] { pin };
				Block_Card.main(a);
			}
		});
		btnBanking.setOpaque(true);
		btnBanking.setForeground(Color.WHITE);
		btnBanking.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnBanking.setFocusPainted(false);
		btnBanking.setBorderPainted(false);
		btnBanking.setBackground(new Color(112, 128, 144));
		btnBanking.setBounds(398, 541, 247, 96);
		contentPane.add(btnBanking);

		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[] { pin, user.getAccNo() };
				Balance.main(a);
			}
		});
		btnBalance.setOpaque(true);
		btnBalance.setForeground(Color.WHITE);
		btnBalance.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnBalance.setFocusPainted(false);
		btnBalance.setBorderPainted(false);
		btnBalance.setBackground(new Color(112, 128, 144));
		btnBalance.setBounds(769, 385, 247, 96);
		contentPane.add(btnBalance);

		JButton btnBlockCard = new JButton("Transaction");
		btnBlockCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[] { pin, user.getAccNo() };
				TRansaction.main(a);
			}
		});
		btnBlockCard.setOpaque(true);
		btnBlockCard.setForeground(Color.WHITE);
		btnBlockCard.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnBlockCard.setFocusPainted(false);
		btnBlockCard.setBorderPainted(false);
		btnBlockCard.setBackground(new Color(112, 128, 144));
		btnBlockCard.setBounds(769, 541, 247, 96);
		contentPane.add(btnBlockCard);

		JLabel lblNewLabel_2 = new JLabel("Your Bank is:");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBounds(47, 234, 217, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel(user.getBankName());
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(69, 275, 256, 34);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Your Branch is:");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2_2.setBounds(47, 339, 217, 36);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_1 = new JLabel(user.getBranchName());
		lblNewLabel_2_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2_1_1.setBounds(69, 380, 195, 36);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_3 = new JLabel("Account Type:");
		lblNewLabel_2_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_3.setForeground(Color.BLUE);
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2_3.setBounds(47, 458, 217, 36);
		contentPane.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_1_2 = new JLabel(user.getAccType());
		lblNewLabel_2_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2_1_2.setBounds(69, 499, 195, 41);
		contentPane.add(lblNewLabel_2_1_2);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_atm frame = new Menu_atm("ATM project", args[0]);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
