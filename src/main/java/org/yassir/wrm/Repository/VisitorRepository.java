package org.yassir.wrm.Repository;

import org.springframework.data.repository.CrudRepository;
import org.yassir.wrm.Model.Entity.Visitor;

public interface VisitorRepository extends CrudRepository<Visitor, Long> {
}
