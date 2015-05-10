package za.ac.cput.project.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by student on 2015/05/07.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({   BookTest.class,
                        ClientTest.class,
                        EmployeeTest.class,
                        OrderLineTest.class,
                        OrderTest.class,
                        SupplierInvoiceTest.class,
                        SupplierTest.class,
                        TransactionLineTest.class,
                        TransactionTest.class})
public class TestSuite {
}
