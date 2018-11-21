// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.utilities.exception;

import com.brigadier.state.state.*;
import com.brigadier.utilities.utilities.*;
public class DynamicNCommandExceptionType implements CommandExceptionType {
    private final Function function;

    public DynamicNCommandExceptionType(final Function function) {
        this.function = function;
    }

    public CommandSyntaxException create(final Object a, final Object... args) {
        return new CommandSyntaxException(this, function.apply(args));
    }

    public CommandSyntaxException createWithContext(final ImmutableStringReader reader, final Object... args) {
        return new CommandSyntaxException(this, function.apply(args), reader.getString(), reader.getCursor());
    }

    public interface Function {
        Message apply(Object[] args);
    }
}
