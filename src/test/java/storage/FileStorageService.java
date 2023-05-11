package storage;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.repository.repository.FileDBRepository;

import model.Model;
import repository.repository;

public class FileStorageService {

	 @Autowired
	  private repository fileDBRepository;

	  public Model store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    Model FileDB = new Model(fileName, file.getContentType(), file.getBytes());

	    return fileDBRepository.save(FileDB);
	  }

	  public Model getFile(String id) {
	    return (Model) fileDBRepository.findById(id).get();
	  }
	  
	  public Stream<org.springframework.ui.Model> getAllFiles() {
	    return fileDBRepository.findAll().stream();
	  }
	
}
