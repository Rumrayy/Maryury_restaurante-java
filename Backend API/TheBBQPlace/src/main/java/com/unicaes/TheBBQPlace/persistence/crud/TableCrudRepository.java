package com.unicaes.TheBBQPlace.persistence.crud;

import com.unicaes.TheBBQPlace.persistence.entity.FrontDataArea;
import com.unicaes.TheBBQPlace.persistence.entity.TableEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TableCrudRepository extends CrudRepository<TableEntity,Integer> {
    List<TableEntity> findByArea(String area);
}
