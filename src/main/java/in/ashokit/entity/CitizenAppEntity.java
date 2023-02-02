package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
@Table(name="CITIZEN_APPS")
public class CitizenAppEntity {

	@Id
	@GeneratedValue
	private Integer appId;
	public String fname;
	public String email;
	private Long mobileNum;
	private String gender;
	private LocalDate dob;
	private Long ssn;
	
	@CreatedDate
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	private Integer createdBy;
	private Integer updatedBy;
}
