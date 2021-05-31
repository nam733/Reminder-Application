package pro.java.dashboard.model;

public class mainpagebean {
	
		
		private int id;
		private String name;
		private String phone;
		private String email;
		private String password;
		private String psw;
		
		public mainpagebean() {
			
		}
		
		public mainpagebean(int id, String name, String phone, String email, String password, String psw) {
			super();
			this.id = id;
			this.name = name;
			this.phone = phone;
			this.email = email;
			this.password = password;
			this.psw=psw;
			//System.out.print(name);
			//System.out.print(phone);
			//System.out.print(password);
			//System.out.print(psw);
				
		}
		public mainpagebean(String name, String phone, String email, String password, String psw) {
			super();
			this.name = name;
			this.phone = phone;
			this.email = email;
			this.password = password;
			this.psw=psw;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

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

		public String getPsw() {
			return psw;
		}

		public void setPsw(String psw) {
			this.psw = psw;
		}
		
		
	}


