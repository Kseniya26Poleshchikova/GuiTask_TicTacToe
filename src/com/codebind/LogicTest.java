package com.codebind;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.core.Is.is;

@Ignore
public class LogicTest {
    @Test
    public void test_isWinnerX() {
        Figure[][] table = {
                {new Figure(true, false), new Figure(), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(), new Figure(true, false)},
        };
        Logic login = new Logic(table);
        assertThat(login.isWinnerX(), is(true));
    }




    @Test
    public void test_isWinner0() {
        Figure[][] table = {
                {new Figure(true, false), new Figure(), new Figure()},
                {new Figure(true, false), new Figure(true, false), new Figure()},
                {new Figure(true, false), new Figure(), new Figure(true, false)},
        };
        Logic login = new Logic(table);
        assertThat(login.isWinnerO(), is(false));
    }
}
