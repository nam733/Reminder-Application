package pro.java.dashboard.model;

public class editbean {
	
		
		private int id;
		private String name;
		
		
		public editbean() {
			
		}
		
		public editbean(int id, String name) {
			super();
			this.id = id;
			this.name = name;
			//System.out.print(name);
			//System.out.print(id);
			//System.out.print(password);
			//System.out.print(psw);
				
		}
		public editbean(String name) {
			super();
			this.name = name;
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

		
		
	}


