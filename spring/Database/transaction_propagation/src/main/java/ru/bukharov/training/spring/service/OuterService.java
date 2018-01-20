package ru.bukharov.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component("outerService")
public class OuterService {

    @Autowired
    private InnerService innerService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredThenMandatory(){
        logTransaction();
        innerService.mandatoryPropagationMethod();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredThenRequired() {
        logTransaction();
        innerService.requiredPropagationMethod();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredThenRequiresNew() {
        logTransaction();
        innerService.requiresNewPropagationMethod();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredThenNever() {
        logTransaction();
        innerService.neverPropagationMethod();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredThenNotSupported() {
        logTransaction();
        innerService.notSupportedPropagationMethod();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredThenSupports() {
        logTransaction();
        innerService.supportsPropagationMethod();
    }

    private void logTransaction() {
        String name = TransactionSynchronizationManager.getCurrentTransactionName();
        boolean active = TransactionSynchronizationManager.isActualTransactionActive();
        name = name.substring(name.lastIndexOf(".") + 1);
        System.out.println(String.format("Outer service, transaction %s, active: %b", name, active));
    }

}
