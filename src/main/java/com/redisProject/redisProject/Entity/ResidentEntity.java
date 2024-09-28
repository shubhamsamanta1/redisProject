package com.redisProject.redisProject.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resident_details")
public class ResidentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long residentID;

    String ownerFullName;

    Long contactNo;

    String emailID;

    LocalDate dateOfBirth;

    String flatWing;

    String flatFloor;

    String flatNo;

    String ownershipStatus;

    LocalDate moveInDate;

    String govID;

    Long noOf2wheelersOwned;

    Long noOf3wheelersOwned;

    Long noOfResidentsInFlat;

    String emergencyContactName;

    Long emergencyContactNumber;

    @UpdateTimestamp
    Timestamp tmstamp;
}
