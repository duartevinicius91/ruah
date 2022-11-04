package huper.digital.ruah.helper;

import huper.digital.ruah.dto.ColaboradorDto;
import huper.digital.ruah.entity.ColaboradorEntity;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ColaboradoresHelper {
  public static final String COLAB_1_NOME = "Colab 1 nome";
  public static final LocalDate COLAB_1_NASC = LocalDate.of(2000, 1, 1);
  public static final long ID = 123L;

  public static ColaboradorDto createDto() {
    var colab = new ColaboradorDto();
    colab.setNome(COLAB_1_NOME);
    colab.setServicos(Arrays.asList(ServicoHelper.createDto()));
    return colab;
  }

  public static List<ColaboradorDto> createDtoList() {
    return List.of(createDto());
  }

  public static ColaboradorEntity createEntity() {
    var colab = new ColaboradorEntity();
    colab.setId(ID);
    colab.setNome(COLAB_1_NOME);
    colab.setServicos(List.of(ServicoHelper.createEntity()));
    return colab;
  }

  public static List<ColaboradorEntity> createEntityList() {
    return List.of(createEntity());
  }
}
