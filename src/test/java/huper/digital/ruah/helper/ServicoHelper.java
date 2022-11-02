package huper.digital.ruah.helper;

import huper.digital.ruah.dto.ColaboradorDto;
import huper.digital.ruah.dto.ServicoDto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ServicoHelper {

  public static final BigDecimal VALOR = new BigDecimal("11.23");
  public static final String NOME_DO_SERVICO = "Nome do serviço";
  public static final String COLAB_1_NOME = "Colab 1 nome";
  public static final LocalDate COLAB_1_NASC = LocalDate.of(2000, 1, 1);
  public static final LocalDateTime COLAB_1_DATA_CRIACAO = LocalDateTime.of(2020, 05, 03, 0, 25);

  public static ServicoDto create() {
    var req = new ServicoDto();
    req.setValor(VALOR);
    req.setNome(NOME_DO_SERVICO);
    return req;
  }

  private static List<ColaboradorDto> createColaboradores() {
    var colab = new ColaboradorDto();
    colab.setNome(COLAB_1_NOME);
    colab.setNascimento(COLAB_1_NASC);
    return List.of(colab);
  }
}
