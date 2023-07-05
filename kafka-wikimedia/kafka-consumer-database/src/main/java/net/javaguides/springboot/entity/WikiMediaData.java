package net.javaguides.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Recent_change")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WikiMediaData {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
 
	@Lob
	@Column(name = "data", columnDefinition = "BLOB")
	private String wikiEventData;
  
}
