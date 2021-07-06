package com.antzuhl.sharks.repository;

import com.antzuhl.sharks.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author AntzUhl
 * @date 2021/7/6 5:10 下午
 * @description 描述该文件做了什么
 **/
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    Post findPostByShortPath(String shortPath);

}
