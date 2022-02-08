import cn.prinf.demos.junit.powermock.LogService;
import org.junit.Test;
import org.mockito.internal.util.reflection.FieldSetter;

public class WhiteBoxTest {
    @Test
    public void set_value_for_private() throws NoSuchFieldException {
        LogService logService = new LogService();
        FieldSetter.setField(
                logService, LogService.class.getDeclaredField("prefix"),
                "error: "
        );

        logService.log("test data");
    }
}
