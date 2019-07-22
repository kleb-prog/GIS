import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestAccount {

    DBService dbService = mock(DBService.class);

    @Test
    public void testChangeSurname(){

        AccountsService ac = new AccountsService(dbService);
        when(dbService.changeField(anyString(), anyString())).thenReturn(0).thenReturn(1);

        boolean test1 = ac.changeSurname("1", "2");
        assertFalse(test1);

        boolean test2 = ac.changeSurname("3", "4");
        assertTrue(test2);
    }

    @Test
    public void testSearch(){

        AccountsService ac = new AccountsService(dbService);
        ArrayList<String> correct = new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));
        when(dbService.getAccount(anyString())).thenReturn(null).thenReturn(correct);

        String test1 = ac.searchInRepository("1");
        assertEquals("", test1);

        String test2 = ac.searchInRepository("2");
        assertEquals("1 2 3 4", test2);
    }

}