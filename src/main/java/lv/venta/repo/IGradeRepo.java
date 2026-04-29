package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;
import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long>{

}
