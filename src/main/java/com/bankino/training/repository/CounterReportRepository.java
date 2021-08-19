package com.bankino.training.repository;

import com.bankino.training.domain.CounterReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface CounterReportRepository extends JpaRepository<CounterReport, Long> {


    @Query(value = "SELECT  * FROM counter_report cr WHERE  cr.start_date >=:startDate AND cr.start_date <=:endDate  AND cr.COUNTER_ID=:counterId",
            nativeQuery = true)
    List<CounterReport> findAllNotCalculatedReports(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("counterId")Long counterId);


}

