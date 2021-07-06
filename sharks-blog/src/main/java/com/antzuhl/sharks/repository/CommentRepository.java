package com.antzuhl.sharks.repository;

import com.antzuhl.sharks.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author AntzUhl
 * @date 2021/7/6 11:59 上午
 * @description 描述该文件做了什么
 **/
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
