package huper.digital.ruah.service;

import static org.apache.commons.lang3.ObjectUtils.firstNonNull;
import static org.apache.commons.lang3.StringUtils.firstNonBlank;

import huper.digital.ruah.dto.ServicoDto;
import huper.digital.ruah.mapper.ServicoMapper;
import huper.digital.ruah.repository.ServicoRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicoService implements DefaultService<ServicoDto> {

  private final ServicoRepository servicoRepository;
  private final ServicoMapper servicoMapper;

  @Override
  public List<ServicoDto> listAll() {
    return servicoRepository.findAll()
        .stream()
        .map(servicoMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public Long save(@Valid ServicoDto newServicoDto) {

    var servicoEntity = servicoRepository.save(servicoMapper.toEntity(newServicoDto));
    servicoRepository.save(servicoEntity);

    return servicoEntity.getId();
  }

  @Override
  public ServicoDto findById(Long id) {
    return servicoRepository.findById(id)
        .map(servicoMapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException());

  }

  @Override
  public void deleteById(Long id) {
    servicoRepository.deleteById(id);
  }

  @Override
  public void update(Long id, @Valid ServicoDto servicoRequest) {
    servicoRepository.findById(id)
        .ifPresent(servicoEntity -> {
          servicoEntity.setNome(firstNonBlank(servicoRequest.getNome(), servicoEntity.getNome()));
          servicoEntity.setValor(firstNonNull(servicoRequest.getValor(), servicoEntity.getValor()));
          servicoRepository.save(servicoEntity);
        });
  }
}
