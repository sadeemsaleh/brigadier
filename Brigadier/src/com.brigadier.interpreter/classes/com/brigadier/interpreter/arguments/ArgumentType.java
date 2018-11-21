// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.arguments;

import com.brigadier.utilities.utilities.StringReader;
import com.brigadier.interpreter.context.CommandContext;
import com.brigadier.utilities.exception.*;
import com.brigadier.interpreter.suggestion.Suggestions;
import com.brigadier.interpreter.suggestion.SuggestionsBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public interface ArgumentType<T> {
    T parse(StringReader reader) throws CommandSyntaxException;

    default <S> CompletableFuture<Suggestions> listSuggestions(final CommandContext<S> context, final SuggestionsBuilder builder) {
        return Suggestions.empty();
    }

    default Collection<String> getExamples() {
        return Collections.emptyList();
    }
}
