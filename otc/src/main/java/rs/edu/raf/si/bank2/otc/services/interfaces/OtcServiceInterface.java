package rs.edu.raf.si.bank2.otc.services.interfaces;

import rs.edu.raf.si.bank2.otc.models.mongodb.Contract;
import rs.edu.raf.si.bank2.otc.models.mongodb.TransactionElement;

import java.util.List;
import java.util.Optional;

public interface OtcServiceInterface {

    Optional<Contract> getContract(String id);

    List<Contract> getAllContracts();

    Contract editContract(String id, Contract newContract);

    Contract addTransactionElement(String id, TransactionElement transactionElement);

    Contract removeTransactionElement(String id, TransactionElement transactionElement);

    Contract editTransactionElement(String id, TransactionElement transactionElement);

    void deleteContract(String id);
}
