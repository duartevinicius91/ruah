package huper.digital.ruah.mapper;

import huper.digital.ruah.dto.ColaboradorDto;
import huper.digital.ruah.entity.ColaboradorEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {

  ColaboradorDto toDto(ColaboradorEntity colaborador);

  default List<ColaboradorDto> toDto(List<ColaboradorEntity> colaborador) {
    return colaborador.stream().map(this::toDto).collect(Collectors.toList());
  }

  ColaboradorEntity toEntity(ColaboradorDto colaboradorDto);
  
}
