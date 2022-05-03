package com.xule.controller;

import com.xule.entity.Poor;
import com.xule.entity.PoorWithBLOBs;
import com.xule.service.PoorService;
import com.xule.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;

    @PostMapping("click")
    public ResultVO click(Poor poor) {
        return poorService.click(poor.getId(), poor.getLastClickTime());
    }

    @GetMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3")  Integer pageSize,
                            Long id) {
        return poorService.getList(pageNum, pageSize, id);
    }

    @PostMapping("add")
    public ResultVO add(@RequestBody PoorWithBLOBs poor) {
        return poorService.add(poor);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody PoorWithBLOBs poor){
        return poorService.update(poor);
    }

    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id) {
        return poorService.delete(id);
    }

}
