package org.yassir.wrm.Model.Repository;

import org.springframework.data.repository.CrudRepository;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Model.Entity.Visitor;

public interface VisitorRepository extends CrudRepository<Visitor, Long> {
}
