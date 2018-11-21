// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.arguments;

import com.brigadier.utilities.exception.*;
import com.brigadier.utilities.utilities.*;
import com.brigadier.interpreter.context.CommandContext;
import com.brigadier.interpreter.suggestion.Suggestions;
import com.brigadier.interpreter.suggestion.SuggestionsBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class BoolArgumentType implements ArgumentType<Boolean> {
    private static final Collection<String> EXAMPLES = Arrays.asList("true", "false");

    private BoolArgumentType() {
    }

    public static BoolArgumentType bool() {
        return new BoolArgumentType();
    }

    public static boolean getBool(final CommandContext<?> context, final String name) {
        return context.getArgument(name, Boolean.class);
    }

    @Override
    public Boolean parse(final StringReader reader) throws CommandSyntaxException {
        return reader.readBoolean();
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(final CommandContext<S> context, final SuggestionsBuilder builder) {
        if ("true".startsWith(builder.getRemaining().toLowerCase())) {
            builder.suggest("true");
        }
        if ("false".startsWith(builder.getRemaining().toLowerCase())) {
            builder.suggest("false");
        }
        return builder.buildFuture();
    }

    @Override
    public Collection<String> getExamples() {
        return EXAMPLES;
    }
}
