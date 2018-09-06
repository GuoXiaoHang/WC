package com.xiaohang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Utils {
	
	private Utils() {}

	public static int wordCount(File file) throws Exception {
		//用来统计正常文本时是准确的，统计代码时会出现意外的结果
		BufferedReader word_br = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String word_line;
		while ((word_line=word_br.readLine()) != null) {
			sb.append(word_line);
			sb.append("\r");
		}
		String text = new String(sb);
		String[] target = {"\r", ".", " ", "!", "?", "\t", "\n", "\r\n"};
		String newText = null;
		for (int j = 0; j < target.length; j++) {
			newText = text.replace(target[j], ",");
			text = newText;
		}
		String[] words = text.split(",");
//		for (int j = 0; j < words.length; j++) {
//			System.out.println(words[j]);
//		}
		int wordCount = 0;
		for (int j = 0; j < words.length; j++) {
			if (!words[j].equals("")) {
				wordCount++;
			}
		}
		return wordCount;
	}
	
	public static int charCount(File file) throws Exception {
		BufferedReader char_br = new BufferedReader(new FileReader(file));
		int charCount = 0;
		int c;
		while ((c=char_br.read()) != -1) {
			charCount++;
		}
		return charCount;
	}
	
	public static int lineCount(File file) throws Exception {
		BufferedReader line_br = new BufferedReader(new FileReader(file));
		int lineCount = 0;
		String line;
		while ((line=line_br.readLine()) != null) {
			lineCount++;
		}
		return lineCount;
	}
	
	
}
