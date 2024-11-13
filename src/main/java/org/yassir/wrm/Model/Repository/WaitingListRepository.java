package org.yassir.wrm.Model.Repository;

import org.springframework.data.repository.CrudRepository;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Model.Entity.WaitingList;

public interface WaitingListRepository extends CrudRepository<WaitingList, Long> {
}
