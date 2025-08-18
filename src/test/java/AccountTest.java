import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    @Test
    void shouldCreateAccountWithValidIdAndBalance() {
        // given
        String id = "A1";
        double initialBalance = 100.0;

        // when
        Account account = new Account(id, initialBalance);

        // then
        assertEquals("A1", account.getId());
        assertEquals(100.0, account.getBalance());
    }
}