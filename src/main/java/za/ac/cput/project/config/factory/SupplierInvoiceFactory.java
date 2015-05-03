package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.SupplierInvoice;

/**
 * Created by student on 2015/04/26.
 */
public class SupplierInvoiceFactory {

    public static SupplierInvoice createSupplierInvoice(long supplierInvoiceId,
                                                        int quantity){

        SupplierInvoice supplierInvoice = new SupplierInvoice
                                            .Builder(supplierInvoiceId)
                                            .quantity(quantity)
                                            .build();
        return supplierInvoice;
    }
}
