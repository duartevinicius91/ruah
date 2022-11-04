package huper.digital.ruah.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import huper.digital.ruah.helper.ServicoHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class ServicoMapperTest {

  private static ServicoMapper servicoMapper = Mappers.getMapper( ServicoMapper.class );


  @Test
  @DisplayName("Deve converter um request de servico para entidade de serviço sem erros")
  public void shouldMapCarToDto() {

    var ent = servicoMapper.toEntity(ServicoHelper.createDto());

    assertNotNull(ent);
    assertEquals(ServicoHelper.NOME_DO_SERVICO, ent.getNome());
    assertEquals(ServicoHelper.VALOR, ent.getValor());
  }
}