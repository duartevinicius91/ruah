package huper.digital.ruah.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "colaborador")
@Data
public class ColaboradorEntity {
  @Id
  private Long id;

  @Size(min = 3)
  private String nome;

  @Past
  private LocalDate nascimento;

  @PastOrPresent
  private LocalDateTime dataCriacao;

  @ManyToMany(mappedBy = "colaboradores")
  @ToString.Exclude
  private List<ServicoEntity> servicos;
}
