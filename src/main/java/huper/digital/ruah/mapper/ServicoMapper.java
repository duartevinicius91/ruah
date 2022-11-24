package huper.digital.ruah.mapper;

import huper.digital.ruah.dto.ServicoDto;
import huper.digital.ruah.entity.ServicoEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

  ServicoDto toDto(ServicoEntity servico);

  default List<ServicoDto> toDto(List<ServicoEntity> servico) {
    return servico.stream().map(this::toDto).collect(Collectors.toList());
  }

  ServicoEntity toEntity(ServicoDto servicoDto);

}
