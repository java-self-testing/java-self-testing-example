import cn.prinf.demos.junit.powermock.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.spy;


@RunWith(PowerMockRunner.class)
@PrepareForTest({LogService.class})
public class PrivateTest {
    @Test
    public void private_test() throws Exception {
        LogService logService = mock(LogService.class);
        PowerMockito.doNothing().when(logService, "_log", any());

        logService.log("test data");
    }

    @Test
    public void private_test2() throws Exception {
        LogService logService = spy(new LogService());
        PowerMockito.doNothing().when(logService, "_log", any());

        logService.log("test data");
    }
}
