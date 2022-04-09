package com.xule.service;

import com.xule.entity.Alleviation;
import com.xule.vo.ResultVO;

import java.util.Date;

public interface AlleviationService {
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(Alleviation alleviation);

    ResultVO update(Alleviation alleviation);

    ResultVO delete(Long id);

    ResultVO click(Long id, Date lastClickTime);
}
