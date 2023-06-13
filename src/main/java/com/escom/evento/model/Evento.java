package com.escom.evento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Evento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idevento")
	private Long idEvento;
	
	@NotBlank(message="Se requiere del nombre del evento")
	@Size(min = 4, max = 150, message = "Tienes un rango de caracteres de 4 a 150")
	@Column(name = "nombreevento", length = 150, nullable = false)
	private String nombreEvento;
	
	@NotBlank(message="Se requiere la descripcion del evento")
	@Size(min = 4, max = 200, message = "Tienes un rango de caracteres de 4 a 200")
	@Column(name = "descripcionevento", length = 200, nullable = false)
	private String descripcionEvento;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaevento")
	private Date fechaEvento;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idevento")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<Asistente> listaAsistentes;
}
