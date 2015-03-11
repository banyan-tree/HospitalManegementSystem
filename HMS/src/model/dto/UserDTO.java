package model.dto;

public class UserDTO {

	private String userId = null;
	private String userName = null;
	private String userPassword = null;
	private String userTypeId = null;
	private String userTypeName = null;
	private String personId = null;
	private String personName = null;
	private String creationDateTime = null;
	private String createdByPersonId = null;
	private int activeStatus = 0;
	private String createdByPersonName = null;
	private String modificationDateTime = null;
	private String modifiedByPersonId = null;
	private String modifiedByPersonName = null;
	private String deactivationDateTime = null;
	private String deactivatedByPersonId = null;
	private String deactivationByPersonName = null;

	public UserDTO() {
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword
	 *            the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the userType
	 */
	public String getUserTypeId() {
		return userTypeId;
	}

	/**
	 * @param userTypeId
	 *            the userType to set
	 */
	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}

	/**
	 * @return the personId
	 */
	public String getPersonId() {
		return personId;
	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	/**
	 * @return the creationDateTime
	 */
	public String getCreationDateTime() {
		return creationDateTime;
	}

	/**
	 * @param creationDateTime
	 *            the creationDateTime to set
	 */
	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	/**
	 * @return the createdByPersonId
	 */
	public String getCreatedByPersonId() {
		return createdByPersonId;
	}

	/**
	 * @param createdByPersonId
	 *            the createdByPersonId to set
	 */
	public void setCreatedByPersonId(String createdByPersonId) {
		this.createdByPersonId = createdByPersonId;
	}

	/**
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus
	 *            the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the userTypeName
	 */
	public String getUserTypeName() {
		return userTypeName;
	}

	/**
	 * @param userTypeName
	 *            the userTypeName to set
	 */
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName
	 *            the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @return the createdByPersonName
	 */
	public String getCreatedByPersonName() {
		return createdByPersonName;
	}

	/**
	 * @param createdByPersonName
	 *            the createdByPersonName to set
	 */
	public void setCreatedByPersonName(String createdByPersonName) {
		this.createdByPersonName = createdByPersonName;
	}

	/**
	 * @return the modificationDateTime
	 */
	public String getModificationDateTime() {
		return modificationDateTime;
	}

	/**
	 * @param modificationDateTime
	 *            the modificationDateTime to set
	 */
	public void setModificationDateTime(String modificationDateTime) {
		this.modificationDateTime = modificationDateTime;
	}

	/**
	 * @return the modifiedByPersonId
	 */
	public String getModifiedByPersonId() {
		return modifiedByPersonId;
	}

	/**
	 * @param modifiedByPersonId
	 *            the modifiedByPersonId to set
	 */
	public void setModifiedByPersonId(String modifiedByPersonId) {
		this.modifiedByPersonId = modifiedByPersonId;
	}

	/**
	 * @return the modifiedByPersonName
	 */
	public String getModifiedByPersonName() {
		return modifiedByPersonName;
	}

	/**
	 * @param modifiedByPersonName
	 *            the modifiedByPersonName to set
	 */
	public void setModifiedByPersonName(String modifiedByPersonName) {
		this.modifiedByPersonName = modifiedByPersonName;
	}

	/**
	 * @return the deactivationDateTime
	 */
	public String getDeactivationDateTime() {
		return deactivationDateTime;
	}

	/**
	 * @param deactivationDateTime
	 *            the deactivationDateTime to set
	 */
	public void setDeactivationDateTime(String deactivationDateTime) {
		this.deactivationDateTime = deactivationDateTime;
	}

	/**
	 * @return the deactivatedByPersonId
	 */
	public String getDeactivatedByPersonId() {
		return deactivatedByPersonId;
	}

	/**
	 * @param deactivatedByPersonId
	 *            the deactivatedByPersonId to set
	 */
	public void setDeactivatedByPersonId(String deactivatedByPersonId) {
		this.deactivatedByPersonId = deactivatedByPersonId;
	}

	/**
	 * @return the deactivationByPersonName
	 */
	public String getDeactivationByPersonName() {
		return deactivationByPersonName;
	}

	/**
	 * @param deactivationByPersonName
	 *            the deactivationByPersonName to set
	 */
	public void setDeactivationByPersonName(String deactivationByPersonName) {
		this.deactivationByPersonName = deactivationByPersonName;
	}
}
