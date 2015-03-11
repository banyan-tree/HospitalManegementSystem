package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DatabaseConnector;
import model.dto.TempUserDataDTO;
import model.dto.UserDTO;

public class UserDAO {
	DatabaseConnector dc;

	private int noOfRecordsForUserSearchListByNameAndUserTypeId = 0;

	public UserDAO() {
		dc = new DatabaseConnector();
	}

	public String getNewUserId() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String resultId = null;

		ResultSet rs2 = null;
		PreparedStatement pstm2 = null;
		int cntRows = 0;
		String sql = null;

		String tempMaxId1 = null;

		try {
			sql = "select count(*) from user_table;";
			con = dc.getDatabaseConnetion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			if (rs.next()) {
				cntRows = rs.getInt(1);
			}

			if (cntRows == 0) {
				resultId = "UR001";
			} else {
				sql = "select max(user_id) from user_table;";

				pstm2 = con.prepareStatement(sql);

				rs2 = pstm2.executeQuery();

				if (rs2.next()) {
					tempMaxId1 = rs2.getString(1);
				}

				resultId = incrementMaxId(tempMaxId1);

				rs2.close();
				pstm2.close();

			}
			rs.close();
			pstm.close();

			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in getNewUserId() method : " + ex);
		} catch (Exception ex) {
			System.out.println("Exception in getNewUserId() method : " + ex);
			ex.printStackTrace();
		}

