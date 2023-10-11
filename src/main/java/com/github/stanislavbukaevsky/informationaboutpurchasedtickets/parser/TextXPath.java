package com.github.stanislavbukaevsky.informationaboutpurchasedtickets.parser;

import com.jcabi.xml.XML;
import lombok.RequiredArgsConstructor;

/**
 * Этот класс служит для парсинга xml файло
 */
@RequiredArgsConstructor
public class TextXPath {
    private final XML xml;
    private final String node;


    @Override
    public String toString() {
        return this.xml.nodes(this.node)
                .get(0)
                .xpath("text()")
                .get(0);
    }
}
