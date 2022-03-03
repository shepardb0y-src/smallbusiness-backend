package com.fabiobenoit.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Client {
	@Entity
	@Table(name="classes")
	public class User {
		@Id
		@Column
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column
		private String username;
		public int getId() {
			return id;
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
}
}