package huper.digital.ruah.service;


import huper.digital.ruah.dto.ColaboradorDto;
import huper.digital.ruah.mapper.ColaboradorMapper;
import huper.digital.ruah.repository.ColaboradorRepository;
import huper.digital.ruah.repository.ServicoRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColaboradorService implements DefaultService<ColaboradorDto> {

  private final ColaboradorRepository colaboradorRepository;
  private final ColaboradorMapper mapper;
  private final ServicoRepository servicoRepository;

  @Override
  public List<ColaboradorDto> listAll() {
    return colaboradorRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
  }

  @Override
  public Long save(ColaboradorDto dto) {
    var colaboradorEntity = mapper.toEntity(dto);

    colaboradorEntity.setServicos(servicoRepository.findAllById(dto.getServicosId()));

    colaboradorEntity = colaboradorRepository.save(colaboradorEntity);

    return colaboradorEntity.getId();
  }

  @Override
  public ColaboradorDto findById(Long id) {
    return colaboradorRepository.findById(id)
        .map(mapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException());
  }

  @Override
  public void deleteById(Long id) {
    colaboradorRepository.findById(id)
        .ifPresentOrElse(colaborador -> colaboradorRepository.delete(colaborador), () -> new EntityNotFoundException());
  }

  @Override
  public void update(@NotNull Long id, ColaboradorDto dto) {
    var colaboradorEntity = mapper.toEntity(dto);

    colaboradorEntity.setServicos(servicoRepository.findAllById(dto.getServicosId()));

    colaboradorEntity.setId(id);
    colaboradorRepository.save(colaboradorEntity);

  }


}
