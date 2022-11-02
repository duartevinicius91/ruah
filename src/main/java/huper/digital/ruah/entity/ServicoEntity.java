package huper.digital.ruah.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "servico")
@AllArgsConstructor
@NoArgsConstructor
public class ServicoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 3)
  @NotNull
  private String nome;

  @PositiveOrZero
  @NotNull
  private BigDecimal valor;

  @ManyToMany
  @JoinTable(
      name = "colaborador_servico",
      joinColumns = {@JoinColumn(name = "servico_id")},
      inverseJoinColumns = {@JoinColumn(name = "colaborador_id")}
  )
  @ToString.Exclude
  @JsonIgnore
  private List<ColaboradorEntity> colaboradores;
}
