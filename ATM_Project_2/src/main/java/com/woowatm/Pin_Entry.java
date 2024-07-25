package com.woowatm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Pin_Entry extends JFrame {

	/**
	 * Create the frame.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAtm;
	private JTextField textField;

	public Pin_Entry(String str) {
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
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckService cs = new CheckService();
				String pin = textField.getText();
				if (cs.pinStatus(pin)) {
					// JOptionPane.showConfirmDialog(null, "Successful!");
					String a[] = new String[] { pin };
					Menu_atm.main(a);
				} else {
					JOptionPane.showConfirmDialog(null, "invalid pin!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton.setBounds(392, 560, 225, 63);
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

		JLabel lblNewLabel_1 = new JLabel("Please Enter Your PIN!");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel_1.setBounds(253, 49, 514, 81);
		contentPane.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		panel.setBounds(514, 169, 534, 345);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnNewButton_1_2 = new JButton("1\r\n\r\n");
		btnNewButton_1_2.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnNewButton_1_2.setOpaque(true);
		btnNewButton_1_2.setForeground(Color.BLACK);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_2.setFocusPainted(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("2");
		btnNewButton_1_3.setOpaque(true);
		btnNewButton_1_3.setForeground(Color.BLACK);
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_3.setFocusPainted(false);
		btnNewButton_1_3.setBorderPainted(false);
		btnNewButton_1_3.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_3);

		JButton btnNewButton_1_4 = new JButton("3");
		btnNewButton_1_4.setOpaque(true);
		btnNewButton_1_4.setForeground(Color.BLACK);
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_4.setFocusPainted(false);
		btnNewButton_1_4.setBorderPainted(false);
		btnNewButton_1_4.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_4);

		JButton btnNewButton_1_5 = new JButton("4");
		btnNewButton_1_5.setOpaque(true);
		btnNewButton_1_5.setForeground(Color.BLACK);
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_5.setFocusPainted(false);
		btnNewButton_1_5.setBorderPainted(false);
		btnNewButton_1_5.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_5);

		JButton btnNewButton_1_1 = new JButton("5");
		btnNewButton_1_1.setOpaque(true);
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_1);

		JButton btnNewButton_1_7 = new JButton("6");
		btnNewButton_1_7.setOpaque(true);
		btnNewButton_1_7.setForeground(Color.BLACK);
		btnNewButton_1_7.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_7.setFocusPainted(false);
		btnNewButton_1_7.setBorderPainted(false);
		btnNewButton_1_7.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_7);

		JButton btnNewButton_1_6 = new JButton("7");
		btnNewButton_1_6.setOpaque(true);
		btnNewButton_1_6.setForeground(Color.BLACK);
		btnNewButton_1_6.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_6.setFocusPainted(false);
		btnNewButton_1_6.setBorderPainted(false);
		btnNewButton_1_6.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_6);

		JButton btnNewButton_1_8 = new JButton("8");
		btnNewButton_1_8.setOpaque(true);
		btnNewButton_1_8.setForeground(Color.BLACK);
		btnNewButton_1_8.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_8.setFocusPainted(false);
		btnNewButton_1_8.setBorderPainted(false);
		btnNewButton_1_8.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_8);

		JButton btnNewButton_1_9 = new JButton("9");
		btnNewButton_1_9.setOpaque(true);
		btnNewButton_1_9.setForeground(Color.BLACK);
		btnNewButton_1_9.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_9.setFocusPainted(false);
		btnNewButton_1_9.setBorderPainted(false);
		btnNewButton_1_9.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_9);

		JButton btnNewButton_1_10 = new JButton("  ");
		btnNewButton_1_10.setOpaque(true);
		btnNewButton_1_10.setForeground(Color.BLACK);
		btnNewButton_1_10.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_10.setFocusPainted(false);
		btnNewButton_1_10.setBorderPainted(false);
		btnNewButton_1_10.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_10);

		JButton btnNewButton_1_11 = new JButton("0");
		btnNewButton_1_11.setOpaque(true);
		btnNewButton_1_11.setForeground(Color.BLACK);
		btnNewButton_1_11.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_11.setFocusPainted(false);
		btnNewButton_1_11.setBorderPainted(false);
		btnNewButton_1_11.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_11);

		JButton btnNewButton_1_12 = new JButton("CE");
		btnNewButton_1_12.setOpaque(true);
		btnNewButton_1_12.setForeground(Color.BLACK);
		btnNewButton_1_12.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton_1_12.setFocusPainted(false);
		btnNewButton_1_12.setBorderPainted(false);
		btnNewButton_1_12.setBackground(new Color(204, 204, 204));
		panel.add(btnNewButton_1_12);

		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setBackground(new Color(204, 204, 204));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(61, 298, 345, 46);
		contentPane.add(textField);
		textField.setColumns(10);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(UIManager.getBorder("CheckBox.border"));
		layeredPane.setBounds(390, 559, 230, 68);
		contentPane.add(layeredPane);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pin_Entry frame = new Pin_Entry("ATM project");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
