package com.xiaohang;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testWordCount() throws Exception {
		assertEquals(20, Utils.wordCount(new File("WC")));
	}

	@Test
	public void testCharCount() throws Exception {
		assertEquals(144, Utils.charCount(new File("WC")));
	}

	@Test
	public void testLineCount() throws Exception {
		assertEquals(8, Utils.lineCount(new File("WC")));
	}

}
