package com.pharmc.zuul.apigateway.model;

import java.sql.Date;



import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class SellerOrders {
	
    private long soid;
    
	private long sid;
	
	private long oid;
	
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getS_o_id() {
		return soid;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}
	
	
}
