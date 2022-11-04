package huper.digital.ruah.controller;

import huper.digital.ruah.dto.ServicoDto;
import huper.digital.ruah.service.ServicoService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController {

  private final ServicoService servicoService;

  @GetMapping
  public List<ServicoDto> getAll() {
    return servicoService.listAll();
  }

  @GetMapping("/{id}")
  public ServicoDto getSingle(@NotNull @Min(1L) Long id) {
    return servicoService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void delete(@NotNull @Min(1L) Long id) {
    servicoService.deleteById(id);
  }

  @PostMapping
  public ResponseEntity create(@Valid @RequestBody ServicoDto servicoRequest) {
    return ResponseEntity.created(URI.create("/servicos/" + servicoService.save(servicoRequest))).build();
  }

  @PutMapping("{id}")
  public ResponseEntity update(@NotNull Long id, @Valid ServicoDto servicoDto) {
    servicoService.update(id, servicoDto);
    return ResponseEntity.ok().build();
  }
}
