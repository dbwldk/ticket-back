package com.tow.domain;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tickets")
public class MainPostTicketDB {
	@Id
	private Integer id;
	private String event_name;
	private Timestamp ticket_open_date;
	private String image_url;
	private String genre;
	private String sales_site;
}