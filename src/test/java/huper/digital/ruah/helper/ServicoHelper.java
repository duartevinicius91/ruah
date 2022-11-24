package huper.digital.ruah.helper;

import huper.digital.ruah.dto.ServicoDto;
import huper.digital.ruah.entity.ServicoEntity;
import java.math.BigDecimal;

public class ServicoHelper {

  public static final BigDecimal VALOR = new BigDecimal("11.23");
  public static final String NOME_DO_SERVICO = "Nome do serviço";

  public static ServicoDto createDto() {
    var req = new ServicoDto();
    req.setValor(VALOR);
    req.setNome(NOME_DO_SERVICO);
    return req;
  }

  public static ServicoEntity createEntity() {
    var req = new ServicoEntity();
    req.setValor(VALOR);
    req.setNome(NOME_DO_SERVICO);
    return req;
  }
}
