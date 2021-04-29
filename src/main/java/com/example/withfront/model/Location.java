package com.example.withfront.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Data
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    private int id;
    private String username;
    @Column(name = "server_id")
    private Integer serverId;

}
