package cn.prinf.demos.junit.stubs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceAnnotationTest {

    @Mock
    UserRepository mockedUserRepository;
    @Mock
    EmailService mockedEmailService;
    @Spy
    EncryptionService mockedEncryptionService = new EncryptionService();

    @InjectMocks
    UserService userService;

    @Test
    public void should_register() {
        // given
        User user = new User("admin@test.com", "admin", "xxx");

        // when
        userService.register(user);

        // then
        verify(mockedEncryptionService).sha256(eq("xxx"));
        verify(mockedEmailService).sendEmail(
                eq("admin@test.com"),
                eq("Register Notification"),
                eq("Register account successful! your username is admin"));

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(mockedUserRepository).saveUser(argument.capture());

        assertEquals("admin@test.com", argument.getValue().getEmail());
        assertEquals("admin", argument.getValue().getUsername());
        assertEquals("cd2eb0837c9b4c962c22d2ff8b5441b7b45805887f051d39bf133b583baf6860", argument.getValue().getPassword());
    }
}
