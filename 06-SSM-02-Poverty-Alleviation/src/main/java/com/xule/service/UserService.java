package com.xule.service;

import com.xule.entity.User;
import com.xule.vo.ResultVO;

public interface UserService {
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(User user);

    ResultVO update(User user);

    ResultVO delete(Long id);
}
