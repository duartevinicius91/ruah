package huper.digital.ruah.dto;

import java.util.List;
import lombok.Data;

@Data
public class ColaboradorDto {
  private String nome;
  private String telefone;
  private List<Long> servicosId;
  private List<ServicoDto> servicos;
}
