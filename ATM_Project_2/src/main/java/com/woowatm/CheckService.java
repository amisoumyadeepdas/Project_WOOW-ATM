package com.woowatm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckService {

	public boolean pinStatus(String p) {
		boolean status = false;
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM PIN WHERE PINNO= ?");
			ps.setString(1, p);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return status;
	}

	public boolean validAccNo(String acc) {
		boolean status = false;
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ACCOUNT WHERE ACCNO= ?");
			ps.setString(1, acc);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return status;
	}

	public boolean setPin(String acc, String pin) {
		boolean status = false;
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO PIN VALUES (?,?)");
			ps.setString(1, pin);
			ps.setString(2, acc);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return status;
	}

	public boolean checkAccnoIfscCode(String accno, String IFSC) {
		boolean status = false;
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ACCOUNT WHERE ACCNO= ? AND IFSC_CODE= ?");
			ps.setString(1, accno);
			ps.setString(2, IFSC);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return status;
	}

	public accountHolder getDetails(String p) {
		String query = "SELECT * " + "FROM USER_INFO u " + "JOIN Account a ON u.accNo = a.accNo "
				+ "JOIN Pin p ON u.accNo = p.accNo " + "WHERE p.pinNo = ?";
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				String accType = rs.getString("accType");
				String name = rs.getString("Name");
				String bankName = rs.getString("bankName");
				String branchName = rs.getString("branchName");
				String pinNo = rs.getString("pinNo");
				String accNo = rs.getString("accNo");
				// Create an accountHolder object with the retrieved data
				accountHolder user = new accountHolder(pinNo, accType, bankName, branchName, name, accNo);
				return user;
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return null;
	}

	public void transactionManager(String accNo, String type, int amount) {

		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Transaction VALUES (?, ?, ?)");
			ps.setString(1, accNo);
			ps.setString(2, type);
			ps.setInt(3, amount);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
	}

	public boolean depositMoney(String accNo, int amount) {
		boolean status = false;
		String query = "UPDATE Account SET balance = balance + ? WHERE accNo=?";
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setString(2, accNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				transactionManager(accNo, "Deposite", amount);
				status = true;
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return status;
	}

	public boolean withdrawMoney(String accNo, int amount) {
		boolean status = false;
		String query = "UPDATE Account SET balance = balance - ? WHERE accNo=?";
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setString(2, accNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				transactionManager(accNo, "Withdraw", amount);
				status = true;
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return status;
	}

	public int balance(String accNo) {
		int bal = 0;
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement("SELECT BALANCE FROM ACCOUNT WHERE ACCNO= ?");
			ps.setString(1, accNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bal = rs.getInt("balance");
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return bal;
	}

	public boolean transferMoney(String ownerAccno, String transferAccno, String ifsc_code, int amount) {
		boolean status = false;
		String query = "UPDATE Account SET balance = balance + ? WHERE accNo=? and IFSC_CODE=?";
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setString(2, transferAccno);
			ps.setString(3, ifsc_code);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				transactionManager(transferAccno, "Credit", amount);
				PreparedStatement ps1 = con.prepareStatement("UPDATE Account SET balance = balance - ? WHERE accNo=?");
				ps1.setInt(1, amount);
				ps1.setString(2, ownerAccno);
				ResultSet rs1 = ps1.executeQuery();
				if (rs1.next()) {
					transactionManager(ownerAccno, "Transfer", amount);
					status = true;
				}
			}

		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return status;
	}

	public String transactionHistory(String accNo) {
		String str = "";
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM TRANSACTION WHERE ACCNO= ?");
			ps.setString(1, accNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				str += rs.getString("accno") + "                   " + rs.getString("trans_type")
						+ "                     " + rs.getString("amount") + "\n";
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}

		return str;
	}

	public boolean blockCard(String acc) {
		boolean status = false;
		try {
			Connection con = Config.makeCon();
			PreparedStatement ps = con.prepareStatement("DELETE FROM PIN WHERE ACCNO=?");
			ps.setString(1, acc);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
		} catch (SQLException e) {
			System.out.println("problem is " + e);
		}
		return status;
	}

}
