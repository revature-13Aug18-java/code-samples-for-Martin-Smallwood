package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Spring Bean used to configure the Location table.
 * @author Small
 *
 */
@Entity
@Table
public class Location implements Serializable{

	private static final long serialVersionUID = -6552757659886787454L;
	
	/**
	 * Primary key referring to a City/State.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="locationSequence")
	@SequenceGenerator(name="locationSequence",allocationSize=1,sequenceName="SQ_LOCATION_PK")
	@Column(name="LOCATION_ID")
	private int id;
	/**
	 * Name of a particular City
	 */
	@Column(name="CITY")
	private String city;
	/**
	 * Name of a particular State
	 */
	@Column(name="STATE")
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city)) {
			return false;}
		if (id != other.id)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state)) {
			return false;}
		return true;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", state=" + state + "]";
	}
	public Location(int id, String city, String state) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
	}
	public Location() {
		super();
	}
	
}
