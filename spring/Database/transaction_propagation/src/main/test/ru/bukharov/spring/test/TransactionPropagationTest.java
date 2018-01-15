package ru.bukharov.spring.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.IllegalTransactionStateException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.bukharov.training.spring.service.InnerService;
import ru.bukharov.training.spring.service.OuterService;

/*
MANDATORY
Support a current transaction, throw an exception if none exists.
REQUIRED
Support a current transaction, create a new one if none exists.
REQUIRES_NEW
Create a new transaction, and suspend the current transaction if one exists.
NESTED
Execute within a nested transaction if a current transaction exists, behave like PROPAGATION_REQUIRED else.
NEVER
Execute non-transactionally, throw an exception if a transaction exists.
NOT_SUPPORTED
Execute non-transactionally, suspend the current transaction if one exists.
SUPPORTS
Support a current transaction, execute non-transactionally if none exists.
*/


public class TransactionPropagationTest {

    private OuterService outerService;
    private InnerService innerService;

    @BeforeClass
    void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        outerService = (OuterService) context.getBean("outerService");
        innerService = (InnerService) context.getBean("innerService");

    }

//    MANDATORY
//    Support a current transaction, throw an exception if none exists.

    @Test(expectedExceptions = IllegalTransactionStateException.class,
            expectedExceptionsMessageRegExp = "No existing transaction found for transaction marked with propagation 'mandatory'")
    void testMandatoryWithoutCurrentTransaction() {
        innerService.mandatoryPropagationMethod();
    }

    @Test
    void testMandatoryWithCurrentTransaction() {
        outerService.requiredThenMandatory();
    }

//    REQUIRED
//    Support a current transaction, create a new one if none exists.

    @Test
    void testRequiredWithoutCurrentTransaction() {
        innerService.requiredPropagationMethod();
    }

    @Test
    void testRequiredWithCurrentTransaction() {
        outerService.requiredThenRequired();
    }

//    REQUIRES_NEW
//    Create a new transaction, and suspend the current transaction if one exists.

    @Test
    void testRequiredNewWithoutCurrentTransaction() {
        innerService.requiresNewPropagationMethod();
    }

    @Test
    void testRequiredNewWithCurrentTransaction() {
        outerService.requiredThenRequiresNew();
    }

//    NEVER
//    Execute non-transactionally, throw an exception if a transaction exists.

    @Test(expectedExceptions = IllegalTransactionStateException.class,
            expectedExceptionsMessageRegExp = "Existing transaction found for transaction marked with propagation 'never'")
    void testNeverWithCurrentTransaction() {
        outerService.requiredThenNever();
    }

}
