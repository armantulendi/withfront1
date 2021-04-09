package com.example.withfront.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Data
@Table(name = "dr_gateways")
public class DrGateway {
    @Id
    @Column(name = "gwid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gwId;

    @NotNull
    private int type;

    @NotEmpty(message = "адрес пустое")
    @Column(name = "address")
    private String gwAddress;

    @NotNull
    int strip;

    @Column(name = "pri_prefix")
    @NotEmpty(message = "пустое поле")
    private String priPrefix;

    @NotEmpty(message = "пустое поле")
    private String attrs;

    private String description;
  }
