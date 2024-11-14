package org.yassir.wrm.Repository;

import org.springframework.data.repository.CrudRepository;
import org.yassir.wrm.Model.Entity.WaitingList;

public interface WaitingListRepository extends CrudRepository<WaitingList, Long> {
}
