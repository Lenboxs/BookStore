package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Supplier;
import za.ac.cput.project.domain.SupplierInvoice;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class SupplierFactory {

    public static Supplier createSupplier(Long supplierId, Map<String,String>value,Long supplierContactDetails, List<SupplierInvoice> supplierInvoice){

        Supplier supplier = new Supplier
                .Builder(supplierId)
                .supplierName(value.get("supplierName"))
                .supplierEmail(value.get("supplierEmail"))
                .supplierAddress(value.get("supplierAddress"))
                .supplierContactDetails(supplierContactDetails)
                .supplierInvoice(supplierInvoice)
                .build();
        return supplier;
    }
}
