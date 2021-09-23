package in.nit.healthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="doc_tab")

public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doc_id_col")
	private Long id;
	@Column(name="doc_name_col")
	private String docName;
	@Column(name="doc_email_col")
	private String docEmail;
	
	
	/**
	 *  SPECIALIZATION	
	 */
	@ManyToOne
	@JoinColumn(name="spec_id_fk")
	private Specialization spec;
	@Column(name="doc_address_col")
	private String docAddr;
	@Column(name="doc_number_col")
	private Long docNumber;
	@Column(name="doc_gender_col")
	private String docGender;
	@Column(name="doc_note_col")
	private String docNote;
	
	/**
	 * DOCTOR PHOTO UPLOAD;
	 */
	@Column(name="image")
	private String photos;
	@Transient
	private String photosImagePath;
	
	public String getPhotosImagePath(){
		if(photos==null || id==null)return null;
		return "/user-photos/" + id + "/" + photos;
		
	}
	
	
}
