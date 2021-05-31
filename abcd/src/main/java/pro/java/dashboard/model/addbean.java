package pro.java.dashboard.model;
import java.io.Serializable;
public class addbean implements Serializable  {
	
		private static final long serialVersionUID = 1L;
		private int user_id;
		private int id;
		private String name;
		private String startdate;
		private String enddate;
		private String reminderdate;
		private String status;
		private String tag;
		private String description;
		
          public addbean() {
			
		}
		
		public addbean(int user_id,int id, String name, String startdate,String enddate,String reminderdate,String status,String tag,String description) {
			super();
			this.user_id=user_id;
			this.id=id;
			this.name=name;
			this.startdate=startdate;
			this.enddate=enddate;
			this.reminderdate=reminderdate;
			this.status=status;
			this.tag=tag;
			this.description=description;
				
		}
		public addbean(int id, String name, String startdate,String enddate,String reminderdate,String status,String tag,String description) {
			super();
			
			this.id=id;
			this.name=name;
			this.startdate=startdate;
			this.enddate=enddate;
			this.reminderdate=reminderdate;
			this.status=status;
			this.tag=tag;
			this.description=description;
				
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
		public String getStartdate() {
			return startdate;
		}
		public void setStartdate(String startdate) {
			this.startdate = startdate;
		}
		public String getEnddate() {
			return enddate;
		}
		public void setEnddate(String enddate) {
			this.enddate = enddate;
		}
		public String getReminderdate() {
			return reminderdate;
		}
		public void setReminderdate(String reminderdate) {
			this.reminderdate = reminderdate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		
		
		
	}


