package com.antzuhl.sharks.controller.visitor;

import com.antzuhl.sharks.entity.Post;
import com.antzuhl.sharks.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author AntzUhl
 * @date 2021/7/6 5:06 下午
 * @description 详情页
 **/
@Controller
@RequestMapping(value = "/sharks")
public class PostController {

    @Resource
    private PostRepository postRepository;

    @RequestMapping(value = "/post/{path}")
    public ModelAndView queryPostDetail(@PathVariable(required = true) String path) {
        ModelAndView mv = new ModelAndView();
        Post postInfo = postRepository.findPostByShortPath(path);
        if (postInfo == null) {
            mv.setViewName("/visitor/404");
            return mv;
        }
        // TODO async incr visits
        mv.setViewName("/visitor/post");
        mv.addObject("post", postInfo);
        return mv;
    }

}
