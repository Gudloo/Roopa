package net.javaguides.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
	
@Entity
@Table(name = "student_details")
public class StudentDetails {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "stud_Name")
		@NotBlank(message="stud_Name must not be blank")
		@NotNull(message="stud_Name must not be null")
		private String stud_Name;

		@Column(name = "user_Id")
		@NotBlank(message="user_Id must not be blank")
		@NotNull(message="user_Id must not be null")
		private String user_Id;
		
		@Column(name = "center_Name")
		@NotBlank(message="center_Name must not be blank")
		@NotNull(message="center_Name must not be null")
		private String center_Name;
		
		@Column(name = "batch_Name")
		@NotBlank(message="batch_Name must not be blank")
		@NotNull(message="batch_Name must not be null")
		private String batch_Name;
		
		@Column(name = "start_date")
		
		@NotNull(message="start_date must not be null")
		private  Date start_date;
		
		@Column(name = "end_date")
		
		@NotNull(message="end_date must not be null")
		private Date end_date;
		
		@Column(name = "grade")
		@NotBlank(message="grade must not be blank")
		@NotNull(message="grade must not be null")
		private String grade;
		
		@Column(name = "assesment_status")
		@NotBlank(message="assesment_status must not be blank")
		@NotNull(message="assesment_status must not be null")
		private String assesment_status;

		public StudentDetails() {
			super();
		}

		public StudentDetails(long id, String stud_Name, String user_Id, String center_Name, String batch_Name,
				Date start_date, Date end_date, String grade, String assesment_status) {
			super();
			this.id = id;
			this.stud_Name = stud_Name;
			this.user_Id = user_Id;
			this.center_Name = center_Name;
			this.batch_Name = batch_Name;
			this.start_date = start_date;
			this.end_date = end_date;
			this.grade = grade;
			this.assesment_status = assesment_status;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getStud_Name() {
			return stud_Name;
		}

		public void setStud_Name(String stud_Name) {
			this.stud_Name = stud_Name;
		}

		public String getUser_Id() {
			return user_Id;
		}

		public void setUser_Id(String user_Id) {
			this.user_Id = user_Id;
		}

		public String getCenter_Name() {
			return center_Name;
		}

		public void setCenter_Name(String center_Name) {
			this.center_Name = center_Name;
		}

		public String getBatch_Name() {
			return batch_Name;
		}

		public void setBatch_Name(String batch_Name) {
			this.batch_Name = batch_Name;
		}

		public Date getStart_date() {
			return start_date;
		}

		public void setStart_date(Date start_date) {
			this.start_date = start_date;
		}

		public Date getEnd_date() {
			return end_date;
		}

		public void setEnd_date(Date end_date) {
			this.end_date = end_date;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getAssesment_status() {
			return assesment_status;
		}

		public void setAssesment_status(String assesment_status) {
			this.assesment_status = assesment_status;
		}

		@Override
		public String toString() {
			return "StudentDetails [id=" + id + ", stud_Name=" + stud_Name + ", user_Id=" + user_Id + ", center_Name="
					+ center_Name + ", batch_Name=" + batch_Name + ", start_date=" + start_date + ", end_date="
					+ end_date + ", grade=" + grade + ", assesment_status=" + assesment_status + "]";
		}

		
}
