package org.yassir.wrm.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.embeddeds.VisitKey;

@Repository
public interface VisitRepository extends CrudRepository<Visit, VisitKey> {
}
