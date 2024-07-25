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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class MainPage extends JFrame {

	/**
	 * Create the frame.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAtm;

	public MainPage(String str) {
		setTitle(str);
		setBackground(new Color(204, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 707);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("WOOW");
		lblNewLabel.setForeground(new Color(255, 204, 153));
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 90));
		lblNewLabel.setBounds(220, 54, 403, 122);
		contentPane.add(lblNewLabel);

		lblAtm = new JLabel("ATM");
		lblAtm.setForeground(new Color(128, 0, 0));
		lblAtm.setFont(new Font("Arial", lblAtm.getFont().getStyle() | Font.BOLD | Font.ITALIC,
				lblAtm.getFont().getSize() + 105));
		lblAtm.setBounds(593, 34, 290, 154);
		contentPane.add(lblAtm);

		// Customize Enter PIN button to resemble CustomButton
		JButton btnNewButton = new JButton("Set PIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[] {};
				SetUpPin_1.main(a);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton.setBounds(82, 431, 225, 63);
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

		JLabel lblNewLabel_1 = new JLabel("Welcome! to WooW ATM.");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(392, 208, 629, 81);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Please Select  below OPtion.");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_1.setBounds(379, 239, 629, 81);
		contentPane.add(lblNewLabel_1_1);

		JButton btnNewButton_1 = new JButton("Enter PIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a[] = new String[0];
				Pin_Entry.main(a);
			}
		});
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(112, 128, 144));
		btnNewButton_1.setBounds(743, 431, 225, 63);
		// Add mouse listener for hover and press effects

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(hoverBackgroundColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(112, 128, 144));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_1.setBackground(pressedBackgroundColor);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(112, 128, 144));
			}
		});

		contentPane.add(btnNewButton_1);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage("ATM project");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
