package za.ac.cput.project.repository;

/**
 * Created by student on 2015/05/03.
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({   TestCrudBook.class,

                        TestCrudEmployee.class,

                        TestCrudOrderLine.class,

                        TestCrudTransaction.class,
                        TestCrudTransactionLine.class})

public class TestSuite
{
/*TestCrudBook.class,
                        TestCrudClient.class,
                        TestCrudEmployee.class,
                        TestCrudOrder.class,
                        TestCrudOrderLine.class,
                        TestCrudSupplier.class,
                        TestCrudSupplierInvoice.class,
                        TestCrudTransaction.class,
                        TestCrudTransactionLine.class*/
}
