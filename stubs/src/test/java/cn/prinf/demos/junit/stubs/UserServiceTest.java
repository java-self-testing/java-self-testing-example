package cn.prinf.demos.junit.stubs;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockingDetails;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class UserServiceTest {

    @Test
    public void should_register() {
        // 使用 Mockito 模拟三个对象
        UserRepository mockedUserRepository = mock(UserRepository.class);
        // mock 方法
        EmailService mockedEmailService = mock(EmailService.class);
        // spy 方法
        EncryptionService spiedEncryptionService = spy(new EncryptionService());
        UserService userService = new UserService(mockedUserRepository, mockedEmailService, spiedEncryptionService);

        // given
        User user = new User("admin@test.com", "admin", "xxx");

        // when
        userService.register(user);

        // then
        verify(spiedEncryptionService).sha256(eq("xxx"));
        verify(mockedEmailService).sendEmail(
                eq("admin@test.com"),
                eq("Register Notification"),
                eq("Register Account successful! your username is admin"));

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(mockedUserRepository).saveUser(argument.capture());

        assertEquals("admin@test.com", argument.getValue().getEmail());
        assertEquals("admin", argument.getValue().getUsername());
        assertEquals("cd2eb0837c9b4c962c22d2ff8b5441b7b45805887f051d39bf133b583baf6860", argument.getValue().getPassword());
    }

    @Test
    public void bdd_style() {
        UserRepository mockedUserRepository = mock(UserRepository.class);
        EmailService mockedEmailService = mock(EmailService.class);
        EncryptionService mockedEncryptionService = mock(EncryptionService.class);

        // given
        given(mockedEncryptionService.sha256(any()))
                .willReturn("cd2eb0837c9b4c962c22d2ff8b5441b7b45805887f051d39bf133b583baf6860");
        UserService userService = new UserService(mockedUserRepository, mockedEmailService, mockedEncryptionService);
        User user = new User("admin@test.com", "admin", "xxx");

        // when
        userService.register(user);

        // then
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(mockedUserRepository).saveUser(argument.capture());
        assertEquals("cd2eb0837c9b4c962c22d2ff8b5441b7b45805887f051d39bf133b583baf6860", argument.getValue().getPassword());
    }


    @Test
    public void get_mock_detail_info() {
        EncryptionService mockedEncryptionService = mock(EncryptionService.class);

        given(mockedEncryptionService.sha256(any()))
                .willReturn("cd2eb0837c9b4c962c22d2ff8b5441b7b45805887f051d39bf133b583baf6860");

        MockingDetails mockingDetails = Mockito.mockingDetails(mockedEncryptionService);
        System.out.println(mockingDetails.isMock());
        System.out.println(mockingDetails.getStubbings());
    }

    @Test
    public void lambda_verify() {
        EncryptionService mockedEncryptionService = mock(EncryptionService.class);

        given(mockedEncryptionService.sha256(any()))
                .willReturn("cd2eb0837c9b4c962c22d2ff8b5441b7b45805887f051d39bf133b583baf6860");

        mockedEncryptionService.sha256("xxx");

        verify(mockedEncryptionService).sha256(argThat(argument -> argument.equals("xxx")));
    }
}
