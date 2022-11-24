package huper.digital.ruah.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import huper.digital.ruah.dto.ColaboradorDto;
import huper.digital.ruah.entity.ColaboradorEntity;
import huper.digital.ruah.helper.ColaboradoresHelper;
import huper.digital.ruah.mapper.ColaboradorMapper;
import huper.digital.ruah.repository.ColaboradorRepository;
import huper.digital.ruah.repository.ServicoRepository;
import java.util.Objects;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ColaboradorServiceTest {

  private static ColaboradorService colaboradorService;
  private static ColaboradorRepository colaboradorRepository;
  private static ColaboradorMapper colaboradorMapper;
  private static ServicoRepository servicoRepository;

  @BeforeAll
  static void beforeAll() {
    colaboradorRepository = mock(ColaboradorRepository.class);
    colaboradorMapper = mock(ColaboradorMapper.class);
    servicoRepository = mock(ServicoRepository.class);
    colaboradorService = new ColaboradorService(colaboradorRepository,
                                                  colaboradorMapper,
                                                  servicoRepository);
  }

  @Test
  void listAll() {
    when(colaboradorRepository.findAll())
        .thenReturn(ColaboradoresHelper.createEntityList());
    when(colaboradorMapper.toDto(any(ColaboradorEntity.class)))
        .thenReturn(ColaboradoresHelper.createDto());

    var colaboradorDtos = colaboradorService.listAll();

    assertThat(colaboradorDtos)
        .isNotEmpty()
        .allMatch(dto -> Objects.equals(dto, ColaboradoresHelper.createDto()));
    verify(colaboradorRepository, times(1)).findAll();
    verify(colaboradorMapper, times(1)).toDto(any(ColaboradorEntity.class));

  }

  @Test
  void save() {
    var entity = ColaboradoresHelper.createEntity();
    when(colaboradorMapper.toEntity(any(ColaboradorDto.class))).thenReturn(entity);
    when(colaboradorRepository.save(any())).thenReturn(entity);

    var id = colaboradorService.save(ColaboradoresHelper.createDto());

    assertThat(id).isEqualTo(ColaboradoresHelper.ID);
    verify(servicoRepository, times(1)).findAllById(any());
    verify(colaboradorRepository, times(1)).save(any());
  }

}