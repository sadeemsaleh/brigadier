/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module com.brigadier.utilities {
    requires com.brigadier.state;
    requires com.google.common;
    requires guava.testlib;
    requires hamcrest.all;
    requires jmh.core;
    requires junit;
    requires org.mockito;
    exports com.brigadier.utilities.exception to com.brigadier.interpreter;
    exports com.brigadier.utilities.utilities to com.brigadier.interpreter;
}
