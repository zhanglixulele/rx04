package com.xule.service;

import com.xule.entity.PoorWithBLOBs;
import com.xule.vo.ResultVO;

import java.util.Date;

public interface PoorService {
    ResultVO click(Long id, Date lastClickTime);

    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(PoorWithBLOBs poor);

    ResultVO update(PoorWithBLOBs poor);

    ResultVO delete(Long id);
}
