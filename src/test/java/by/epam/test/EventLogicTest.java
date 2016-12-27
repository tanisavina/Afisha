package by.epam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;

@RunWith(Parameterized.class)
public class EventLogicTest {
	
	public static final String TEST_TRUE = "Test true";
	public static final String TEST_FALSE = "Test false";
	
	private static EventLogic Logic;
	//private String value;
	public String value;
	
	@Parameters
	public static List<String> data(){
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("Test true");
		list.add("Test false");
		return list;
	}
	
	
/*	public EventLogicTest(String value){
		this.value = value;
	}*/
	
	@Before
	public static void initEventLogic(){
		Logic = new EventLogic();
		
	}
	
	@Test
	public void testDoSmthTrue(){
		
		assertEquals("Test true", Logic.doSmth(TEST_TRUE));
	}
	@Ignore
	@Test
	public void testDoSmthFalse(){
		EventLogic logic= new EventLogic();
		assertEquals("Test true", logic.doSmth(TEST_FALSE));
	}

}
