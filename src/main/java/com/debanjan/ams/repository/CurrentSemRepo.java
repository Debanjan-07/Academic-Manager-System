package com.pabitra.ams.repository;

import com.pabitra.ams.entity.CurrentSem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface CurrentSemRepo extends JpaRepository<CurrentSem, String> {

    @Query(nativeQuery = true, value = "SELECT sem FROM current_sem WHERE batch =:batch")
    String findSemByBatch(@Param("batch") String batch);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE current_sem SET sem = :sem WHERE batch = :batch")
    void upgrade(String batch, String sem);


}
