package com.fpoly.HandleService;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	@Autowired
	ServletContext context;
	
	public List<String> list(String folder) {
		List<String> filenames = new ArrayList<String>();
		File dir = Paths.get(context.getRealPath("/images/"), folder).toFile();
		System.out.println(Paths.get(context.getRealPath("/images/"), folder).toFile());
//		if(dir.exists()) {
//			File[] files = dir.listFiles();
//			for(File file: files) {
//				filenames.add(file.getName());
//			}
//		}
		return filenames;
	}

}
