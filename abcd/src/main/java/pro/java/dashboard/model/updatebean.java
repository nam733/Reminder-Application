package pro.java.dashboard.model;
import java.io.Serializable;
public class updatebean implements Serializable  {
	
		private static final long serialVersionUID = 1L;
		private String name;
		private String phone;
		private String email;
		private String password;
		private String passwordd;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPasswordd() {
			return passwordd;
		}
		public void setPasswordd(String passwordd) {
			this.passwordd = passwordd;
		}
		
		
		
	}


