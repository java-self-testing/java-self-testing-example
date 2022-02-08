package cn.prinf.demos.junit.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.common.Notifier;
import com.github.tomakehurst.wiremock.common.ProxySettings;
import com.github.tomakehurst.wiremock.core.Options;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


public class WireMockExtension extends WireMockServer implements BeforeEachCallback, AfterEachCallback {
    public WireMockExtension() {
    }

    public WireMockExtension(Options options) {
        super(options);
    }

    public WireMockExtension(int port, Integer httpsPort) {
        super(port, httpsPort);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        stop();
        resetAll();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        start();
    }
}
