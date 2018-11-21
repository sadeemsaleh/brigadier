// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.interpreter;

import com.brigadier.interpreter.context.*;

import com.brigadier.utilities.exception.*;
import com.brigadier.utilities.utilities.*;
import java.util.Collection;

@FunctionalInterface
public interface RedirectModifier<S> {
    Collection<S> apply(CommandContext<S> context) throws CommandSyntaxException;
}
