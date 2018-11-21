// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.interpreter;

import com.brigadier.interpreter.context.*;

import com.brigadier.utilities.exception.*;
import com.brigadier.utilities.utilities.*;

@FunctionalInterface
public interface Command<S> {
    int SINGLE_SUCCESS = 1;

    int run(CommandContext<S> context) throws CommandSyntaxException;
}
