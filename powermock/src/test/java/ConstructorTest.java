import cn.prinf.demos.junit.powermock.EmailService;
import cn.prinf.demos.junit.powermock.EncryptionService;
import cn.prinf.demos.junit.powermock.LogService;
import cn.prinf.demos.junit.powermock.User;
import cn.prinf.demos.junit.powermock.UserRepository;
import cn.prinf.demos.junit.powermock.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class ConstructorTest {

    @Mock
    UserRepository mockedUserRepository;
    @Mock
    EmailService mockedEmailService;

    @Spy
    EncryptionService mockedEncryptionService = new EncryptionService();

    @InjectMocks
    UserService userService;

    @Test
    public void should_log_message_when_registering() throws Exception {
        // Given
        User user = new User("admin@test.com", "admin", "xxx", null);

        LogService mockedLogService = mock(LogService.class);
        whenNew(LogService.class).withNoArguments().thenReturn(mockedLogService);

        // When
        userService.register(user);

        // Then
        Mockito.verify(mockedLogService).log(any());

        verifyNew(LogService.class).withNoArguments();
    }
}
