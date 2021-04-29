package com.example.withfront.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Setter
@Getter
@Table(name = "acc_cdrs")
public class Calls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="start_time")
    private Date  startTime;
    @Column(name ="end_time")
    private Date endTime;
    @Column(name ="duration")
    private float duration;
    @Column(name ="c1")
    private String caller1;
    @Column(name ="c2")
    private String caller2;

}