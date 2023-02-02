package in.ashokit.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {
	public String fname;
	public String email;
	private Long mobileNum;
	private String gender;
	private LocalDate dob;
	private Long ssn;
	private Integer createdBy;
	private Integer updatedBy;
}
