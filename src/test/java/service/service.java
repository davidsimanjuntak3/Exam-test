package service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import model.Model;
import repository.repository;


@Service
public class service {

	@Autowired
	  private repository Repository;

	  public Model store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    Model Model = new Model(fileName, file.getContentType(), file.getBytes());

	    return Repository.save(Model);
	  }

	  public Model getFile(String id) {
	    return (Model) Repository.findById(id).get();
	  }
	  
	  public Stream<org.springframework.ui.Model> getAllFiles() {
	    return Repository.findAll().stream();
	  }
}
