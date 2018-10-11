package com.revature.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Composite key of Preference object.
 * @author Small
 *
 */
@Embeddable
public class PreferenceId implements Serializable {
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = -1545035625149103003L;

		/**
		 * Foreign key referring to a user.
		 */
		@NotNull
		@JoinColumn(name="MUSER_ID", referencedColumnName="MUSER_ID")
	    private int muser_id;
		/**
		 * An integer value referring to a user's preference level.
		 */
	    @NotNull
	    @Size(max = 10)
	    private int pLevel;

		public int getmuser_id() {
			return muser_id;
		}

		public void setmuser_id(int muser_id) {
			this.muser_id = muser_id;
		}

		public int getpLevel() {
			return pLevel;
		}

		public void setpLevel(int pLevel) {
			this.pLevel = pLevel;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + muser_id;
			result = prime * result + pLevel;
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
			PreferenceId other = (PreferenceId) obj;
			if (muser_id != other.muser_id)
				return false;
			if (pLevel != other.pLevel)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "PreferenceId [muser_id=" + muser_id + ", pLevel=" + pLevel + "]";
		}

		public PreferenceId(@NotNull int muser_id, @NotNull @Size(max = 10) int pLevel) {
			super();
			this.muser_id = muser_id;
			this.pLevel = pLevel;
		}

		public PreferenceId() {
			super();
			this.muser_id=0;
			this.pLevel=1;
		}

		
	    
}
