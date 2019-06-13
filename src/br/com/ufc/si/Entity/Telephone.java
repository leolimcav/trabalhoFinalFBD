package br.com.ufc.si.Entity;

public class Telephone {
	
	private Long telId;
	private Long userId;
	private String telephone;
	
	public Telephone(Long userId, String telephone) {
		this.userId = userId;
		this.telephone = telephone;
	}
	
	public Telephone() {}

	public Long getTelId() {
		return telId;
	}

	public void setTelId(Long telId) {
		this.telId = telId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Telephone [telId=" + telId + ", userId=" + userId + ", telephone=" + telephone + "]" + "\n";
	}
	
}
