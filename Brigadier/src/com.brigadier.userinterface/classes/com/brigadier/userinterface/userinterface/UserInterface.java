/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brigadier.userinterface.userinterface;


import com.brigadier.interpreter.builder.LiteralArgumentBuilder;

import com.brigadier.interpreter.tree.LiteralCommandNode;
import com.brigadier.interpreter.tree.RootCommandNode;

/**
 *
 * @author sadeem
 */
public class UserInterface<S> {
    private final RootCommandNode<S> root  = null;

    public LiteralCommandNode<S> register(final LiteralArgumentBuilder<S> command) {
        final LiteralCommandNode<S> build = command.build();
        root.addChild(build);
        return build;
    }
    
   
    
}
