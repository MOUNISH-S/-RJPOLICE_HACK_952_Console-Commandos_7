package com.bsys.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="user")
public class User {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int Id;
		
		private String email;
		private String pwd;
		private String role;
		private String name;
		
		public User(int id, String email, String pwd,String role,String name) {
			super();
			this.Id = id;
			this.email = email;
			this.pwd = pwd;
			this.role=role;
			this.name=name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public User() {}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
}
