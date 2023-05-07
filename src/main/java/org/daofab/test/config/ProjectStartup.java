package org.daofab.test.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.daofab.test.entity.*;
import org.daofab.test.service.InstallmentService;
import org.daofab.test.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectStartup implements CommandLineRunner {

    private static final String PARENT_FILE_PATH = "/json/Parent.json";
    private static final String CHILD_FILE_PATH = "/json/Child.json";
    private final TransactionService transactionService;
    private final InstallmentService installmentService;

    public ProjectStartup(TransactionService transactionService, InstallmentService installmentService) {
        this.transactionService = transactionService;
        this.installmentService = installmentService;
    }


    @Override
    public void run(String... args) {
        saveTransactionsToDatabase();
        saveInstallmentsToDatabase();
    }

    private void saveTransactionsToDatabase() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Parent> typeReference = new TypeReference<Parent>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream(PARENT_FILE_PATH);
        try {
            Parent parent = mapper.readValue(inputStream,typeReference);
            List<Transaction> transactions = parent.getData();
            transactionService.insert(transactions);
        } catch (IOException e){
            throw new RuntimeException("Something went wrong while reading parent json and saving to database on app startup!");
        }
    }

    private void saveInstallmentsToDatabase() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Child> typeReference = new TypeReference<Child>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream(CHILD_FILE_PATH);
        try {
            Child child = mapper.readValue(inputStream,typeReference);
            List<Installment> installments = child.getData().stream().map(this::mapChildItemToInstallment).collect(Collectors.toList());
            installmentService.insert(installments);
        } catch (IOException e){
            throw new RuntimeException("Something went wrong while reading parent json and saving to database on app startup!");
        }
    }

    private Installment mapChildItemToInstallment(ChildItem childItem) {
        Installment installment = new Installment();
        installment.setId(childItem.getId());
        installment.setPaidAmount(childItem.getPaidAmount());
        Transaction transaction = new Transaction();
        transaction.setId(childItem.getParentId());
        installment.setTransaction(transaction);
        return installment;
    }


}
