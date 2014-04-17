/*
 * Copyright
 */
package poker;

import java.util.Collections;
import java.util.List;

/**
 * TODO describe me!
 *
 * @version created on 2014-04-17, 11:26
 */
public class PlayerStateDTO {
    private final int chipsLeft;
    private final List<CardDTO> cards;

    public PlayerStateDTO(final List<CardDTO> cards, final int chipsLeft) {
        this.cards = Collections.unmodifiableList(cards);
        this.chipsLeft = chipsLeft;
    }

    public List<CardDTO> getCards() {
        return cards;
    }

    public int getChipsLeft() {
        return chipsLeft;
    }
}