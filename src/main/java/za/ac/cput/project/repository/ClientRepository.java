package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.Client;

/**
 * Created by student on 2015/05/01.
 */
public interface ClientRepository extends CrudRepository<Client,Long> {
   // public Client findByCode(String code);
}
