/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.java.full.stack.app;

import org.java.full.stack.list.LinkedList;

import static org.java.full.stack.utilities.StringUtils.join;
import static org.java.full.stack.utilities.StringUtils.split;
import static org.java.full.stack.app.MessageUtils.getMessage;

import org.apache.commons.text.WordUtils;

public class App {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        String result = join(tokens);
        System.out.println(WordUtils.capitalize(result));
    }
}
