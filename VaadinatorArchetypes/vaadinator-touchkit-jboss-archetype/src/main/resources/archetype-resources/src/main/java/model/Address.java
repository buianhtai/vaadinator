package ${package}.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.akquinet.engineering.vaadinator.annotations.DisplayBean;
import de.akquinet.engineering.vaadinator.annotations.DisplayProperty;
import de.akquinet.engineering.vaadinator.annotations.DisplayPropertySetting;
import de.akquinet.engineering.vaadinator.annotations.FieldType;

@DisplayBean(captionText = "Adresse")
@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Address() {
		super();
	}

	public Address(Anreden anrede, String vorname, String nachname, String email) {
		super();
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@DisplayProperty(profileSettings = { @DisplayPropertySetting(fieldType = FieldType.DROPDOWN) }, captionText = "Anrede")
	private Anreden anrede;
	@DisplayProperty
	private String vorname;
	@DisplayProperty(profileSettings = { @DisplayPropertySetting(required = true) })
	private String nachname;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date geburtsdatum;

	public Anreden getAnrede() {
		return anrede;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@DisplayProperty(profileSettings = { @DisplayPropertySetting(showInTable = true, showInDetail = false) })
	public String getName() {
		return getVorname() + " " + getNachname();
	}

	public void setAnrede(Anreden anrede) {
		this.anrede = anrede;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@DisplayProperty(captionText = "E-Mail", profileSettings = { @DisplayPropertySetting(showInTable = true) })
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@DisplayProperty(profileSettings = { @DisplayPropertySetting(sectionName = "Mehr Infos", fieldType = FieldType.DATEPICKER) })
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	@Override
	public int hashCode() {
		if (id != 0) {
			return (int) id;
		}
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anrede == null) ? 0 : anrede.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((geburtsdatum == null) ? 0 : geburtsdatum.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
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
		Address other = (Address) obj;
		if (id != 0) {
			return id == other.id;
		}
		if (anrede != other.anrede)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (geburtsdatum == null) {
			if (other.geburtsdatum != null)
				return false;
		} else if (!geburtsdatum.equals(other.geburtsdatum))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", anrede=" + anrede + ", vorname=" + vorname + ", nachname=" + nachname + ", email=" + email
				+ ", geburtsdatum=" + geburtsdatum + ", getName()=" + getName() + "]";
	}

}
