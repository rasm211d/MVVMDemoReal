package com.example.mvvmdemo;

import com.example.mvvmdemo.model.Model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Model model = new Model();
        model.setData("data");
    }
}