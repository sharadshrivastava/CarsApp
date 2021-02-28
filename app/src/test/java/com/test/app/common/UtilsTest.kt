package com.test.app.common

import com.test.app.data.common.formatDate
import org.junit.Assert
import org.junit.Test


class UtilsTest {

    @Test
    fun testFormatDate() {
        val expected = "Feb 5, 2021"
        val actual = formatDate("2021-02-05T23:15:30.000Z")
        Assert.assertEquals(expected, actual)
    }
}