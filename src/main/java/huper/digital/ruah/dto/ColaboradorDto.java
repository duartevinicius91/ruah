package huper.digital.ruah.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class ColaboradorDto {
  private String nome;
  private LocalDate nascimento;
  private List<Long> servicosId;
}
