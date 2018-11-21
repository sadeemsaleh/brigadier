// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.test.tree;

import com.google.common.testing.EqualsTester;
import com.brigadier.interpreter.interpreter.*;
import com.brigadier.interpreter.tree.*;
import com.brigadier.interpreter.context.*;
import com.brigadier.interpreter.suggestion.*;
import org.junit.Before;
import org.junit.Test;

import com.brigadier.utilities.utilities.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static com.brigadier.interpreter.builder.LiteralArgumentBuilder.literal;


public class RootCommandNodeTest extends AbstractCommandNodeTest {
    private RootCommandNode<Object> node;

    @Override
    protected CommandNode<Object> getCommandNode() {
        return node;
    }

    @Before
    public void setUp() throws Exception {
        node = new RootCommandNode<>();
    }

    @Test
    public void testParse() throws Exception {
        final StringReader reader = new StringReader("hello world");
        node.parse(reader, new CommandContextBuilder<>(new CommandDispatcher<>(), new Object(), new RootCommandNode<>(), 0));
        assertThat(reader.getCursor(), is(0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddChildNoRoot() throws Exception {
        node.addChild(new RootCommandNode<>());
    }

    @Test
    public void testUsage() throws Exception {
        assertThat(node.getUsageText(), is(""));
    }

    @Test
    public void testSuggestions() throws Exception {
        final CommandContext<Object> context = mock(CommandContext.class);
        final Suggestions result = node.listSuggestions(context, new SuggestionsBuilder("", 0)).join();
        assertThat(result.isEmpty(), is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void testCreateBuilder() throws Exception {
        node.createBuilder();
    }

    @Test
    public void testEquals() throws Exception {
        new EqualsTester()
            .addEqualityGroup(
                new RootCommandNode<>(),
                new RootCommandNode<>()
            )
            .addEqualityGroup(
                new RootCommandNode<Object>() {{
                    addChild(literal("foo").build());
                }},
                new RootCommandNode<Object>() {{
                    addChild(literal("foo").build());
                }}
            )
            .testEquals();
    }
}