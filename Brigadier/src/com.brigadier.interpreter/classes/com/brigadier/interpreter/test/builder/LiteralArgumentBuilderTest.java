// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.test.builder;

import com.brigadier.interpreter.interpreter.*;
import com.brigadier.interpreter.tree.*;
import com.brigadier.interpreter.builder.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static com.brigadier.interpreter.arguments.IntegerArgumentType.integer;
import static com.brigadier.interpreter.builder.RequiredArgumentBuilder.argument;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class LiteralArgumentBuilderTest<S> {
    private LiteralArgumentBuilder<Object> builder;
    @Mock
    private
    Command<Object> command;

    @Before
    public void setUp() throws Exception {
        builder = null;
    }

    @Test
    public void testBuild() throws Exception {
        final LiteralCommandNode<Object> node = builder.build();

        assertThat(node.getLiteral(), is("foo"));
    }

    @Test
    public void testBuildWithExecutor() throws Exception {
        final LiteralCommandNode<Object> node = builder.executes(command).build();

        assertThat(node.getLiteral(), is("foo"));
        assertThat(node.getCommand(), is(command));
    }

    @Test
    public void testBuildWithChildren() throws Exception {
        builder.then(argument("bar", integer()));
        builder.then(argument("baz", integer()));
        final LiteralCommandNode<Object> node = builder.build();

        assertThat(node.getChildren(), hasSize(2));
    }
}