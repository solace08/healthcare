package in.nit.healthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="specialization_tab")
public class Specialization {

	@Id
	@Column(name="spec_id_col")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="spec_code_col", length=12, nullable = false)
	private String specCode;
	@Column(name="spec_name_col", length=40, nullable = false)
	private String specName;
	@Column(name="spec_note_col", length=250, nullable =false)
	private String specNote;
	
}
