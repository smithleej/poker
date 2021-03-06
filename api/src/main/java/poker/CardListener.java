/*
 * @(#) CardListener.java
 *
 * Copyright 2014 the poker project.
 */

package poker;

/**
 * Listener being notified about card events.
 *
 * @version created on 2014-05-04, 23:00
 */
public interface CardListener {
    /**
     * Triggered on any card movements.
     */
    void cardsChanged(final CardEvent event);
}
