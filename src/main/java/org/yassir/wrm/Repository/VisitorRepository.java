package org.yassir.wrm.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yassir.wrm.Model.Entity.Visitor;

@Repository
public interface VisitorRepository extends CrudRepository<Visitor, Long> {
}
