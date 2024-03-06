package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Nome não pode ser nulo")
	private String nome;
	
	@NotNull(message = "Modelo não pode ser nulo")
	private String modelo;
	
	@NotNull(message = "Ano não pode ser nulo")
	private int ano;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("carros")
	private Marca marca;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="carro_proprietario")
	private List<Proprietario> proprietarios;

}



//	@JsonIgnoreProperties("carros") //essa anottation evita que ocorra conversão infinita de JSON (carro -> marca -> carro -> marca...)
