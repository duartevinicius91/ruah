package huper.digital.ruah.controller;

import huper.digital.ruah.dto.ColaboradorDto;
import huper.digital.ruah.service.DefaultService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

  private final DefaultService<ColaboradorDto> colaboradorService;

  @GetMapping
  public List<ColaboradorDto> getAll() {
    return colaboradorService.listAll();
  }

  @GetMapping("/{id}")
  public ColaboradorDto getSingle(@NotNull @Min(1L) Long id) {
    return colaboradorService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void delete(@NotNull @Min(1L) Long id) {
    colaboradorService.deleteById(id);
  }

  @PostMapping
  public ResponseEntity create(@Valid ColaboradorDto dto) {
    return ResponseEntity.created(URI.create("/servicos/" + colaboradorService.save(dto))).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@NotNull Long id, @Valid ColaboradorDto dto) {
    colaboradorService.update(id, dto);
    return ResponseEntity.ok().build();
  }
}
