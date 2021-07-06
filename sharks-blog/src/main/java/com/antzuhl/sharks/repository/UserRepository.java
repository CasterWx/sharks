package com.antzuhl.sharks.repository;

import com.antzuhl.sharks.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author AntzUhl
 * @date 2021/7/6 3:32 下午
 * @description 描述该文件做了什么
 **/
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByUsername(String username);
}
