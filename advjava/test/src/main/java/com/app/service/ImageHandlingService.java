package com.app.service;
import org.springframework.web.multipart.MultipartFile;
import com.app.dto.ApiResponse;
public interface ImageHandlingService {
	ApiResponse uploadImageToFolder(Long empId, MultipartFile file);
}
