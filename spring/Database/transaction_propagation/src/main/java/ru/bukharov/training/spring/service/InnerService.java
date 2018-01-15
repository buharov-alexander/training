package ru.bukharov.training.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component("innerService")
public class InnerService {

    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatoryPropagationMethod() {
        logTransaction();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredPropagationMethod() {
        logTransaction();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNewPropagationMethod() {
        logTransaction();
    }

    @Transactional(propagation = Propagation.NEVER)
    public void neverPropagationMethod() {
        logTransaction();
    }

    private void logTransaction() {
        String name = TransactionSynchronizationManager.getCurrentTransactionName();
        name = name.substring(name.lastIndexOf(".") + 1);
        System.out.println("Inner service, transaction " + name);
    }
}
