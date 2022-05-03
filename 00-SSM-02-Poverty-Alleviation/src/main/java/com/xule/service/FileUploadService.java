package com.xule.service;

import com.xule.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    ResultVO fileUpload(MultipartFile file, String type);
}
