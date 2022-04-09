package com.xule.controller;

import com.xule.entity.Alleviation;
import com.xule.service.AlleviationService;
import com.xule.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    @PostMapping("click")
    public ResultVO click(Alleviation alleviation){
        return alleviationService.click(alleviation.getId(),alleviation.getLastClickTime());
    }


    @GetMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum") Integer pageNum,
                            @RequestParam(value = "pageSize") Integer pageSize,
                            @RequestParam(value = "id") Long id) {
        return alleviationService.getList(pageNum, pageSize, id);
    }

    @PostMapping("add")
    public ResultVO add(@RequestBody Alleviation alleviation) {
        return alleviationService.add(alleviation);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Alleviation alleviation) {
        return alleviationService.update(alleviation);
    }

    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id) {
        return alleviationService.delete(id);
    }
}
