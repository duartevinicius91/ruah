package huper.digital.ruah.service;

import java.util.List;
import javax.validation.Valid;

public interface DefaultService<T> {
  List<T> listAll();

  Long save(@Valid T dto);

  T findById(Long id);

  void deleteById(Long id);

  void update(Long id, @Valid T dto);

}
