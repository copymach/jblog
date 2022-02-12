package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	public BlogDao blogDao;
	
	public String blogInfo(String id) {
		System.out.println("BlogService.blogInfo ");
		return blogDao.blogInfo(id);
	}
	
	public String blogDefalut(BlogVo blogVo, MultipartFile file) {
		System.out.println("BlogService.blogDefalut 블로그 기본값 ");
		
//		업로드파일 경로
		String uploadDir = "c:\\javaStudy\\upload";
//		원본이름
		String oriName = file.getOriginalFilename();
//		확장자이름
		String exeName = oriName.substring(oriName.lastIndexOf("."));
		// 저장파일이름
		String saveName = UUID.randomUUID().toString()+exeName;
//		String saveName = System.currentTimeMillis()+UUID.randomUUID().toString()+exeName;
		
		String failPath = uploadDir+"\\"+saveName;
		
		
		try { // 업로드 기능
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(failPath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		로고 파일 담기
		blogVo.setLogoFile(saveName);
		
		blogDao.blogDefalut(blogVo);
		
		return blogDao.blogInfo(blogVo.getId());
	}
	
	
} // The end of BlogService
