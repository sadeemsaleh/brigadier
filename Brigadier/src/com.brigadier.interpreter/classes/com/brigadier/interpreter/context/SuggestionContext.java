// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.context;

import com.brigadier.interpreter.tree.CommandNode;

public class SuggestionContext<S> {
    public final CommandNode<S> parent;
    public final int startPos;

    public SuggestionContext(CommandNode<S> parent, int startPos) {
        this.parent = parent;
        this.startPos = startPos;
    }
}
