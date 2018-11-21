// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.brigadier.interpreter.test.argument;
import com.brigadier.interpreter.context.*;
import  com.brigadier.interpreter.arguments.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.brigadier.interpreter.arguments.BoolArgumentType.bool;
import com.brigadier.utilities.utilities.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BoolArgumentTypeTest {
    private BoolArgumentType type;
    @Mock
    private CommandContextBuilder<Object> context;

    @Before
    public void setUp() throws Exception {
        type = bool();
    }

    @Test
    public void parse() throws Exception {
        final StringReader reader = mock(StringReader.class);
        when(reader.readBoolean()).thenReturn(true);
        assertThat(type.parse(reader), is(true));
        verify(reader).readBoolean();
    }
}