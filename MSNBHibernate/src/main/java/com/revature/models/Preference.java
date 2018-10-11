package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Spring Bean for user Preferences.
 * @author Small
 *
 */
@Entity(name="Preference")
@Table(name="preference")
//@IdClass(PreferenceId.class)
//@Check(constraints = "PREF_LEVEL < 11")
public class Preference implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -816680900028514103L;

	/**
	 * Composite key of a UserId and a PreferenceLevel.
	 */
	@EmbeddedId
	private PreferenceId pId;
	/**
	 * User's preferred genre.
	 */
	@Column(name="GENRE", columnDefinition="VARCHAR2(30)")
	private String genre;

	public PreferenceId getpId() {
		return pId;
	}

	public void setpId(PreferenceId pId) {
		this.pId = pId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((pId == null) ? 0 : pId.hashCode());
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
		Preference other = (Preference) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre)) {
			return false;}
		if (pId == null) {
			if (other.pId != null)
				return false;
		} else if (!pId.equals(other.pId)) {
			return false;}
		return true;
	}

	@Override
	public String toString() {
		return "Preference [pId=" + pId + ", genre=" + genre + "]";
	}

	public Preference(PreferenceId pId, String genre) {
		super();
		this.pId = pId;
		this.genre = genre;
	}

	public Preference() {
		super();
	}


}