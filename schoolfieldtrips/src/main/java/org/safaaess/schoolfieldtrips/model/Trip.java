package org.safaaess.schoolfieldtrips.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*  Trip entity containig trip details , attachments file, and approvals
 *  one trip can have multiple files associated with it.
 *  one trip can have multiple approvals associated with it.  
*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "trips")
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String destination;
	private String tripLeader;
	private String otherStaffAttending;
	private String purpose;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime departureTime;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime returnTime;
	private int numberOfStudents;
	private double price;

	@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
	private List<File> tripFiles = new ArrayList<>();

	@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
	List<Approval> approval;
}
