package himedia.myhome.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import himedia.myhome.vo.UserVo;

public class UserDaoOracleImpl implements UserDao{
	private String dbuser;
	private String dbpass;
	
	public UserDaoOracleImpl(String dbuser, String dbpass) {
		this.dbuser = dbuser;
		this.dbpass = dbpass;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	@Override
	public List<UserVo> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<UserVo> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM users ORDER BY created_at DESC";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Long no = rs.getLong("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				Date createdAt = rs.getDate("created_at");
				
				UserVo vo = new UserVo(no, name, password, email, gender, createdAt);
				
				list.add(vo);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return list;
		}
			
	@Override
	public boolean insert(UserVo userVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			// Connection
			conn = getConnection();
			// SQL Query 전송
			String sql = "INSERT INTO users (no, name, password, email, gender) VALUES (seq_users_pk.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// Data 바인딩
			pstmt.setString(1, userVo.getName());
			pstmt.setString(2, userVo.getPassword());
			pstmt.setString(3, userVo.getEmail());
			pstmt.setString(4, userVo.getGender());
			
			// 확정된 Query 수행
			insertedCount = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) pstmt.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
		return 1 == insertedCount;
	}

	@Override
	public UserVo getUserByIdAndPassword(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo userVo = null;
		try {
			conn = getConnection();
			String sql = "SELECT no, name, email, gender FROM users " +
					"WHERE email=? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String gender = rs.getString(4);
				userVo = new UserVo(no, 
						name, 
						null, 
						email, 
						gender, 
						null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return userVo;
	}

	@Override
	public boolean update(UserVo userVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedCount = 0;
		try {
			conn = getConnection();
			String sql = "UPDATE users SET name=?, password=?, email=?, gender=? " +
					"WHERE no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVo.getName());
			pstmt.setString(2, userVo.getPassword());
			pstmt.setString(3, userVo.getEmail());
			pstmt.setString(4, userVo.getGender());
			pstmt.setLong(5, userVo.getNo());
			
			updatedCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.err.println("ERROR:" + e.getMessage());
			}
		}
		return 1 == updatedCount;
	}

	@Override
	public boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		try {
			conn = getConnection();
			String sql = "DELETE FROM users WHERE no=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			
			deletedCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.err.println("ERROR:" + e.getMessage());
			}
		}
		return 1 == deletedCount;
	}

}
