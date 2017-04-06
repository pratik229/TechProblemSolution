package com.pratik;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pratik.core.TextHandlerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TechProblemSolutionApplicationTests {
	@Autowired
	private TextHandlerService textHandlerService;
	
	@Test
	public void testTop(){
		String str = textHandlerService.getTopCount("text.txt", 1);
		
		assertThat(str).isEqualTo("eget|17");
	}
	
	@Test
	public void testSearch(){
		Map<String,Integer> map = textHandlerService.getWordCount("text.txt", Arrays.asList("Duis","Sed"));
		
		boolean result = (map.get("sed") == 16) && (map.get("duis") == 11);
		
		assertTrue(result);

	}

}
