package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


	@Repository
	public interface repository extends JpaRepository<Model, String> {

		model.Model save(model.Model model);

	}

