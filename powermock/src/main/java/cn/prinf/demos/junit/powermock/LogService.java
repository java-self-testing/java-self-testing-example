package cn.prinf.demos.junit.powermock;

public class LogService {
    private String prefix = "warning: ";

    public void log(String content) {
        _log(content);
    }

    private void _log(String content) {
        System.out.println(prefix + content);
    }
}
