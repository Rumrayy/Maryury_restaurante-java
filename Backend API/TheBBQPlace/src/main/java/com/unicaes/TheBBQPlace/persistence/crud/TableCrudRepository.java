package com.unicaes.TheBBQPlace.persistence.crud;

import com.unicaes.TheBBQPlace.persistence.entity.FrontDataArea;
import com.unicaes.TheBBQPlace.persistence.entity.TableEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface TableCrudRepository extends CrudRepository<TableEntity,Integer> {
    //TableEntity findByAreaAndCapacityGreaterThanEqual(String area, Integer capacity);

    @Query("SELECT t FROM TableEntity t LEFT JOIN ReserveEntity r ON t.tableId = r.reserveId " +
            "WHERE t.area = :area AND t.capacity >= :capacity AND (r.date != :date OR r.date IS NULL) " +
            "AND (r.hour != :hour OR r.hour IS NULL)")
    List<TableEntity> findAvailableTables(@Param("area") String area,
                                          @Param("capacity") Integer capacity,
                                          @Param("date") Date date,
                                          @Param("hour") LocalTime time);
}
