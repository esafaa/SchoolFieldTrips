package org.safaaess.schoolfieldtrips.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

/* File entity that stores file information associated with a specific Trip
 * many files can be associated with one trip  */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // Large Object that can store large amounts of data
    @Column(name = "file_data")
    private byte[] fileData;

    private String fileName;
    private String fileType;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;
}
