package com.xule.service;

import com.xule.vo.ResultVO;

public interface CarouselService {
    ResultVO getList(Integer pageNum, Integer pageSize, Integer id);

}
