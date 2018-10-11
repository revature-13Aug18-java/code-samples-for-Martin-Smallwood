package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
/**
 * Spring Bean used to configure the Friend table.
 * @author Small
 *
 */
public class Friend {
	
	/**
	 * Primary key referring to a specific pairing of people.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="friendSequence")
	@SequenceGenerator(name="friendSequence",allocationSize=1,sequenceName="SQ_FRND_PK")
	@Column(name="FRND_ID")
	private int id;
	/**
	 * Foreign key referring to a specific person.
	 */
	@NotNull
	private int person;
	/**
	 * Foreign key referring to a specific person.
	 */
	@NotNull
	private int isFriendsWith;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public int getIsFriendsWith() {
		return isFriendsWith;
	}
	public void setIsFriendsWith(int isFriendsWith) {
		this.isFriendsWith = isFriendsWith;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + isFriendsWith;
		result = prime * result + person;
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
		Friend other = (Friend) obj;
		if (id != other.id)
			return false;
		if (isFriendsWith != other.isFriendsWith)
			return false;
		if (person != other.person)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Friend [id=" + id + ", person=" + person + ", isFriendsWith=" + isFriendsWith + "]";
	}
	public Friend(int id, @NotNull int person, @NotNull int isFriendsWith) {
		super();
		this.id = id;
		this.person = person;
		this.isFriendsWith = isFriendsWith;
	}
	public Friend() {
		super();
		this.person = 0;
		this.isFriendsWith = 0;
	}
	
	
}
