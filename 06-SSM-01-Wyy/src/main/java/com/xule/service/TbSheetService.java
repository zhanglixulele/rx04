package com.xule.service;

import com.xule.entity.TbMusic;
import com.xule.entity.TbSheet;

import java.util.List;
import java.util.Map;

public interface TbSheetService {
    List<TbSheet> findAll();

    List<TbMusic> findSongsBySheet(String sheetName);

    Map<String, Object> insertSheet(TbSheet sheetName);
}
