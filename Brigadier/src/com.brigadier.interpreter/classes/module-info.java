/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module com.brigadier.interpreter {
    requires com.brigadier.utilities;
    requires com.brigadier.state;
    requires org.mockito;
    requires junit;
    requires hamcrest.all;
    requires guava.testlib;
    requires jmh.core;
    requires com.google.common;
    requires jmh.generator.annprocess;
    exports com.brigadier.interpreter.tree to  com.brigadier.userinterface;
    exports com.brigadier.interpreter.builder to com.brigadier.userinterface;
    exports com.brigadier.interpreter.context to com.brigadier.userinterface;

}
