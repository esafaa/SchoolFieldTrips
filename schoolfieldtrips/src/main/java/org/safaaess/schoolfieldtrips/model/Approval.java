package org.safaaess.schoolfieldtrips.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Approval entity,  which is used to manage approvals
 *  related to Trips and Users
 *  many approvals can be associated with one user
 *  many approvals can be associated with one trip
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "approvals")
public class Approval {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean status;

	@ManyToOne
	User user;

	@ManyToOne
	Trip trip;
}
