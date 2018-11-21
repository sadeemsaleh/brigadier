// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.tree;

import com.brigadier.utilities.utilities.StringReader;
import com.brigadier.interpreter.builder.*;
import com.brigadier.interpreter.context.*;
import com.brigadier.interpreter.context.CommandContextBuilder;
import com.brigadier.utilities.exception.*;
import com.brigadier.interpreter.suggestion.Suggestions;
import com.brigadier.interpreter.suggestion.SuggestionsBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class RootCommandNode<S> extends CommandNode<S> {
    public RootCommandNode() {
        super(null, c -> true, null, s -> Collections.singleton(s.getSource()), false);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getUsageText() {
        return "";
    }

    @Override
    public void parse(final StringReader reader, final CommandContextBuilder<S> contextBuilder) throws CommandSyntaxException {
    }

    @Override
    public CompletableFuture<Suggestions> listSuggestions(final CommandContext<S> context, final SuggestionsBuilder builder) {
        return Suggestions.empty();
    }

    @Override
    public boolean isValidInput(final String input) {
        return false;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof RootCommandNode)) return false;
        return super.equals(o);
    }

    @Override
    public ArgumentBuilder<S, ?> createBuilder() {
        throw new IllegalStateException("Cannot convert root into a builder");
    }

    @Override
    protected String getSortedKey() {
        return "";
    }

    @Override
    public Collection<String> getExamples() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "<root>";
    }
}
