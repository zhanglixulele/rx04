package com.xule.controller;

import com.xule.entity.Carousel;
import com.xule.entity.User;
import com.xule.service.CarouselService;
import com.xule.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @PostMapping("state")
    public ResultVO changeStatus(@RequestParam Integer id){
        return carouselService.changeStatus(id);
    }

    @GetMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum") Integer pageNum,
                            @RequestParam(value = "pageSize") Integer pageSize,
                            @RequestParam(value = "id") Integer id){
        return carouselService.getList(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVO add(@RequestBody Carousel carousel){
        return carouselService.add(carousel);
    }
    @PostMapping("update")
    public ResultVO update(@RequestBody Carousel carousel){
        return carouselService.update(carousel);
    }
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Integer id){
        return carouselService.delete(id);
    }
}
