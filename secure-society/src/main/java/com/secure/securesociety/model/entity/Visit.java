package com.secure.securesociety.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "visit")
@Entity
public class Visit {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "enter_time")
    private Date enterTime;

    @Column(name = "exit_time")
    private Date exitTime;

    @Column(name = "visiting_reason")
    private String visitingReason;

    @Column(name = "visiting_flat")
    private String visitingFlat;

    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "visiters_count")
    private int visitersCount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            insertable =  false, updatable = false)
    private User user;

}
