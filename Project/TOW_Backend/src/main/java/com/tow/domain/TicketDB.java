package com.tow.domain;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ticket")
public class TicketDB {
	@Id
	private Long ticket_num;
	private String category;
	private String title;
	private Date register_date;
	private Timestamp pre_sale_date;
	private Timestamp open_sale_date;
	private String image_url;
	private String basic_info;
	private String introduction;
	private String agency_info;
}
