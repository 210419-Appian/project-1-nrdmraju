package models;

public class AccountStatus {
	  private int statusId; // primary key
	  private String status; // not null, unique
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AccountStatus [statusId=" + statusId + ", status=" + status + ", getStatusId()=" + getStatusId()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public AccountStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	public AccountStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  
	}