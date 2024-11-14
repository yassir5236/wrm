package org.yassir.wrm.Repository;

import org.springframework.data.repository.CrudRepository;
import org.yassir.wrm.Model.Entity.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
