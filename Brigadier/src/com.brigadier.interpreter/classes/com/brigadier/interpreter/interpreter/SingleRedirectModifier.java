// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.interpreter;

import com.brigadier.interpreter.context.CommandContext;
import com.brigadier.utilities.exception.*;

@FunctionalInterface
public interface SingleRedirectModifier<S> {
    S apply(CommandContext<S> context) throws CommandSyntaxException;
}
