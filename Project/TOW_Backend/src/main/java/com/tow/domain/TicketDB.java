package com.tow.domain;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tickets")
public class TicketDB {
	@Id
	private Integer id;
	private String event_name;
	private Date registration_date;
	private Timestamp ticket_open_date;
	private Timestamp pre_sale_date;
	private String image_url;
	private String basic_info;
	private String event_description;
	private String agency_info;
	private String detail_link;
	private String genre;
	private String sales_site;
	private int view_count;
}