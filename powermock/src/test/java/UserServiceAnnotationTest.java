import cn.prinf.demos.junit.powermock.EmailService;
import cn.prinf.demos.junit.powermock.EncryptionService;
import cn.prinf.demos.junit.powermock.User;
import cn.prinf.demos.junit.powermock.UserRepository;
import cn.prinf.demos.junit.powermock.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
@RunWith(PowerMockRunner.class)
// 使用 PrepareForTest 让模拟行为在被测试代码中生效
@PrepareForTest({UserService.class})
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
        // 模拟前生成一个 Instant 实例
        Instant moment = Instant.ofEpochSecond(1596494464);

        // 模拟并设定期望返回值
        PowerMockito.mockStatic(Instant.class);
        PowerMockito.when(Instant.now()).thenReturn(moment);

        // Given
        User user = new User("admin@test.com", "admin", "xxx", null);

        // When
        userService.register(user);

        // Then
        verify(mockedEmailService).sendEmail(
                eq("admin@test.com"),
                eq("Register Notification"),
                eq("Register account successful! your username is admin"));

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(mockedUserRepository).saveUser(argument.capture());

        assertEquals("admin@test.com", argument.getValue().getEmail());
        assertEquals("admin", argument.getValue().getUsername());
        assertEquals("cd2eb0837c9b4c962c22d2ff8b5441b7b45805887f051d39bf133b583baf6860", argument.getValue().getPassword());
        assertEquals(moment, argument.getValue().getCreateAt());
    }
}
