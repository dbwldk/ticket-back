package com.tow.domain;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private Timestamp pre_sale_date;
	private String image_url;
	private String genre;
	
	//join
	@OneToMany(mappedBy = "ticketDB")
	private List<EventSiteDB> eventSites;
}