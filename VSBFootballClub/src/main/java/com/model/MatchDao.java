package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchDao {

		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		public MatchDao() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsbdb", "root", "root");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		}
	//	static int i=0;
		public void storeData(Match m) {
			String sql="insert into matchdetails(title, place, mdate) values (?,?,?)";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1, m.getTitle());
				pst.setString(2, m.getPlace());
				pst.setString(3, m.getDt());
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public void storeData(User u) {
			String sql="insert into registerationdetails(name, age, gender, address) values (?,?,?,?,?)";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1, u.getName());
				pst.setInt(2, u.getAge());
				pst.setString(3, u.getGender());
				pst.setString(1, u.getAddress());
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
			public ResultSet retriveMatch() {
			String sql = "select * from matchdetails";
			try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
			}
}









