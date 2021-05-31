package pro.java.dashboard.model;
import java.io.Serializable;
public class addnotebookbean implements Serializable  {
	
		private static final long serialVersionUID = 1L;
		private String notebookname;
		private int user_id;
		public String getNotebookname() {
			return notebookname;
		}
		public void setNotebookname(String notebookname) {
			this.notebookname = notebookname;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		
		
		
	}


