package ru.bukharov.training.spring.mixin;

public class PhraseTrackedImpl implements PhraseTracked {

    private int count = 0;

    @Override
    public void countPhrase() {
        count++;
        System.out.println("Phrase counter was incremented: " + count);
    }

    @Override
    public int count() {
        return count;
    }
}
