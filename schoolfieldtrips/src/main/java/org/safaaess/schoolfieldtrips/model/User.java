package org.safaaess.schoolfieldtrips.model;

import java.util.ArrayList;
import java.util.List;

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
/* User entity 
 * one user can have multiple approvals associated with them.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
/*    private String phoneNumber;
    private String address;*/
    private String username;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Approval> approval = new ArrayList<>();
}
