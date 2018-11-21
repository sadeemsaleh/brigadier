// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.test.tree;

import com.brigadier.interpreter.interpreter.*;
import com.brigadier.interpreter.tree.*;
import com.brigadier.interpreter.builder.*;
import com.brigadier.interpreter.context.*;
import com.brigadier.interpreter.suggestion.*;
import static com.brigadier.interpreter.arguments.IntegerArgumentType.integer;
import  static com.brigadier.interpreter.builder.RequiredArgumentBuilder.argument;


import com.brigadier.utilities.utilities.*;




import com.google.common.testing.EqualsTester;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ArgumentCommandNodeTest extends AbstractCommandNodeTest {
    private ArgumentCommandNode<Object, Integer> node;
    private CommandContextBuilder<Object> contextBuilder;

    @Override
    protected CommandNode<Object> getCommandNode() {
        return node;
    }

    @Before
    public void setUp() throws Exception {
        node = argument("foo", integer()).build();
        contextBuilder = new CommandContextBuilder<>(new CommandDispatcher<>(), new Object(), new RootCommandNode<>(), 0);
    }

    @Test
    public void testParse() throws Exception {
        final StringReader reader = new StringReader("123 456");
        node.parse(reader, contextBuilder);

        assertThat(contextBuilder.getArguments().containsKey("foo"), is(true));
        assertThat(contextBuilder.getArguments().get("foo").getResult(), is(123));
    }

    @Test
    public void testUsage() throws Exception {
        assertThat(node.getUsageText(), is("<foo>"));
    }

    @Test
    public void testSuggestions() throws Exception {
        final Suggestions result = node.listSuggestions(contextBuilder.build(""), new SuggestionsBuilder("", 0)).join();
        assertThat(result.isEmpty(), is(true));
    }

    @Test
    public void testEquals() throws Exception {
        @SuppressWarnings("unchecked") final Command<Object> command = (Command<Object>) mock(Command.class);

        new EqualsTester()
            .addEqualityGroup(
                argument("foo", integer()).build(),
                argument("foo", integer()).build()
            )
            .addEqualityGroup(
                argument("foo", integer()).executes(command).build(),
                argument("foo", integer()).executes(command).build()
            )
            .addEqualityGroup(
                argument("bar", integer(-100, 100)).build(),
                argument("bar", integer(-100, 100)).build()
            )
            .addEqualityGroup(
                argument("foo", integer(-100, 100)).build(),
                argument("foo", integer(-100, 100)).build()
            )
            .addEqualityGroup(
                argument("foo", integer()).then(
                    argument("bar", integer())
                ).build(),
                argument("foo", integer()).then(
                    argument("bar", integer())
                ).build()
            )
            .testEquals();
    }

    @Test
    public void testCreateBuilder() throws Exception {
        final RequiredArgumentBuilder<Object, Integer> builder = node.createBuilder();
        assertThat(builder.getName(), is(node.getName()));
        assertThat(builder.getType(), is(node.getType()));
        assertThat(builder.getRequirement(), is(node.getRequirement()));
        assertThat(builder.getCommand(), is(node.getCommand()));
    }
}