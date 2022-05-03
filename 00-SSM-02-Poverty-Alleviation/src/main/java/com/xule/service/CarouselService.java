package com.xule.service;

import com.xule.entity.Carousel;
import com.xule.vo.ResultVO;

public interface CarouselService {
    ResultVO getList(Integer pageNum, Integer pageSize, Integer id);

    ResultVO add(Carousel carousel);

    ResultVO update(Carousel carousel);

    ResultVO delete(Integer id);

    ResultVO changeStatus(Integer id);
}
