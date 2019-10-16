package ru.bukharov.training.spring.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.bukharov.training.spring.mixin.PhraseTracked;
import ru.bukharov.training.spring.mixin.PhraseTrackedImpl;

@Component
@Aspect
public class PhraseTracking {

    @DeclareParents(value = "ru.bukharov.training.spring.service..*", defaultImpl = PhraseTrackedImpl.class)
    public static PhraseTracked mixin;

    @Pointcut("execution(* say*())")
    public void sayMethod() {
    }

    @Before(value = "sayMethod() && this(phraseTracked)", argNames = "phraseTracked")
    public void recordUsage(PhraseTracked phraseTracked) {
        phraseTracked.countPhrase();
    }
}
