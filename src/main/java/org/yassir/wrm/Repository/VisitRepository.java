package org.yassir.wrm.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.embeddeds.VisitKey;

import java.util.List;

@Repository
public interface VisitRepository extends CrudRepository<Visit, VisitKey> {
    List<Visit> findByWaitingListId(Long waitingListId);

}
