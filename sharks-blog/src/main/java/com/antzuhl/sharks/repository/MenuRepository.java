package com.antzuhl.sharks.repository;

import com.antzuhl.sharks.entity.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author AntzUhl
 * @date 2021/7/6 6:04 下午
 * @description 描述该文件做了什么
 **/
@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {
}