		return resultId;
	}

	public String incrementMaxId(String maxId) {
		int maxIdLength = 3;
		int numberId = Integer.parseInt(maxId.substring(2));
		int incrementedId = numberId + 1;

		String numberIdString = String.valueOf(incrementedId);
		int cntLength = numberIdString.length();

		StringBuffer tempIdNumber = new StringBuffer();
		tempIdNumber.append("UR");

		for (int i = 0; i < maxIdLength - cntLength; i++) {
			tempIdNumber.append("0");
		}
		tempIdNumber.append(incrementedId);
		return tempIdNumber.toString();
	}

	public boolean insertNewUser(UserDTO uDTO) {
		Connection con = null;
		PreparedStatement pstm = null;

		String sql = null;

		boolean check = false;
		int count = 0;
		try {
			con = dc.getDatabaseConnetion();
			sql = "insert into user_table values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, uDTO.getUserId());
			pstm.setString(2, uDTO.getUserName());
			pstm.setString(3, uDTO.getUserPassword());
			pstm.setString(4, uDTO.getUserTypeId());
			pstm.setString(5, uDTO.getPersonId());
			pstm.setString(6, uDTO.getPersonName());
			pstm.setInt(7, uDTO.getActiveStatus());
			pstm.setString(8, uDTO.getCreationDateTime());
			pstm.setString(9, uDTO.getCreatedByPersonId());
			pstm.setString(10, uDTO.getCreatedByPersonName());
			pstm.setString(11, uDTO.getModificationDateTime());
			pstm.setString(12, uDTO.getModifiedByPersonId());
			pstm.setString(13, uDTO.getModifiedByPersonName());
			pstm.setString(14, uDTO.getDeactivationDateTime());
			pstm.setString(15, uDTO.getDeactivatedByPersonId());
			pstm.setString(16, uDTO.getDeactivationByPersonName());

			count = pstm.executeUpdate();

			if (count > 0) {
				check = true;
			}
			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out.println("SQL Exception in insertNewUser() " + ex);
		} catch (Exception ex) {
			System.out.println("Exception in insertNewUser() " + ex);
		}
		return check;
	}

	public boolean checkUserExists(UserDTO uDTO) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = null;
		boolean check = false;
		try {
			sql = "select user_id,user_name,user_password from user_table where user_name=? and user_password=?;";
			con = dc.getDatabaseConnetion();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, uDTO.getUserName());
			pstm.setString(2, uDTO.getUserPassword());

			rs = pstm.executeQuery();

			if (rs.next()) {
				check = true;
			}

			rs.close();
			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out.println("SQL Exception in checkdsadas user exists() method : "
					+ ex);
		} catch (Exception ex) {
			System.out.println("Exception in check user exists() method : "
					+ ex);
		}

		return check;
	}

	public boolean checkUserNameExists(String name) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = null;
		boolean check = false;
		try {
			sql = "select user_id,user_name,user_password from user_table where user_name=?;";
			con = dc.getDatabaseConnetion();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);

			rs = pstm.executeQuery();

			if (rs.next()) {
				check = true;
			}

			rs.close();
			pstm.close();

			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in check user name exists() method : "
							+ ex);
		} catch (Exception ex) {
			System.out
					.println("Exception in check user name exists() method : "
							+ ex);
		}

		return check;
	}

	public boolean checkAdminExists(UserDTO uDTO) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String userType = "admin";
		String sql = null;
		boolean check = false;
		try {
			sql = "select user_id,user_name,user_password from user_table where user_name=? and user_password=? and user_type=?;";
			con = dc.getDatabaseConnetion();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, uDTO.getUserName());
			pstm.setString(2, uDTO.getUserPassword());
			pstm.setString(3, userType);

			rs = pstm.executeQuery();

			if (rs.next()) {
				check = true;
			}

			rs.close();
			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in check admin exists() method : "
							+ ex);
		} catch (Exception ex) {
			System.out.println("Exception in check admin exists() method : "
					+ ex);
		}

		return check;
	}

	public boolean checkCurrentPasswordMatchByUserId(UserDTO uDTO) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = null;
		boolean check = false;
		try {
			sql = "select user_id,user_name,user_password from user_table where user_id=? and user_password=?;";
			con = dc.getDatabaseConnetion();
			pstm = con.prepareStatement(sql);

			pstm.setString(1, uDTO.getUserId());
			pstm.setString(2, uDTO.getUserPassword());

			rs = pstm.executeQuery();

			if (rs.next()) {
				check = true;
			}

			rs.close();
			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in checkCurrentPasswordMatchByUserId() method : "
							+ ex);
		} catch (Exception ex) {
			System.out
					.println("Exception in checkCurrentPasswordMatchByUserId() method : "
							+ ex);
		}

		return check;
	}

	public boolean updateUserPasswordByUserId(UserDTO uDTO) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = null;

		int countRows = 0;
		boolean checkUpdate = false;

		try {
			sql = "update user_table set user_password=? where user_id=?;";
			con = dc.getDatabaseConnetion();
			pstm = con.prepareStatement(sql);

			pstm.setString(1, uDTO.getUserPassword());
			pstm.setString(2, uDTO.getUserId());

			countRows = pstm.executeUpdate();

			if (countRows > 0) {
				checkUpdate = true;
			}

			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in updateUserPasswordByUserId() method : "
							+ ex);
		} catch (Exception ex) {
			System.out
					.println("Exception in updateUserPasswordByUserId() method : "
							+ ex);
		}

		return checkUpdate;
	}

	public boolean updateUserActiveStatusByUserId(UserDTO uDTO) {
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = null;

		int countRows = 0;
		boolean checkUpdate = false;

		try {
			sql = "update user_table set active_status=? where user_id=?;";
			con = dc.getDatabaseConnetion();
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, uDTO.getActiveStatus());
			pstm.setString(2, uDTO.getUserId());

			countRows = pstm.executeUpdate();

			if (countRows > 0) {
				checkUpdate = true;
			}

			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in updateUserPasswordByUserId() method : "
							+ ex);
		} catch (Exception ex) {
			System.out
					.println("Exception in updateUserPasswordByUserId() method : "
							+ ex);
		}

		return checkUpdate;
	}

	public UserDTO getUserDetailsByName(String username) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		UserDTO uDTOData = new UserDTO();
		String sql = null;

		try {
			con = dc.getDatabaseConnetion();

			sql = "select UR.user_id,UR.user_name,UR.user_password,UR.user_type_id,UT.name user_type_name,UR.person_id,UR.person_name,UR.active_status,UR.creation_date_time,UR.created_by_person_id,"
					+ "UR.created_by_person_name,UR.modification_date_time,UR.modified_by_person_id,UR.modified_by_person_name,"
					+ "UR.deactivation_date_time,UR.deactivated_by_person_id,UR.deactivated_by_person_name "
					+ "from user_table UR,user_type_master_table UT where UR.user_name=? and UR.user_type_id=UT.user_type_id";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, username);

			rs = pstm.executeQuery();

			if (rs.next()) {
				uDTOData.setUserId(rs.getString("user_id"));
				uDTOData.setUserName(rs.getString("user_name"));
				uDTOData.setUserPassword(rs.getString("user_password"));
				uDTOData.setUserTypeId(rs.getString("user_type_id"));
				uDTOData.setUserTypeName(rs.getString("user_type_name"));
				uDTOData.setPersonId(rs.getString("person_id"));
				uDTOData.setPersonName(rs.getString("person_name"));
				uDTOData
						.setCreationDateTime(rs.getString("creation_date_time"));
				uDTOData.setCreatedByPersonId(rs
						.getString("created_by_person_id"));
				uDTOData.setCreatedByPersonName(rs
						.getString("created_by_person_name"));
				uDTOData.setModificationDateTime(rs
						.getString("modification_date_time"));
				uDTOData.setModifiedByPersonId(rs
						.getString("modified_by_person_id"));
				uDTOData.setModifiedByPersonName(rs
						.getString("modified_by_person_name"));
				uDTOData.setDeactivationDateTime(rs
						.getString("deactivation_date_time"));
				uDTOData.setDeactivatedByPersonId(rs
						.getString("deactivated_by_person_id"));
				uDTOData.setDeactivationByPersonName(rs
						.getString("deactivated_by_person_name"));
				uDTOData.setActiveStatus(rs.getInt("active_status"));
			}

			rs.close();
			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in  getUserDetailsByNamePassword() "
							+ ex);
		} catch (Exception ex) {
			System.out.println("Exception in getUserDetailsByNamePassword() "
					+ ex);
		}

		return uDTOData;
	}

	public UserDTO getUserDetailsByUserId(String userId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		UserDTO uDTOData = new UserDTO();
		String sql = null;

		try {
			con = dc.getDatabaseConnetion();

			sql = "select user_id,user_name,user_password,user_type_id,person_id,person_name,active_status,creation_date_time,created_by_person_id,"
					+ "created_by_person_name,modification_date_time,modified_by_person_id,modified_by_person_name,"
					+ "deactivation_date_time,deactivated_by_person_id,deactivated_by_person_name "
					+ "from user_table where user_id=?;";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, userId);

			rs = pstm.executeQuery();

			if (rs.next()) {
				uDTOData.setUserId(rs.getString("user_id"));
				uDTOData.setUserName(rs.getString("user_name"));
				uDTOData.setUserPassword(rs.getString("user_password"));
				uDTOData.setUserTypeId(rs.getString("user_type_id"));
				uDTOData.setPersonId(rs.getString("person_id"));
				uDTOData.setPersonName(rs.getString("person_name"));
				uDTOData
						.setCreationDateTime(rs.getString("creation_date_time"));
				uDTOData.setCreatedByPersonId(rs
						.getString("created_by_person_id"));
				uDTOData.setCreatedByPersonName(rs
						.getString("created_by_person_name"));
				uDTOData.setModificationDateTime(rs
						.getString("modification_date_time"));
				uDTOData.setModifiedByPersonId(rs
						.getString("modified_by_person_id"));
				uDTOData.setModifiedByPersonName(rs
						.getString("modified_by_person_name"));
				uDTOData.setDeactivationDateTime(rs
						.getString("deactivation_date_time"));
				uDTOData.setDeactivatedByPersonId(rs
						.getString("deactivated_by_person_id"));
				uDTOData.setDeactivationByPersonName(rs
						.getString("deactivated_by_person_name"));
				uDTOData.setActiveStatus(rs.getInt("active_status"));
			}

			rs.close();
			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out.println("SQL Exception in getUserDetailsByUserId() "
					+ ex);
		} catch (Exception ex) {
			System.out.println("Exception in  getUserDetailsByUserId()  " + ex);
		}

		return uDTOData;
	}

	/*
	 * public boolean updateUserData(UserDTO uDTO) { Connection con = null;
	 * PreparedStatement pstm = null;
	 * 
	 * String sql = null; boolean check = false;
	 * 
	 * int cnt = 0; try { sql =
	 * "update user_table set user_name=? where user_id=?;"; con =
	 * dc.getDatabaseConnetion(); pstm = con.prepareStatement(sql);
	 * pstm.setString(1, uDTO.getUserName()); pstm.setString(2,
	 * uDTO.getUserMobile()); pstm.setString(3, uDTO.getUserAlternateMobile());
	 * pstm.setString(4, uDTO.getUserId());
	 * 
	 * cnt = pstm.executeUpdate();
	 * 
	 * if (cnt > 0) { check = true; }
	 * 
	 * pstm.close();
	 * 
	 * dc.closeDatabaseConnection(); } catch (SQLException ex) {
	 * System.out.println("SQL Exception in update user data() method : " + ex);
	 * } catch (Exception ex) { System.out
	 * .println("Exception in update user data() method : " + ex); }
	 * 
	 * return check; }
	 */
	public ArrayList<UserDTO> getUserList() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		UserDTO uDTOData;
		try {
			con = dc.getDatabaseConnetion();

			sql = "select user_id,user_name,user_password,user_type_id,person_id,creation_date_time,"
					+ "active_status,created_by_person_id from user_table;";

			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				uDTOData = new UserDTO();
				uDTOData.setUserId(rs.getString("user_id"));
				uDTOData.setUserName(rs.getString("user_name"));
				uDTOData.setUserPassword(rs.getString("user_password"));
				uDTOData.setUserTypeId(rs.getString("user_type_id"));
				uDTOData.setPersonId(rs.getString("person_id"));
				userList.add(uDTOData);
			}

			rs.close();
			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in  get user list method : " + ex);
		} catch (Exception ex) {
			System.out.println("Exception in get user list method : " + ex);
		}

		return userList;
	}

	public ArrayList<UserDTO> getUserListToSearchExpense() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		UserDTO uDTOData;
		try {
			con = dc.getDatabaseConnetion();

			sql = "select A.user_id,A.user_type_id,A.person_id,A.person_name,B.name as user_type_name "
					+ "from user_table A,user_type_master_table B  "
					+ "where A.user_type_id=B.user_type_id and A.user_type_id not like 'UT02';";

			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				uDTOData = new UserDTO();
				uDTOData.setUserId(rs.getString("user_id"));
				uDTOData.setUserTypeId(rs.getString("user_type_id"));
				uDTOData.setPersonId(rs.getString("person_id"));
				uDTOData.setPersonName(rs.getString("person_name"));
				uDTOData.setUserTypeName(rs.getString("user_type_name")
						.toUpperCase());
				userList.add(uDTOData);
			}

			rs.close();
			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in  getUserListToSearchExpense() "
							+ ex);
		} catch (Exception ex) {
			System.out.println("Exception in getUserListToSearchExpense() "
					+ ex);
		}

		return userList;
	}

	public ArrayList<UserDTO> getUserSearchListByNameAndUserTypeId(
			UserDTO uDTO, int offset, int noOfRecords) {

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		UserDTO uDTOData;
		try {
			con = dc.getDatabaseConnetion();

			if (uDTO.getUserTypeId().equals("0")) {
				uDTO.setUserTypeId("");
			}

			sql = "select SQL_CALC_FOUND_ROWS A.user_id,A.user_name,A.user_password,B.name as user_type_name,A.person_name,A.user_type_id,A.person_id,"
					+ "A.creation_date_time,A.active_status,A.created_by_person_id "
					+ "from user_table A,user_type_master_table B "
					+ "where A.user_name like ? and A.user_type_id like ? and A.user_type_id = B.user_type_id order by A.user_name limit ?,?;";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, "%" + uDTO.getUserName() + "%");
			pstm.setString(2, "%" + uDTO.getUserTypeId() + "%");
			pstm.setInt(3, offset);
			pstm.setInt(4, noOfRecords);
			
			System.out.println(uDTO.getUserName() );
			System.out.println(uDTO.getUserTypeId() );

			rs = pstm.executeQuery();

			while (rs.next()) {
				uDTOData = new UserDTO();
				uDTOData.setUserId(rs.getString("user_id"));
				uDTOData.setUserName(rs.getString("user_name"));
				uDTOData.setUserPassword(rs.getString("user_password"));
				uDTOData.setUserTypeId(rs.getString("user_type_id"));
				uDTOData.setUserTypeName(rs.getString("user_type_name")
						.toUpperCase());

				uDTOData.setPersonId(rs.getString("person_id"));
				uDTOData.setPersonName(rs.getString("person_name"));
				uDTOData.setActiveStatus(rs.getInt("active_status"));
				uDTOData
						.setCreationDateTime(rs.getString("creation_date_time"));
				uDTOData.setCreatedByPersonId(rs
						.getString("created_by_person_id"));

				userList.add(uDTOData);
			}

			rs.close();

			rs = pstm.executeQuery("SELECT FOUND_ROWS()");

			if (rs.next()) {
				this.noOfRecordsForUserSearchListByNameAndUserTypeId = rs
						.getInt(1);
			}

			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in  get user list method : " + ex);
		} catch (Exception ex) {
			System.out.println("Exception in get user list method : " + ex);
		}

		return userList;
	}

	public int getNoOfRecordsForUserSearchListByNameAndUserTypeId() {
		return this.noOfRecordsForUserSearchListByNameAndUserTypeId;
	}

	public int getUserSearchListCountByNameAndUserTypeId(UserDTO uDTO) {

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = null;

		int countRows = 0;
		try {
			con = dc.getDatabaseConnetion();

			if (uDTO.getUserTypeId().equals("0")) {
				uDTO.setUserTypeId("");
			}

			sql = "select count(*) from user_table A,user_type_master_table B "
					+ "where A.user_name like ? and A.user_type_id like ? and A.user_type_id = B.user_type_id order by A.user_name;";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, "%" + uDTO.getUserName() + "%");
			pstm.setString(2, "%" + uDTO.getUserTypeId() + "%");

			rs = pstm.executeQuery();

			while (rs.next()) {
				countRows = rs.getInt(1);
			}

			rs.close();
			pstm.close();
			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in  get user list count method : "
							+ ex);
		} catch (Exception ex) {
			System.out.println("Exception in get user list count method : "
					+ ex);
		}

		return countRows;
	}

	public ArrayList<TempUserDataDTO> getUserNameListByUserTypeId(
			String userTypeId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "";

		ArrayList<TempUserDataDTO> userList = new ArrayList<TempUserDataDTO>();

		TempUserDataDTO uDTOData;
		try {
			con = dc.getDatabaseConnetion();

			if (userTypeId.equals("UT02")) {
				sql = "select doc.doctor_id as id,doc.name as name from doctor_info_table doc where doc.doctor_id not in ( select person_id from user_table);";
				pstm = con.prepareStatement(sql);
				rs = pstm.executeQuery();

				while (rs.next()) {
					uDTOData = new TempUserDataDTO();
					uDTOData.setId(rs.getString("id"));
					uDTOData.setName(rs.getString("name"));
					userList.add(uDTOData);
				}
				rs.close();
				pstm.close();

			} else {
				sql = "select stf.staff_member_id as id,stf.name as name from staff_member_table stf where stf.staff_member_id not in ( select person_id from user_table);";
				pstm = con.prepareStatement(sql);
				rs = pstm.executeQuery();

				while (rs.next()) {
					uDTOData = new TempUserDataDTO();
					uDTOData.setId(rs.getString("id"));
					uDTOData.setName(rs.getString("name"));
					userList.add(uDTOData);
				}
				rs.close();
				pstm.close();

			}

			dc.closeDatabaseConnection();
		} catch (SQLException ex) {
			System.out
					.println("SQL Exception in  getUserNameListByUserTypeId () method : "
							+ ex);
		} catch (Exception ex) {
			System.out
					.println("Exception in getUserNameListByUserTypeId() method : "
							+ ex);
		}

		return userList;
	}

}
