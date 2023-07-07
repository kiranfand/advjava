package com.app.service;
import java.io.File;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.app.dto.ApiResponse;
import com.app.repository.EmployeeRepository;
@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {
	@Autowired
	private EmployeeRepository empRepo;
	@Value("${upload.location}")
	private String uploadFolder;
	@PostConstruct
	public void myInit()
	{
		System.out.println("in init "+uploadFolder);
		File dir=new File(uploadFolder);
		if(dir.exists())
			System.out.println("folder alrdy exists !!!!");
		else  {
			dir.mkdirs();
			System.out.println("created a new folder");
		}
	}
	@Override
	public ApiResponse uploadImageToFolder(Long empId, MultipartFile file) {
		return null;
	}
}
