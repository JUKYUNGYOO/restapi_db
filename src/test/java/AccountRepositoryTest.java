import account.Account;
import account.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
//h2 실행
@Autowired
    DataSource dataSource;
@Autowired
    JdbcTemplate jdbcTemplate;
@Autowired
    AccountRepository accountRepository;
@Test
  public void di() throws SQLException{
   Account account = new Account();
   account.setUsername("jukyung");
   account.setPassword("pass");


   Account newAccount = accountRepository.save(account);
   assertThat(newAccount).isNotNull();

   Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
   assertThat(existingAccount).isNotEmpty();

   Optional<Account> nonExistingAccount = accountRepository.findByUsername("whiteship");
   assertThat(nonExistingAccount).isNull();
}


}






