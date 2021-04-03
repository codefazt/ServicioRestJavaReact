package com.init.api.entitys;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;


public class ResponseTime {

	private Time time;
	
	private String timeZone;
	
	private String param1;
	
	private String param2;
	
	
	public void dateToUTCTimeStamp(){
	       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		 
	       LocalTime local = LocalTime.parse(this.param1, formatter);
	       
	       ZonedDateTime zonedFechaExpiracion = ZonedDateTime
	               .now(ZoneId.of(this.param2)) 
	               .with(local) 
	               .withZoneSameInstant(ZoneOffset.UTC); 
	 
	 
	       this.time = Time.valueOf(zonedFechaExpiracion.format(formatter));
	       this.timeZone = "utc";
	 
	}
	
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	
	public Time getTime() {
		return this.time;
	}
	
	public String getTimeZone() {
		return this.timeZone;
	}
	
	
	
	
}
