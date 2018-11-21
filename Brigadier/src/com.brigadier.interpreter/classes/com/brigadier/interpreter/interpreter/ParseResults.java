/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brigadier.interpreter.interpreter;

import com.brigadier.interpreter.context.CommandContextBuilder;
import com.brigadier.utilities.exception.*;
import com.brigadier.utilities.utilities.*;
import com.brigadier.interpreter.tree.CommandNode;

import java.util.Collections;
import java.util.Map;

public class ParseResults<S> {
    private final CommandContextBuilder<S> context;
    private final Map<CommandNode<S>, CommandSyntaxException> exceptions;
    private final ImmutableStringReader reader;

    public ParseResults(final CommandContextBuilder<S> context, final ImmutableStringReader reader, final Map<CommandNode<S>, CommandSyntaxException> exceptions) {
        this.context = context;
        this.reader = reader;
        this.exceptions = exceptions;
    }

    public ParseResults(final CommandContextBuilder<S> context) {
        this(context, new StringReader(""), Collections.emptyMap());
    }

    public CommandContextBuilder<S> getContext() {
        return context;
    }

    public ImmutableStringReader getReader() {
        return reader;
    }

    public Map<CommandNode<S>, CommandSyntaxException> getExceptions() {
        return exceptions;
    }
}

/**
 *
 * @author sadeem
 */

