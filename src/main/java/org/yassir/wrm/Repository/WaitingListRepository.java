package org.yassir.wrm.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yassir.wrm.Model.Entity.WaitingList;

@Repository
public interface WaitingListRepository extends CrudRepository<WaitingList, Long> {
}
