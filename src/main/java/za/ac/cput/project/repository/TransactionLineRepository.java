package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.TransactionLine;

/**
 * Created by student on 2015/05/01.
 */
public interface TransactionLineRepository extends CrudRepository<TransactionLine,Long> {
    public TransactionLine findByCode(String code);
}
