// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.interpreter;

import com.brigadier.interpreter.context.CommandContext;

@FunctionalInterface
public interface ResultConsumer<S> {
    void onCommandComplete(CommandContext<S> context, boolean success, int result);
}
